package main.java.handCategoryCalculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.utils.impl.CardCategoryCountReturner;
import main.java.handCategoryCalculator.interfaces.HandCategoryExistenceValidator;

import java.util.HashMap;

public class TwoPairExistenceValidator implements HandCategoryExistenceValidator {
    @Override
    public boolean validateExistence(final Hand hand) {
        final HashMap<CardCategory, Integer> cardCategoryCountMap = CardCategoryCountReturner.returnCardCategoryCount(hand);
        int pairCount = 0;
        for (final Integer value : cardCategoryCountMap.values()) {
            if (2 == value) {
                pairCount++;
            }
        }

        return 2 == pairCount;
    }
}
