package org.example.service;

import org.example.model.Card;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class GoldCommissionHandler implements CommissionHandler {
    @Override
    public boolean isApplicable(Card.CardType cardType) {
        return cardType.equals(Card.CardType.GOLD);
    }

    @Override
    public BigDecimal getCommission(BigDecimal amount) {
        System.out.println("GoldCommissionHandler invoked");
        return BigDecimal.ZERO;
    }
}
