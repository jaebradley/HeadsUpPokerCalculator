package main.java.headsUp.calculator.impl;

import main.java.common.model.Hand;
import main.java.common.model.HandCategory;
import main.java.common.model.HeadsUpResult;
import main.java.hand.category.identifier.interfaces.HandCategoryIdentifier;
import main.java.headsUp.calculator.interfaces.DifferentHandCategoriesHeadsUpResultCalculator;

public class DifferentHandCategoriesHeadsUpResultCalculatorImpl implements DifferentHandCategoriesHeadsUpResultCalculator {
    private final HandCategoryIdentifier handCategoryIdentifier;

    public DifferentHandCategoriesHeadsUpResultCalculatorImpl(final HandCategoryIdentifier handCategoryIdentifier) {
        this.handCategoryIdentifier = handCategoryIdentifier;
    }

    @Override
    public HeadsUpResult calculateHeadsUpResultForHandsWithDifferentHandCategories(final Hand dealerHand, final Hand bigBlindHand) {
        assert null != dealerHand;
        assert null != bigBlindHand;

        final HandCategory dealerHandCategory = handCategoryIdentifier.identifyHandCategory(dealerHand);
        final HandCategory bigBlindHandCategory = handCategoryIdentifier.identifyHandCategory(bigBlindHand);

        assert null != dealerHandCategory;
        assert null != bigBlindHandCategory;
        assert dealerHandCategory.getRankValue() != bigBlindHandCategory.getRankValue();

        if (dealerHandCategory.getRankValue() - bigBlindHandCategory.getRankValue() > 0) {
            return HeadsUpResult.DEALER_WINS;
        }

        if (bigBlindHandCategory.getRankValue() - dealerHandCategory.getRankValue() > 0) {
            return HeadsUpResult.BIG_BLIND_WINS;
        }

        throw new RuntimeException("unexpected");

    }
}
