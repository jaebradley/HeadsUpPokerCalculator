package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Hand;
import main.java.common.utils.impl.CardCategoryCountReturner;
import main.java.handCategoryIdentifier.interfaces.ThreeOfAKindExistenceValidator;

public class ThreeOfAKindExistenceValidatorImpl implements ThreeOfAKindExistenceValidator {
    @Override
    public boolean validateExistence(final Hand hand) {
        return CardCategoryCountReturner.returnCardCategoryCount(hand).containsValue(3);
    }
}
