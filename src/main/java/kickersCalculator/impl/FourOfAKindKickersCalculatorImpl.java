package main.java.kickersCalculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.FourOfAKindKickers;
import main.java.common.model.Hand;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import main.java.kickersCalculator.interfaces.FourOfAKindKickersCalculator;

import java.util.HashMap;
import java.util.Map;

public class FourOfAKindKickersCalculatorImpl implements FourOfAKindKickersCalculator {
    @Override
    public FourOfAKindKickers calculateKickers(final Hand hand, final CardCategoryCountMapper cardCategoryCountMapper) {
        final HashMap<CardCategory, Integer> cardCategoryIntegerHashMap = cardCategoryCountMapper.returnCardCategoryCountMap(hand);
        CardCategory fourOfAKindCardCategory = null;
        CardCategory remainingCardCategory = null;
        for (final Map.Entry<CardCategory, Integer> entry : cardCategoryIntegerHashMap.entrySet()) {
            if (4 == entry.getValue()) {
                fourOfAKindCardCategory = entry.getKey();
            }

            if (1 == entry.getValue()) {
                remainingCardCategory = entry.getKey();
            }
        }
        return new FourOfAKindKickers(
                fourOfAKindCardCategory,
                remainingCardCategory
        );
    }
}
