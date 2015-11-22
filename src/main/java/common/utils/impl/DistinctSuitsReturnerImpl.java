package main.java.common.utils.impl;

import main.java.common.model.Card;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import main.java.common.utils.interfaces.DistinctSuitsReturner;

import java.util.HashSet;

public class DistinctSuitsReturnerImpl implements DistinctSuitsReturner {
    @Override
    public HashSet<Suit> returnDistinctSuits(final Hand hand) {
        assert null != hand;

        final HashSet<Suit> distinctSuits = new HashSet<>();

        for (final Card card : hand.getCards()) {
            distinctSuits.add(card.getSuit());
        }

        return distinctSuits;
    }
}
