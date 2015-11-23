package main.java.kickers.calculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.kickers.FourOfAKindKickers;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import main.java.kickers.calculator.exceptions.HandDoesNotContainFourOfAKindException;
import main.java.kickers.calculator.exceptions.HandDoesNotContainOneOfAKindException;
import main.java.kickers.calculator.exceptions.HandDoesNotContainTwoDistinctCardCategoriesException;
import main.java.kickers.calculator.interfaces.FourOfAKindKickersCalculator;

import java.util.HashMap;
import java.util.Map;

public class FourOfAKindKickersCalculatorImpl implements FourOfAKindKickersCalculator {
    private final CardCategoryCountMapper cardCategoryCountMapper;

    public FourOfAKindKickersCalculatorImpl(final CardCategoryCountMapper cardCategoryCountMapper) {
        this.cardCategoryCountMapper = cardCategoryCountMapper;
    }

    @Override
    public FourOfAKindKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainFourOfAKindException,
            HandDoesNotContainTwoDistinctCardCategoriesException,
            HandDoesNotContainOneOfAKindException
    {
        assert null != hand;

        final HashMap<CardCategory, Integer> cardCategoryIntegerHashMap = cardCategoryCountMapper.returnCardCategoryCountMap(hand);

        assert null != cardCategoryIntegerHashMap;

        if (2 != cardCategoryIntegerHashMap.size()) {
            throw new HandDoesNotContainTwoDistinctCardCategoriesException();
        }

        if (!cardCategoryIntegerHashMap.containsValue(4)) {
            throw new HandDoesNotContainFourOfAKindException();
        }

        if (!cardCategoryIntegerHashMap.containsValue(1)) {
            throw new HandDoesNotContainOneOfAKindException();
        }

        CardCategory fourOfAKindCardCategory = null;
        CardCategory remainingCardCategory = null;
        for (final Map.Entry<CardCategory, Integer> entry : cardCategoryIntegerHashMap.entrySet()) {

            switch (entry.getValue()) {
                case 4: {
                    fourOfAKindCardCategory = entry.getKey();
                    break;
                }

                case 1: {
                    remainingCardCategory = entry.getKey();
                    break;
                }

                default: {
                    throw new RuntimeException("unexpected");
                }
            }
        }

        if (null == fourOfAKindCardCategory || null == remainingCardCategory) {
            throw new RuntimeException("unexpected");
        }

        return new FourOfAKindKickers(
                fourOfAKindCardCategory,
                remainingCardCategory
        );
    }
}
