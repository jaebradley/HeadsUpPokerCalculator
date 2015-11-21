package main.java.kickersCalculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.FlushKickers;
import main.java.common.model.Hand;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import main.java.kickersCalculator.exceptions.HandDoesNotContainFiveDistinctCardCategoriesException;
import main.java.kickersCalculator.interfaces.FlushKickersCalculator;

import java.util.TreeSet;

public class FlushKickersCalculatorImpl implements FlushKickersCalculator {
    @Override
    public FlushKickers calculateKickers(
            final Hand hand,
            final SortedCardCategoryReturner sortedCardCategoryReturner
    ) throws HandDoesNotContainFiveDistinctCardCategoriesException {
        final TreeSet<CardCategory> cardCategoriesSet = sortedCardCategoryReturner.returnCardCategoriesInAscendingOrder(hand);

        if (5 != cardCategoriesSet.size()) {
            throw new HandDoesNotContainFiveDistinctCardCategoriesException();
        }

        final CardCategory[] cardCategories = cardCategoriesSet.toArray(new CardCategory[cardCategoriesSet.size()]);
        return new FlushKickers(
                cardCategories[cardCategories.length - 1],
                cardCategories[cardCategories.length - 2],
                cardCategories[cardCategories.length - 3],
                cardCategories[cardCategories.length - 4],
                cardCategories[cardCategories.length - 5]
        );
    }
}
