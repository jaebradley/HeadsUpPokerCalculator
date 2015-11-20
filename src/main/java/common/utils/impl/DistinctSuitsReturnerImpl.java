package main.java.common.utils.impl;

import main.java.common.model.Card;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import main.java.common.utils.interfaces.DistinctSuitsReturner;

import java.util.HashSet;

public class DistinctSuitsReturnerImpl implements DistinctSuitsReturner {
    @Override
    public HashSet<Suit> returnDistinctSuits(final Hand hand) {
        final HashSet<Suit> suits = new HashSet<>();
        for (final Card card : hand.getCards()) {
            // Naive implementation
            suits.add(card.getSuit());
        }
        return suits;
    }
}
