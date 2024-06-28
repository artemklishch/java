package org.example.model;


import jakarta.persistence.*;

public class Card {
    private String cardNumber;
    private CardType cardtype;

    public Card(String cardNumber, CardType cardtype) {
        this.cardNumber = cardNumber;
        this.cardtype = cardtype;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CardType getCardtype() {
        return cardtype;
    }

    public void setCardtype(CardType cardtype) {
        this.cardtype = cardtype;
    }

    @Override
    public String toString() {
        return "Card{" +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardtype=" + cardtype +
                '}';
    }

    public enum CardType {
        USUAL, GOLD, SILVER
    }
}
