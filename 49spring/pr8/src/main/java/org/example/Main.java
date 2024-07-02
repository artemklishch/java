package org.example;

import org.example.config.AppConfig;
import org.example.service.Singleton;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Singleton singleton = context.getBean(Singleton.class);

        System.out.println(singleton.getPrototype().getCreationTime());
        System.out.println(singleton.getPrototype().getCreationTime());
        System.out.println(singleton.getPrototype().getCreationTime());

        System.out.println(singleton.getPrototype().getUserService().getAll());

        context.close();
    }
}