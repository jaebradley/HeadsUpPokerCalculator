package java.main.handCategoryCalculator.impl;

import java.main.common.model.Card;
import java.main.common.model.Hand;
import java.main.common.model.Suit;
import java.main.handCategoryCalculator.interfaces.HandCategoryValidator;

public class FlushValidator implements HandCategoryValidator {
    @Override
    public boolean validateHand(final Hand hand) {
        final Card[] cards = hand.getCards();
        final Suit firstCardSuit = cards[0].getSuit();
        for (int i = 1; i < cards.length; i++) {
            if (cards[i].getSuit() != firstCardSuit) {
                return false;
            }
        }

        return true;
    }
}
