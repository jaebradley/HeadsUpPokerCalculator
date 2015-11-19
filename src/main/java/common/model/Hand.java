package main.java.common.model;

import java.util.Set;
import java.util.TreeSet;

public class Hand {
    private final TreeSet<Card> cards;

    public Hand(final Set<Card> inputCards) {
        assert 5 == inputCards.size();

        this.cards = new TreeSet<>(new CardComparator());
        for (final Card card : inputCards) {
            this.cards.add(card);
        }
    }

    public TreeSet<Card> getCards() {
        return cards;
    }
}
