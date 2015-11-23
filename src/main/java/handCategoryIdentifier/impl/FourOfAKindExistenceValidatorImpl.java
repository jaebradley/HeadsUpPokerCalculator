package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Hand;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import main.java.handCategoryIdentifier.interfaces.FourOfAKindExistenceValidator;

public class FourOfAKindExistenceValidatorImpl implements FourOfAKindExistenceValidator {
    private final CardCategoryCountMapper cardCategoryCountMapper;

    public FourOfAKindExistenceValidatorImpl(final CardCategoryCountMapper cardCategoryCountMapper) {
        this.cardCategoryCountMapper = cardCategoryCountMapper;
    }

    @Override
    public boolean fourOfAKindExists(final Hand hand) {
        assert null != hand;

        return cardCategoryCountMapper.returnCardCategoryCountMap(hand).containsValue(4);
    }
}
