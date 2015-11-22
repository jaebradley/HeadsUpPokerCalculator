package main.java.kickersCalculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.FullHouseKickers;
import main.java.common.model.Hand;
import main.java.kickersCalculator.exceptions.HandDoesNotContainThreeOfAKindException;
import main.java.kickersCalculator.exceptions.HandDoesNotContainTwoOfAKindException;
import main.java.kickersCalculator.interfaces.FullHouseKickersCalculator;

import java.util.HashMap;
import java.util.Map;

public class FullHouseKickersCalculatorImpl implements FullHouseKickersCalculator {
    @Override
    public FullHouseKickers calculateKickers(
            final Hand hand,
            final CardCategoryCountMapper cardCategoryCountMapper
    ) throws HandDoesNotContainThreeOfAKindException, HandDoesNotContainTwoOfAKindException {
        final HashMap<CardCategory, Integer> cardCategoryIntegerHashMap = cardCategoryCountMapper.returnCardCategoryCountMap(hand);

        if (!(cardCategoryIntegerHashMap.containsValue(3))) {
            throw new HandDoesNotContainThreeOfAKindException();
        }

        if (!(cardCategoryIntegerHashMap.containsValue(2))) {
            throw new HandDoesNotContainTwoOfAKindException();
        }

        CardCategory threeOfAKindCardCategory = null;
        CardCategory twoOfAKindCardCategory = null;
        for (final Map.Entry<CardCategory, Integer> entry : cardCategoryIntegerHashMap.entrySet()) {
            if (3 == entry.getValue()) {
                threeOfAKindCardCategory = entry.getKey();
            }

            if (2 == entry.getValue()) {
                twoOfAKindCardCategory = entry.getKey();
            }
        }

        return new FullHouseKickers(
                threeOfAKindCardCategory,
                twoOfAKindCardCategory
        );
    }
}
