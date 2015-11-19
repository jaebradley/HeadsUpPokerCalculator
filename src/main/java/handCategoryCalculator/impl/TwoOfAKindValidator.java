package main.java.handCategoryCalculator.impl;

import main.java.common.model.Hand;
import main.java.common.utils.impl.CardCategoryCountReturner;
import main.java.handCategoryCalculator.interfaces.HandCategoryValidator;

public class TwoOfAKindValidator implements HandCategoryValidator {
    @Override
    public boolean validateHand(final Hand hand) {
        return CardCategoryCountReturner.returnCardCategoryCount(hand).containsValue(2);
    }
}
