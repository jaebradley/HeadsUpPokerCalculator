package main.java.common.model;

import java.util.HashSet;

public class Hand {
    private final HashSet<Card> cards;

    public Hand(final HashSet<Card> inputCards) {
        assert 5 == inputCards.size();

        this.cards = inputCards;
    }

    public HashSet<Card> getCards() {
        return cards;
    }
}
