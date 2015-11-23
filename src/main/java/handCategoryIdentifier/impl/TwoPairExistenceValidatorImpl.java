package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Hand;
import main.java.common.utils.interfaces.CardCategoryPairCounter;
import main.java.handCategoryIdentifier.interfaces.TwoPairExistenceValidator;

public class TwoPairExistenceValidatorImpl implements TwoPairExistenceValidator {
    private final CardCategoryPairCounter cardCategoryPairCounter;

    public TwoPairExistenceValidatorImpl(final CardCategoryPairCounter cardCategoryPairCounter) {
        this.cardCategoryPairCounter = cardCategoryPairCounter;
    }

    @Override
    public boolean twoPairExists(final Hand hand) {
        assert null != hand;

        return 2 == cardCategoryPairCounter.countCardCategoryPairs(hand);
    }
}
