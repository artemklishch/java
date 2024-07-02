package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Singleton {
    @Autowired
    private Prototype prototype;

    public Singleton() {
//        prototype = new Prototype();
    }

    @PostConstruct
    public void init() {
        System.out.println("Singleton post construct");
    }

    @Lookup // for creating different beans of Prototype
    public Prototype getPrototype() {
        return prototype;
//        return new Prototype(); // very bad practise
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Singleton pre destroy called...");
    }
}
