package main.java.hand.category.identifier.impl;

import main.java.common.model.Hand;
import main.java.common.utils.interfaces.CardCategoryPairCounter;
import main.java.hand.category.identifier.interfaces.OnePairExistenceValidator;

public class OnePairExistenceValidatorImpl implements OnePairExistenceValidator {
    private final CardCategoryPairCounter cardCategoryPairCounter;

    public OnePairExistenceValidatorImpl(final CardCategoryPairCounter cardCategoryPairCounter) {
        this.cardCategoryPairCounter = cardCategoryPairCounter;
    }

    @Override
    public boolean onePairExists(final Hand hand) {
        assert null != hand;

        return 1 == cardCategoryPairCounter.countCardCategoryPairs(hand);
    }
}
