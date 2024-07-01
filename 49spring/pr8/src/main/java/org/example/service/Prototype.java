package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.time.LocalDateTime;

@Component
@Scope(value = "prototype")
public class Prototype {
    @Autowired
    private UserService userService;

    private LocalDateTime creationTime;

    public Prototype() {
        creationTime = LocalDateTime.now();
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public UserService getUserService() {
        return userService;
    }

    @PreDestroy
    public void destroyBean() {
        System.out.println("Singlton pre destroy called...");
    }
}
