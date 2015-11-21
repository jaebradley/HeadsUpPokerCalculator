package main.java.common.utils.interfaces;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;

import java.util.TreeMap;

public interface SortedCardCategoryCountMapper {
    TreeMap<CardCategory, Integer> returnSortedCardCategoryCountAscending(final Hand hand);
}
