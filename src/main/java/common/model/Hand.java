package main.java.common.model;

import java.util.TreeSet;

public class Hand {
    private final TreeSet<Card> cards;

    public Hand(final TreeSet<Card> cards) {
        assert 5 == cards.size();

        this.cards = cards;
    }

    public TreeSet<Card> getCards() {
        return cards;
    }
}
