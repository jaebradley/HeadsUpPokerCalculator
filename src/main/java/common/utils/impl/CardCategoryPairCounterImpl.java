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
        final HashMap<CardCategory, Integer> cardCategoryCountMap = cardCategoryCountMapper.returnCardCategoryCountMap(hand);
        int pairCount = 0;
        for (final Integer value : cardCategoryCountMap.values()) {
            if (2 == value) {
                pairCount++;
            }
        }

        return pairCount;
    }
}
