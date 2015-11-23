package main.java.hand.category.identifier.impl;

import main.java.common.model.Hand;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import main.java.hand.category.identifier.interfaces.ThreeOfAKindExistenceValidator;

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
