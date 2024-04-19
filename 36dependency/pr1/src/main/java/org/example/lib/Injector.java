package org.example.lib;

import org.example.ClientApp;
import org.example.services.AccountService;
import org.example.services.BankService;
import org.example.services.impl.AccountServiceImpl;
import org.example.services.impl.BankServiceImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Injector {
    // initialization fields is here
    private static final Injector injector = new Injector();

    private Map<Class<?>, Object> instances = new HashMap<>();

    public static Injector getInjector(){
        return injector;
    }

    public Object getInstance(Class<?> interfaceClass) {
        Object classImplementationInstance = null
        Class<?> clazz = findImplementation(interfaceClass);
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field: declaredFields) {
            if (field.isAnnotationPresent(Inject.class)){
                // we need to initialize

                // create the object to which we need to assign the nest value
                // field type object
                 Object fieldInstance = getInstance(field.getType());

                 // create the object that we assign the prev value
                // interface object
                classImplementationInstance = createNewInstance(clazz);

                // set the interface object to the field type object
                try {
                    field.setAccessible(true); // we do it because the field can be or is private
                    field.set(classImplementationInstance, fieldInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(
                            "Can't initialize field value. Class: " + clazz.getName()
                                    + ". Field: " + field.getName()
                    );
                }
            }
        }
        if (classImplementationInstance == null) {
            classImplementationInstance = createNewInstance(clazz);
        }
        return classImplementationInstance;
    }

    private Object createNewInstance(Class<?> clazz) {
        // if we create an object - let's use it
        if (instances.containsKey(clazz)) {
            return instances.get(clazz);
        }
        // create a new object
        try {
            Constructor<?> constructor = clazz.getConstructor();
            Object instance = constructor.newInstance();
            instances.put(clazz, instance);
            return instance;
        } catch (
                NoSuchMethodException | InvocationTargetException
                | InstantiationException | IllegalAccessException e
        ) {
            throw new RuntimeException("Can't create a new instance of  " + clazz.getName());
        }
    }

    private Class<?> findImplementation(Class<?> interfaceClass) {
        Map<Class<?>, Class<?>> interfaceImplementations = new HashMap<>();
        interfaceImplementations.put(BankService.class, BankServiceImpl.class);
        interfaceImplementations.put(AccountService.class, AccountServiceImpl.class);
        if (interfaceClass.isInterface()) {
            return interfaceImplementations.get(interfaceClass);
        }
        return interfaceClass;
    }
}
