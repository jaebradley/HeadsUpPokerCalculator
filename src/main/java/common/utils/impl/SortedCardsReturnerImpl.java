package main.java.common.utils.impl;

import main.java.common.model.Card;
import main.java.common.model.CardComparator;
import main.java.common.model.Hand;
import main.java.common.utils.interfaces.SortedCardsReturner;

import java.util.TreeSet;

public class SortedCardsReturnerImpl implements SortedCardsReturner {
    @Override
    public TreeSet<Card> returnSortedCardsAscending(final Hand hand) {
        final TreeSet<Card> sortedCards = new TreeSet<>(new CardComparator());
        sortedCards.addAll(hand.getCards());
        return sortedCards;
    }
}
