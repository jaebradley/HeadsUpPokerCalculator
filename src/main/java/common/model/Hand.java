package main.java.common.model;

import java.util.Set;

public class Hand {
    private final Set<Card> cards;

    public Hand(final Set<Card> inputCards) {
        assert null != inputCards;
        assert 5 == inputCards.size();

        this.cards = inputCards;
    }

    public Set<Card> getCards() {
        return cards;
    }
}
