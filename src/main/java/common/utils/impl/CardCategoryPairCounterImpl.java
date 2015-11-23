package main.java.common.utils.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import main.java.common.utils.interfaces.CardCategoryPairCounter;

import java.util.HashMap;

public final class CardCategoryPairCounterImpl implements CardCategoryPairCounter {
    private final CardCategoryCountMapper cardCategoryCountMapper;

    public CardCategoryPairCounterImpl(final CardCategoryCountMapper cardCategoryCountMapper) {
        this.cardCategoryCountMapper = cardCategoryCountMapper;
    }

    public int countCardCategoryPairs(final Hand hand) {
        assert null != hand;

        final HashMap<CardCategory, Integer> cardCategoryCountMap = cardCategoryCountMapper.returnCardCategoryCountMap(hand);

        assert null != cardCategoryCountMap;

        int pairCount = 0;

        if (!cardCategoryCountMap.containsValue(2)) {
            return pairCount;
        }

        for (final Integer value : cardCategoryCountMap.values()) {
            if (2 == value) {
                pairCount++;
            }
        }

        return pairCount;
    }
}
