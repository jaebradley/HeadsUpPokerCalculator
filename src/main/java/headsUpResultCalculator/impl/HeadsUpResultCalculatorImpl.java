package main.java.headsUpResultCalculator.impl;

import main.java.common.model.Hand;
import main.java.common.model.HandCategory;
import main.java.common.model.HeadsUpResult;
import main.java.handCategoryIdentifier.interfaces.HandCategoryIdentifier;
import main.java.handCategoryIdentifier.models.HandCategoryExistenceValidators;
import main.java.headsUpResultCalculator.interfaces.HeadsUpResultCalculator;
import main.java.kickersCalculator.models.KickerCalculators;

public class HeadsUpResultCalculatorImpl implements HeadsUpResultCalculator{

    @Override
    public HeadsUpResult calculateHeadsUpResult(
            final Hand dealerHand,
            final Hand bigBlindHand,
            final KickerCalculators kickerCalculators,
            final HandCategoryExistenceValidators handCategoryExistenceValidators,
            final HandCategoryIdentifier handCategoryIdentifier
    ) {
        final HandCategory dealerHandCategory = handCategoryIdentifier.identifyHandCategory(dealerHand);
    }
}