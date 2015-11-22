package main.java.kickersCalculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.ThreeOfAKindKickers;
import main.java.kickersCalculator.exceptions.HandDoesNotContainThreeDistinctCardCategoriesException;
import main.java.kickersCalculator.exceptions.HandDoesNotContainThreeOfAKindException;
import main.java.kickersCalculator.interfaces.ThreeOfAKindKickersCalculator;

import java.util.Map;
import java.util.TreeMap;

public class ThreeOfAKindKickersCalculatorImpl implements ThreeOfAKindKickersCalculator {
    @Override
    public ThreeOfAKindKickers calculateKickers(
            final Hand hand,
            final SortedCardCategoryMapper sortedCardCategoryMapper
    ) throws HandDoesNotContainThreeOfAKindException,
            HandDoesNotContainThreeDistinctCardCategoriesException
    {
        final TreeMap<CardCategory, Integer> cardCategoryIntegerTreeMap = sortedCardCategoryMapper.returnSortedCardCategoryAscending(hand);

        if (!cardCategoryIntegerTreeMap.containsValue(3)) {
            throw new HandDoesNotContainThreeOfAKindException();
        }

        if (3 != cardCategoryIntegerTreeMap.size()) {
            throw new HandDoesNotContainThreeDistinctCardCategoriesException();
        }

        CardCategory threeOfAKindCardCategory = null;
        CardCategory highestRemainingCardCategory = null;
        CardCategory lowestRemainingCardCategory = null;

        for (Map.Entry<CardCategory, Integer> entry : cardCategoryIntegerTreeMap.entrySet()) {
            if (3 == entry.getValue()) {
                threeOfAKindCardCategory = entry.getKey();
            }

            else if (null == lowestRemainingCardCategory) {
                lowestRemainingCardCategory = entry.getKey();
            }

            else if (null == highestRemainingCardCategory) {
                highestRemainingCardCategory = entry.getKey();
            }


            else {
                throw new RuntimeException("unexpected");
            }
        }

        return new ThreeOfAKindKickers(
                threeOfAKindCardCategory,
                highestRemainingCardCategory,
                lowestRemainingCardCategory
        );
    }
}
