package org.example;

import org.example.config.AppConfig;
import org.example.model.Card;
import org.example.model.User;
import org.example.service.BankService;
import org.example.service.CommissionHandler;
import org.example.service.CommissionHandlerStrategy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        User bob = new User("Bob", "Alison");
        Card bobsCard = new Card("12345", Card.CardType.USUAL);
        bob.setCard(bobsCard);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CommissionHandlerStrategy handlerStrategy = context.getBean(CommissionHandlerStrategy.class);
        CommissionHandler handler = handlerStrategy.getHandler(Card.CardType.GOLD);
        handler.getCommission(BigDecimal.valueOf(100));

    }
}