package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Hand;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import main.java.handCategoryIdentifier.interfaces.FourOfAKindExistenceValidator;

public class FourOfAKindExistenceValidatorImpl implements FourOfAKindExistenceValidator {

    @Override
    public boolean validateExistence(final Hand hand, final CardCategoryCountMapper cardCategoryCountMapper) {
        return cardCategoryCountMapper.returnCardCategoryCountMap(hand).containsValue(4);
    }
}
