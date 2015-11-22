package main.java.common.utils.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;

import java.util.TreeSet;

public final class SortedCardCategoryReturnerImpl implements SortedCardCategoryReturner {
    public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
        final TreeSet<CardCategory> sortedCardCategories = new TreeSet<>();
        for (final Card card : hand.getCards()) {
            sortedCardCategories.add(card.getCategory());
        }

        return sortedCardCategories;
    }
}
