package main.java.kickers.calculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.OnePairKickers;
import main.java.common.utils.interfaces.SortedCardCategoryMapper;
import main.java.kickers.calculator.exceptions.HandDoesNotContainFourDistinctCardCategoriesException;
import main.java.kickers.calculator.exceptions.HandDoesNotContainTwoOfAKindException;
import main.java.kickers.calculator.interfaces.OnePairKickersCalculator;

import java.util.Map;
import java.util.TreeMap;

public class OnePairKickersCalculatorImpl implements OnePairKickersCalculator {
    private final SortedCardCategoryMapper sortedCardCategoryMapper;

    public OnePairKickersCalculatorImpl(final SortedCardCategoryMapper sortedCardCategoryMapper) {
        this.sortedCardCategoryMapper = sortedCardCategoryMapper;
    }

    @Override
    public OnePairKickers calculateKickers(
            final Hand hand
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
