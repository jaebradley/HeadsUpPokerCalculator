package main.java.headsUpResultCalculator.impl;

import main.java.common.model.Hand;
import main.java.common.model.HeadsUpResult;
import main.java.handCategoryIdentifier.interfaces.HandCategoryIdentifier;
import main.java.handCategoryIdentifier.models.HandCategoryExistenceValidators;
import main.java.headsUpResultCalculator.interfaces.HeadsUpResultCalculator;
import main.java.kickersCalculator.interfaces.*;
import main.java.kickersCalculator.models.KickerCalculators;
import main.java.kickersComparisonResultCalculator.interfaces.*;

public class HeadsUpResultCalculatorImpl implements HeadsUpResultCalculator{
    private final HandCategoryIdentifier handCategoryIdentifier;
    private final FlushKickersCalculator flushKickersCalculator;
    private final StraightKickersCalculator straightKickersCalculator;
    private final HighCardKickersCalculator highCardKickersCalculator;
    private final FourOfAKindKickersCalculator fourOfAKindKickersCalculator;
    private final FullHouseKickersCalculator fullHouseKickersCalculator;
    private final ThreeOfAKindKickersCalculator threeOfAKindKickersCalculator;
    private final TwoPairKickersCalculator twoPairKickersCalculator;
    private final OnePairKickersCalculator onePairKickersCalculator;
    private final FourOfAKindKickersComparisonResultCalculator fourOfAKindKickersComparisonResultCalculator;
    private final FullHouseKickersComparisonResultCalculator fullHouseKickersComparisonResultCalculator;
    private final ThreeOfAKindKickersComparisonResultCalculator threeOfAKindKickersComparisonResultCalculator;
    private final TwoPairKickersComparisonResultCalculator twoPairKickersComparisonResultCalculator;
    private final OnePairKickersComparisonResultCalculator onePairKickersComparisonResultCalculator;
    private final HighCardKickersComparisonResultCalculator highCardKickersComparisonResultCalculator;


    public HeadsUpResultCalculatorImpl(
            final HandCategoryIdentifier handCategoryIdentifier,
            final FlushKickersCalculator flushKickersCalculator,
            final StraightKickersCalculator straightKickersCalculator,
            final HighCardKickersCalculator highCardKickersCalculator,
            final FourOfAKindKickersCalculator fourOfAKindKickersCalculator,
            final FullHouseKickersCalculator fullHouseKickersCalculator,
            final ThreeOfAKindKickersCalculator threeOfAKindKickersCalculator,
            final TwoPairKickersCalculator twoPairKickersCalculator,
            final OnePairKickersCalculator onePairKickersCalculator,
            final FourOfAKindKickersComparisonResultCalculator fourOfAKindKickersComparisonResultCalculator,
            final FullHouseKickersComparisonResultCalculator fullHouseKickersComparisonResultCalculator,
            final ThreeOfAKindKickersComparisonResultCalculator threeOfAKindKickersComparisonResultCalculator,
            final TwoPairKickersComparisonResultCalculator twoPairKickersComparisonResultCalculator,
            final OnePairKickersComparisonResultCalculator onePairKickersComparisonResultCalculator,
            final HighCardKickersComparisonResultCalculator highCardKickersComparisonResultCalculator) {
        this.handCategoryIdentifier = handCategoryIdentifier;
        this.flushKickersCalculator = flushKickersCalculator;
        this.straightKickersCalculator = straightKickersCalculator;
        this.highCardKickersCalculator = highCardKickersCalculator;
        this.fourOfAKindKickersCalculator = fourOfAKindKickersCalculator;
        this.fullHouseKickersCalculator = fullHouseKickersCalculator;
        this.threeOfAKindKickersCalculator = threeOfAKindKickersCalculator;
        this.twoPairKickersCalculator = twoPairKickersCalculator;
        this.onePairKickersCalculator = onePairKickersCalculator;
        this.fourOfAKindKickersComparisonResultCalculator = fourOfAKindKickersComparisonResultCalculator;
        this.fullHouseKickersComparisonResultCalculator = fullHouseKickersComparisonResultCalculator;
        this.threeOfAKindKickersComparisonResultCalculator = threeOfAKindKickersComparisonResultCalculator;
        this.twoPairKickersComparisonResultCalculator = twoPairKickersComparisonResultCalculator;
        this.onePairKickersComparisonResultCalculator = onePairKickersComparisonResultCalculator;
        this.highCardKickersComparisonResultCalculator = highCardKickersComparisonResultCalculator;
    }

    @Override
    public HeadsUpResult calculateHeadsUpResult(
            final Hand dealerHand,
            final Hand bigBlindHand,
            final KickerCalculators kickerCalculators,
            final HandCategoryExistenceValidators handCategoryExistenceValidators,
            final HandCategoryIdentifier handCategoryIdentifier
    ) {
        return null;
    }
}
