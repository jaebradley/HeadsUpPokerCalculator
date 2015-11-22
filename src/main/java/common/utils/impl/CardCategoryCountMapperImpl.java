package main.java.common.utils.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.utils.interfaces.CardCategoryCountMapper;

import java.util.HashMap;

public class CardCategoryCountMapperImpl implements CardCategoryCountMapper {
    @Override
    public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
        assert null != hand;

        final HashMap<CardCategory, Integer> cardCategoryCountMap = new HashMap<>();
        for (final Card card : hand.getCards()) {
            final int keyCount = cardCategoryCountMap.containsKey(card.getCategory()) ? cardCategoryCountMap.get(card.getCategory()) : 0;
            cardCategoryCountMap.put(card.getCategory(), keyCount + 1);
        }
        return cardCategoryCountMap;
    }
}
