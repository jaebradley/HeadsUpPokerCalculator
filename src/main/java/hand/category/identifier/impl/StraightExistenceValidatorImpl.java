package main.java.hand.category.identifier.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import main.java.hand.category.identifier.interfaces.StraightExistenceValidator;

import java.util.TreeSet;

public class StraightExistenceValidatorImpl implements StraightExistenceValidator {
    private final SortedCardCategoryReturner sortedCardCategoryReturner;

    public StraightExistenceValidatorImpl(final SortedCardCategoryReturner sortedCardCategoryReturner) {
        this.sortedCardCategoryReturner = sortedCardCategoryReturner;
    }

    public boolean straightExists(final Hand hand) {
        assert null != hand;

        final TreeSet<CardCategory> cardCategories = sortedCardCategoryReturner.returnCardCategoriesInAscendingOrder(hand);

        assert null != cardCategories;

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
