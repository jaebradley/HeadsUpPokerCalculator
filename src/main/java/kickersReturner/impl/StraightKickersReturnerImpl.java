package main.java.kickersReturner.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.StraightKickers;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import main.java.kickersReturner.interfaces.StraightKickersReturner;

import java.util.TreeSet;

public class StraightKickersReturnerImpl implements StraightKickersReturner {
    @Override
    public StraightKickers returnKickers(final Hand hand, final SortedCardCategoryReturner sortedCardCategoryReturner) {
        final TreeSet<CardCategory> sortedCardCategories = sortedCardCategoryReturner.returnCardCategoriesInAscendingOrder(hand);
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
