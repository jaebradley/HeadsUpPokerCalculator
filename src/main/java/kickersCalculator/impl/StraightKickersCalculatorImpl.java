package main.java.kickersCalculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.StraightKickers;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import main.java.kickersCalculator.exceptions.HandDoesNotContainFiveDistinctCardCategoriesException;
import main.java.kickersCalculator.interfaces.StraightKickersCalculator;

import java.util.TreeSet;

public class StraightKickersCalculatorImpl implements StraightKickersCalculator {
    private final SortedCardCategoryReturner sortedCardCategoryReturner;

    public StraightKickersCalculatorImpl(final SortedCardCategoryReturner sortedCardCategoryReturner) {
        this.sortedCardCategoryReturner = sortedCardCategoryReturner;
    }

    @Override
    public StraightKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainFiveDistinctCardCategoriesException {
        final TreeSet<CardCategory> sortedCardCategories = sortedCardCategoryReturner.returnCardCategoriesInAscendingOrder(hand);

        if (5 != sortedCardCategories.size()) {
            throw new HandDoesNotContainFiveDistinctCardCategoriesException();
        }

        if (sortedCardCategories.contains(CardCategory.ACE) &&
                sortedCardCategories.contains(CardCategory.TWO) &&
                sortedCardCategories.contains(CardCategory.THREE) &&
                sortedCardCategories.contains(CardCategory.FOUR) &&
                sortedCardCategories.contains(CardCategory.FIVE)
        ) {
            return new StraightKickers(CardCategory.FIVE);
        }

        return new StraightKickers(sortedCardCategories.last());
    }
}
