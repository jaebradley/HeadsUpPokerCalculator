package main.java.common.utils.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;

import java.util.HashSet;
import java.util.TreeSet;

public class UniqueCardCategoryCounter {
    public static int countUniqueCardCategories(final Hand hand) {
        final HashSet<CardCategory> uniqueCardCategories = new HashSet<>();
        final TreeSet<Card> orderedCards = hand.getCardsOrderedByCategory();
        for (final Card card : orderedCards) {
            uniqueCardCategories.add(card.getCategory());
        }

        return uniqueCardCategories.size();
    }
}
