package org.example.service;

import org.example.model.Card;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
//@Primary // it means that this realization will be by default
public class UsualCommissionHandler implements CommissionHandler {
    @Override
    public BigDecimal getCommission(BigDecimal amount) {
        System.out.println("UsualCommissionHandler invoked");
        return amount.multiply(BigDecimal.valueOf(0.05));
    }

    @Override
    public boolean isApplicable(Card.CardType cardType) {
        return cardType.equals(Card.CardType.USUAL);
    }
}
