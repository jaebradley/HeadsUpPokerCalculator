package main.java.kickersCalculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.HighCardKickers;
import main.java.common.model.Hand;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import main.java.kickersCalculator.exceptions.HandDoesNotContainFiveDistinctCardCategoriesException;
import main.java.kickersCalculator.interfaces.HighCardKickersCalculator;

import java.util.TreeSet;

public class HighCardKickersCalculatorImpl implements HighCardKickersCalculator {
    @Override
    public HighCardKickers calculateKickers(
            final Hand hand,
            final SortedCardCategoryReturner sortedCardCategoryReturner
    ) throws HandDoesNotContainFiveDistinctCardCategoriesException {
        final TreeSet<CardCategory> cardCategoriesSet = sortedCardCategoryReturner.returnCardCategoriesInAscendingOrder(hand);

        if (5 != cardCategoriesSet.size()) {
            throw new HandDoesNotContainFiveDistinctCardCategoriesException();
        }

        final CardCategory[] cardCategories = cardCategoriesSet.toArray(new CardCategory[cardCategoriesSet.size()]);
        return new HighCardKickers(
                cardCategories[cardCategories.length - 1],
                cardCategories[cardCategories.length - 2],
                cardCategories[cardCategories.length - 3],
                cardCategories[cardCategories.length - 4],
                cardCategories[cardCategories.length - 5]
        );
    }
}
