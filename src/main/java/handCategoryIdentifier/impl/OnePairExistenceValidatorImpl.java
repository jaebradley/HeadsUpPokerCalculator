package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Hand;
import main.java.common.utils.interfaces.CardCategoryPairCounter;
import main.java.handCategoryIdentifier.interfaces.OnePairExistenceValidator;

public class OnePairExistenceValidatorImpl implements OnePairExistenceValidator {
    private final CardCategoryPairCounter cardCategoryPairCounter;

    public OnePairExistenceValidatorImpl(final CardCategoryPairCounter cardCategoryPairCounter) {
        this.cardCategoryPairCounter = cardCategoryPairCounter;
    }

    @Override
    public boolean onePairExists(final Hand hand) {
        return 1 == cardCategoryPairCounter.countCardCategoryPairs(hand);
    }
}
