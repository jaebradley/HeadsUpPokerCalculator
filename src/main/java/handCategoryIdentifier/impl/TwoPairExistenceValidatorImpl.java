package main.java.handCategoryIdentifier.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.utils.impl.CardCategoryCountMapperImpl;
import main.java.handCategoryIdentifier.interfaces.TwoPairExistenceValidator;

import java.util.HashMap;

public class TwoPairExistenceValidatorImpl implements TwoPairExistenceValidator {
    @Override
    public boolean validateExistence(final Hand hand) {
        final HashMap<CardCategory, Integer> cardCategoryCountMap = CardCategoryCountMapperImpl.returnCardCategoryCountMap(hand);
        int pairCount = 0;
        for (final Integer value : cardCategoryCountMap.values()) {
            if (2 == value) {
                pairCount++;
            }
        }

        return 2 == pairCount;
    }
}
