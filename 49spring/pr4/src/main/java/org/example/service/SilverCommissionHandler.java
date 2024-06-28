package org.example.service;

import org.example.model.Card;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SilverCommissionHandler implements CommissionHandler{
    @Override
    public BigDecimal getCommission(BigDecimal amount) {
        System.out.println("SilverCommissionHandler invoked");
        return BigDecimal.ZERO;
    }

    @Override
    public boolean isApplicable(Card.CardType cardType) {
        return cardType.equals(Card.CardType.SILVER);
    }
}
