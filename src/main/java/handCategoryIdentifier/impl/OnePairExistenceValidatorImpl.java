package main.java.handCategoryIdentifier.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.utils.impl.CardCategoryCountMapperImpl;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import main.java.handCategoryIdentifier.interfaces.OnePairExistenceValidator;

import java.util.HashMap;

public class OnePairExistenceValidatorImpl implements OnePairExistenceValidator {
    @Override
    public boolean validateExistence(final Hand hand, final CardCategoryCountMapper cardCategoryCountMapper) {
        final HashMap<CardCategory, Integer> cardCategoryCountMap = cardCategoryCountMapper.returnCardCategoryCountMap(hand);
        int pairCount = 0;
        for (final Integer value : cardCategoryCountMap.values()) {
            if (2 == value) {
                pairCount++;
            }
        }

        return 1 == pairCount;
    }
}
