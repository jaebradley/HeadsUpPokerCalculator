package main.java.headsUp.calculator.impl;

import main.java.common.model.Hand;
import main.java.common.model.HandCategory;
import main.java.common.model.HeadsUpResult;
import main.java.common.model.KickersComparisonResult;
import main.java.hand.category.identifier.interfaces.HandCategoryIdentifier;
import main.java.headsUp.calculator.exceptions.UnableToCalculateHeadsUpResultException;
import main.java.headsUp.calculator.exceptions.UnableToCompareKickersException;
import main.java.headsUp.calculator.interfaces.DifferentHandCategoriesHeadsUpResultCalculator;
import main.java.headsUp.calculator.interfaces.HeadsUpResultCalculator;
import main.java.headsUp.calculator.interfaces.IdenticalHandCategoriesHeadsUpResultCalculator;
import main.java.kickers.calculator.exceptions.*;
import main.java.kickers.calculator.interfaces.*;
import main.java.kickers.comparator.interfaces.*;

public class HeadsUpResultCalculatorImpl implements HeadsUpResultCalculator{
    private final HandCategoryIdentifier handCategoryIdentifier;
    private final DifferentHandCategoriesHeadsUpResultCalculator differentHandCategoriesHeadsUpResultCalculator;
    private final IdenticalHandCategoriesHeadsUpResultCalculator identicalHandCategoriesHeadsUpResultCalculator;


    public HeadsUpResultCalculatorImpl(
            final HandCategoryIdentifier handCategoryIdentifier,
            final DifferentHandCategoriesHeadsUpResultCalculator differentHandCategoriesHeadsUpResultCalculator,
            final IdenticalHandCategoriesHeadsUpResultCalculator identicalHandCategoriesHeadsUpResultCalculator
    ) {
        this.handCategoryIdentifier = handCategoryIdentifier;
        this.differentHandCategoriesHeadsUpResultCalculator = differentHandCategoriesHeadsUpResultCalculator;
        this.identicalHandCategoriesHeadsUpResultCalculator = identicalHandCategoriesHeadsUpResultCalculator;
    }

    @Override
    public HeadsUpResult calculateHeadsUpResult(
            final Hand dealerHand,
            final Hand bigBlindHand
    ) throws UnableToCalculateHeadsUpResultException {
        assert null != dealerHand;
        assert null != bigBlindHand;

        final HandCategory dealerHandCategory = handCategoryIdentifier.identifyHandCategory(dealerHand);
        final HandCategory bigBlindHandCategory = handCategoryIdentifier.identifyHandCategory(bigBlindHand);

        if (dealerHandCategory.getRankValue() != bigBlindHandCategory.getRankValue()) {
            return differentHandCategoriesHeadsUpResultCalculator.calculateHeadsUpResultForHandsWithDifferentHandCategories(dealerHand, bigBlindHand);
        } else {
            try {
                return identicalHandCategoriesHeadsUpResultCalculator.calculateHeadsUpResultForHandsWithIdenticalCategories(dealerHand, bigBlindHand);
            } catch (UnableToCompareKickersException e) {
                throw new UnableToCalculateHeadsUpResultException(e.getMessage());
            }
        }
    }
}
