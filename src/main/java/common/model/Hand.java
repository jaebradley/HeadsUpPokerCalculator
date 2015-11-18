package main.java.common.model;

import java.util.HashSet;

public class Hand {
    private final HashSet<Card> cards;

    public Hand(final HashSet<Card> cards) {
        this.cards = cards;
    }

    public HashSet<Card> getCards() {
        return cards;
    }
}
