package org.example;

import org.example.app.AtmApp;
import org.example.lib.Injector;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Dependency Injection
        // Inversion of Control
        // Dependency Inversion
        Injector injector = Injector.getInjector();
        ClientApp clientApp = (ClientApp) injector.getInstance(ClientApp.class);

//        ClientApp clientApp = new ClientApp();
        clientApp.login("bob", "1234");
        clientApp.sendMoney("5678", BigDecimal.valueOf(100));

        AtmApp atmApp = (AtmApp) injector.getInstance(AtmApp.class);
    }
}