package main.java.kickersCalculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.StraightKickers;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import main.java.kickersCalculator.exception.IncorrectNumberOfCardCategoriesException;
import main.java.kickersCalculator.interfaces.StraightKickersCalculator;

import java.util.TreeSet;

public class StraightKickersCalculatorImpl implements StraightKickersCalculator {
    @Override
    public StraightKickers calculateKickers(final Hand hand, final SortedCardCategoryReturner sortedCardCategoryReturner) throws IncorrectNumberOfCardCategoriesException {
        final TreeSet<CardCategory> sortedCardCategories = sortedCardCategoryReturner.returnCardCategoriesInAscendingOrder(hand);
        if (5 != sortedCardCategories.size()) {
            throw new IncorrectNumberOfCardCategoriesException();
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
