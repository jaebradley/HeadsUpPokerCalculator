package main.java.common.utils.interfaces;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;

import java.util.TreeSet;

public interface SortedCardCategoryReturner {
    TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand);
}
