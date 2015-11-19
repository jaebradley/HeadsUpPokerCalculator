package main.java.handCategoryCalculator.impl;

import main.java.common.model.Hand;
import main.java.common.utils.impl.CardCategoryCountReturner;
import main.java.handCategoryCalculator.interfaces.HandCategoryExistenceValidator;

public class ThreeOfAKindExistenceValidator implements HandCategoryExistenceValidator {
    @Override
    public boolean validateExistence(final Hand hand) {
        return CardCategoryCountReturner.returnCardCategoryCount(hand).containsValue(3);
    }
}
