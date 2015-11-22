package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Hand;
import main.java.common.utils.impl.CardCategoryCountMapperImpl;
import main.java.handCategoryIdentifier.interfaces.HandCategoryExistenceValidator;

public class ThreeOfAKindExistenceValidatorImpl implements HandCategoryExistenceValidator {
    @Override
    public boolean validateExistence(final Hand hand) {
        return CardCategoryCountMapperImpl.returnCardCategoryCountMap(hand).containsValue(3);
    }
}
