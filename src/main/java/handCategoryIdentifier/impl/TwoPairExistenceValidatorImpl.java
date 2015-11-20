package main.java.handCategoryIdentifier.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import main.java.common.utils.interfaces.CardCategoryPairCounter;
import main.java.handCategoryIdentifier.interfaces.TwoPairExistenceValidator;

import java.util.HashMap;

public class TwoPairExistenceValidatorImpl implements TwoPairExistenceValidator {
    @Override
    public boolean validateExistence(final Hand hand, final CardCategoryPairCounter cardCategoryPairCounter, final CardCategoryCountMapper cardCategoryCountMapper) {
        return 2 == cardCategoryPairCounter.countCardCategoryPairs(hand, cardCategoryCountMapper);
    }
}
