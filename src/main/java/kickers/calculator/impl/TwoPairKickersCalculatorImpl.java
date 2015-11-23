package main.java.kickers.calculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.kickers.TwoPairKickers;
import main.java.common.utils.interfaces.SortedCardCategoryMapper;
import main.java.kickers.calculator.exceptions.HandDoesNotContainThreeDistinctCardCategoriesException;
import main.java.kickers.calculator.exceptions.HandDoesNotContainTwoOfAKindException;
import main.java.kickers.calculator.interfaces.TwoPairKickersCalculator;

import java.util.Map;
import java.util.TreeMap;

public class TwoPairKickersCalculatorImpl implements TwoPairKickersCalculator {
    private final SortedCardCategoryMapper sortedCardCategoryMapper;

    public TwoPairKickersCalculatorImpl(final SortedCardCategoryMapper sortedCardCategoryMapper) {
        this.sortedCardCategoryMapper = sortedCardCategoryMapper;
    }

    @Override
    public TwoPairKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainThreeDistinctCardCategoriesException,
            HandDoesNotContainTwoOfAKindException {
        final TreeMap<CardCategory, Integer> cardCategoryIntegerTreeMap = sortedCardCategoryMapper.returnSortedCardCategoryAscending(hand);

        if (3 != cardCategoryIntegerTreeMap.size()) {
            throw new HandDoesNotContainThreeDistinctCardCategoriesException();
        }

        if (!cardCategoryIntegerTreeMap.containsValue(2)) {
            throw new HandDoesNotContainTwoOfAKindException();
        }

        CardCategory highestPairCardCategory = null;
        CardCategory lowestPairCardCategory = null;
        CardCategory remainingCardCategory = null;

        for (Map.Entry<CardCategory, Integer> entry : cardCategoryIntegerTreeMap.entrySet()) {
            if (2 == entry.getValue()) {
                if (null == lowestPairCardCategory) {
                    lowestPairCardCategory = entry.getKey();
                } else if (null == highestPairCardCategory) {
                    highestPairCardCategory = entry.getKey();
                } else {
                    throw new RuntimeException("unexpected");
                }
            } else if (1 == entry.getValue()) {
                if (null == remainingCardCategory) {
                    remainingCardCategory = entry.getKey();
                }
            } else {
                throw new RuntimeException("unexpected");
            }
        }

        if (null == highestPairCardCategory || null == lowestPairCardCategory || null == remainingCardCategory) {
            throw new RuntimeException("unexpected");
        }

        return new TwoPairKickers(
                highestPairCardCategory,
                lowestPairCardCategory,
                remainingCardCategory
        );
    }
}
