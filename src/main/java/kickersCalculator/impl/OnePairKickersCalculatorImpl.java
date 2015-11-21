package main.java.kickersCalculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.OnePairKickers;
import main.java.common.utils.interfaces.SortedCardCategoryMapper;
import main.java.kickersCalculator.exceptions.HandDoesNotContainFourDistinctCardCategoriesException;
import main.java.kickersCalculator.exceptions.HandDoesNotContainTwoOfAKindException;
import main.java.kickersCalculator.interfaces.OnePairKickersCalculator;

import java.util.Map;
import java.util.TreeMap;

public class OnePairKickersCalculatorImpl implements OnePairKickersCalculator {
    @Override
    public OnePairKickers calculateKickers(
            final Hand hand,
            final SortedCardCategoryMapper sortedCardCategoryMapper
    ) throws HandDoesNotContainFourDistinctCardCategoriesException,
            HandDoesNotContainTwoOfAKindException{
        final TreeMap<CardCategory, Integer> sortedCardCategoryMap = sortedCardCategoryMapper.returnSortedCardCategoryAscending(hand);

        if (4 != sortedCardCategoryMap.size()) {
            throw new HandDoesNotContainFourDistinctCardCategoriesException();
        }

        if (!sortedCardCategoryMap.containsValue(2)) {
            throw new HandDoesNotContainTwoOfAKindException();
        }

        CardCategory pairCardCategory = null;
        CardCategory highestRemainingCardCategory = null;
        CardCategory secondHighestRemainingCardCategory = null;
        CardCategory lowestRemainingCardCategory = null;

        for (Map.Entry<CardCategory, Integer> entry : sortedCardCategoryMap.entrySet()) {
            if (2 == entry.getValue()) {
                pairCardCategory = entry.getKey();
            } else {

                if (null == lowestRemainingCardCategory) {
                    lowestRemainingCardCategory = entry.getKey();
                } else if (null == secondHighestRemainingCardCategory) {
                    secondHighestRemainingCardCategory = entry.getKey();
                } else if (null == highestRemainingCardCategory) {
                    highestRemainingCardCategory = entry.getKey();
                }
            }
        }

        if (null == pairCardCategory || null == highestRemainingCardCategory || null == secondHighestRemainingCardCategory || null == lowestRemainingCardCategory) {
            throw new RuntimeException("unexpected");
        }

        return new OnePairKickers(
                pairCardCategory,
                highestRemainingCardCategory,
                secondHighestRemainingCardCategory,
                lowestRemainingCardCategory
        );
    }
}
