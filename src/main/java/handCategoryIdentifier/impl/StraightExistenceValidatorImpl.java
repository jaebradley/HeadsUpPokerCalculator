package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.utils.impl.SortedCardsReturnerImpl;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import main.java.common.utils.interfaces.SortedCardsReturner;
import main.java.handCategoryIdentifier.interfaces.StraightExistenceValidator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class StraightExistenceValidatorImpl implements StraightExistenceValidator {
    @Override
    public boolean validateExistence(final Hand hand, final SortedCardCategoryReturner sortedCardCategoryReturner) {
        final TreeSet<CardCategory> cardCategories = sortedCardCategoryReturner.returnCardCategoriesInAscendingOrder(hand);
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
