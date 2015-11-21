package main.java.common.utils.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.CardCategoryComparator;
import main.java.common.model.Hand;
import main.java.common.utils.interfaces.SortedCardCategoryCountMapper;

import java.util.TreeMap;

public class SortedCardCategoryCountMapperImpl implements SortedCardCategoryCountMapper {
    @Override
    public TreeMap<CardCategory, Integer> returnSortedCardCategoryCountAscending(final Hand hand) {
        final TreeMap<CardCategory, Integer> sortedCardCategoryCountMap = new TreeMap<>(new CardCategoryComparator());
        for (final Card card : hand.getCards()) {
            final int keyCount = sortedCardCategoryCountMap.containsKey(card.getCategory()) ? sortedCardCategoryCountMap.get(card.getCategory()) : 0;
            sortedCardCategoryCountMap.put(card.getCategory(), keyCount + 1);
        }
        return sortedCardCategoryCountMap;
    }
}
