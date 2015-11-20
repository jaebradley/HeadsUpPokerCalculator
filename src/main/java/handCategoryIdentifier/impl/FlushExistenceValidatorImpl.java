package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Card;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import main.java.common.utils.interfaces.DistinctSuitsReturner;
import main.java.handCategoryIdentifier.interfaces.FlushExistenceValidator;

import java.util.HashSet;
import java.util.Iterator;

public final class FlushExistenceValidatorImpl implements FlushExistenceValidator {
    @Override
    public boolean validateExistence(final Hand hand, final DistinctSuitsReturner distinctSuitsReturner) {
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
