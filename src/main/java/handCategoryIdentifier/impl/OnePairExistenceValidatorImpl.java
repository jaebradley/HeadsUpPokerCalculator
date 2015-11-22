package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Hand;
import main.java.common.utils.impl.CardCategoryPairCounterImpl;
import main.java.handCategoryIdentifier.interfaces.HandCategoryExistenceValidator;

public class OnePairExistenceValidatorImpl implements HandCategoryExistenceValidator {
    @Override
    public boolean validateExistence(final Hand hand) {
        return 1 == CardCategoryPairCounterImpl.countCardCategoryPairs(hand);
    }
}
