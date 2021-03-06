package main.java.kickers.calculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.kickers.FlushKickers;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import main.java.kickers.calculator.exceptions.HandDoesNotContainFiveDistinctCardCategoriesException;
import main.java.kickers.calculator.interfaces.FlushKickersCalculator;

import java.util.TreeSet;

public class FlushKickersCalculatorImpl implements FlushKickersCalculator {
    private final SortedCardCategoryReturner sortedCardCategoryReturner;

    public FlushKickersCalculatorImpl(final SortedCardCategoryReturner sortedCardCategoryReturner) {
        this.sortedCardCategoryReturner = sortedCardCategoryReturner;
    }

    @Override
    public FlushKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainFiveDistinctCardCategoriesException {
        assert null != hand;

        final TreeSet<CardCategory> cardCategoriesSet = sortedCardCategoryReturner.returnCardCategoriesInAscendingOrder(hand);

        assert null != cardCategoriesSet;

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
