package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Hand;
import main.java.common.utils.impl.CardCategoryPairCounterImpl;
import main.java.handCategoryIdentifier.interfaces.HandCategoryExistenceValidator;

public class TwoPairExistenceValidatorImpl implements HandCategoryExistenceValidator {
    @Override
    public boolean validateExistence(final Hand hand) {
        return 2 == CardCategoryPairCounterImpl.countCardCategoryPairs(hand);
    }
}
