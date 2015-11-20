package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Hand;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import main.java.common.utils.interfaces.CardCategoryPairCounter;
import main.java.handCategoryIdentifier.interfaces.OnePairExistenceValidator;

public class OnePairExistenceValidatorImpl implements OnePairExistenceValidator {
    @Override
    public boolean validateExistence(final Hand hand, final CardCategoryPairCounter cardCategoryPairCounter, final CardCategoryCountMapper cardCategoryCountMapper) {
        return 1 == cardCategoryPairCounter.countCardCategoryPairs(hand, cardCategoryCountMapper);
    }
}
