package main.java.handCategoryIdentifier.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.utils.impl.SortedCardCategoryReturnerImpl;

import java.util.TreeSet;

public class StraightExistenceValidatorImpl {
    public boolean validateExistence(final Hand hand) {
        final TreeSet<CardCategory> cardCategories = SortedCardCategoryReturnerImpl.returnCardCategoriesInAscendingOrder(hand);
        return  (5 == cardCategories.size()) &&
                (
                        (
                                cardCategories.contains(CardCategory.ACE) &&
                                cardCategories.contains(CardCategory.TWO) &&
                                cardCategories.contains(CardCategory.THREE) &&
                                cardCategories.contains(CardCategory.FOUR) &&
                                cardCategories.contains(CardCategory.FIVE)
                        ) ||
                        (
                                4 == cardCategories.last().getValue() - cardCategories.first().getValue()
                        )
                );
    }
}
