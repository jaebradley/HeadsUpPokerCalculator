package main.java.common.model;

import java.util.HashSet;
import java.util.TreeSet;

public class Hand {
    private final HashSet<Card> cards;

    public Hand(final HashSet<Card> inputCards) {
        assert 5 == inputCards.size();

        this.cards = inputCards;
    }

    public HashSet<Card> getCards() {
        return cards;
    }

    public TreeSet<Card> getSortedCardsInAscendingCategoryOrder() {
        final TreeSet<Card> sortedCards = new TreeSet<>(new CardComparator());
        sortedCards.addAll(this.cards);
        return sortedCards;
    }
}
