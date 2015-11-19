package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Card;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import main.java.handCategoryIdentifier.interfaces.HandCategoryExistenceValidator;

import java.util.HashSet;
import java.util.Iterator;

public final class FlushExistenceValidatorImpl implements HandCategoryExistenceValidator {
    @Override
    public boolean validateExistence(final Hand hand) {
        final HashSet<Card> cards = hand.getCards();
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
