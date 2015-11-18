package main.java.handCategoryCalculator.impl;

import main.java.handCategoryCalculator.interfaces.HandCategoryValidator;
import main.java.common.model.Card;
import main.java.common.model.Hand;
import main.java.common.model.Suit;

import java.util.Iterator;
import java.util.TreeSet;

public final class FlushValidator implements HandCategoryValidator {
    @Override
    public boolean validateHand(final Hand hand) {
        final TreeSet<Card> cards = hand.getCards();
        final Iterator<Card> cardIterator = cards.iterator();
        final Suit firstCardSuit = cardIterator.next().getSuit();
        cardIterator.remove();
        while (cardIterator.hasNext()) {
            if (cardIterator.next().getSuit() != firstCardSuit) {
                return false;
            }
        }

        return true;
    }
}
