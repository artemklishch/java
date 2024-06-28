package org.example.service;

import org.example.model.Card;

import java.math.BigDecimal;

public interface CommissionHandler {
    BigDecimal getCommission(BigDecimal amount);

    boolean isApplicable(Card.CardType cardType);
}
