package main.java.hand.category.identifier.impl;

import main.java.common.model.Card;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import main.java.hand.category.identifier.interfaces.FlushExistenceValidator;

import java.util.Iterator;
import java.util.Set;

public final class FlushExistenceValidatorImpl implements FlushExistenceValidator {
    @Override
    public boolean flushExists(final Hand hand) {
        assert null != hand;

        final Set<Card> cards = hand.getCards();
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
