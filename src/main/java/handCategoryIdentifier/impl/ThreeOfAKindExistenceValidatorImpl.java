package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Hand;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import main.java.handCategoryIdentifier.interfaces.ThreeOfAKindExistenceValidator;

public class ThreeOfAKindExistenceValidatorImpl implements ThreeOfAKindExistenceValidator {
    private final CardCategoryCountMapper cardCategoryCountMapper;

    public ThreeOfAKindExistenceValidatorImpl(final CardCategoryCountMapper cardCategoryCountMapper) {
        this.cardCategoryCountMapper = cardCategoryCountMapper;
    }

    @Override
    public boolean threeOfAKindExists(final Hand hand) {
        assert null != hand;

        return cardCategoryCountMapper.returnCardCategoryCountMap(hand).containsValue(3);
    }
}
