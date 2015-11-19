package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Hand;
import main.java.common.model.HandCategory;
import main.java.handCategoryIdentifier.interfaces.FlushExistenceValidator;
import main.java.handCategoryIdentifier.interfaces.HandCategoryIdentifier;

public class HandCategoryIdentifierImpl implements HandCategoryIdentifier {
    private final FlushExistenceValidator flushExistenceValidator;
    private final StraightExistenceValidatorImpl straightExistenceValidator;
    private final FourOfAKindExistenceValidatorImpl fourOfAKindExistenceValidator;
    private final ThreeOfAKindExistenceValidatorImpl threeOfAKindExistenceValidator;
    private final TwoPairExistenceValidatorImpl twoPairExistenceValidator;
    private final OnePairExistenceValidatorImpl onePairExistenceValidator;

    public HandCategoryIdentifierImpl(
            final FlushExistenceValidator flushExistenceValidator,
            final StraightExistenceValidatorImpl straightExistenceValidator,
            final FourOfAKindExistenceValidatorImpl fourOfAKindExistenceValidator,
            final ThreeOfAKindExistenceValidatorImpl threeOfAKindExistenceValidator,
            final TwoPairExistenceValidatorImpl twoPairExistenceValidator,
            final OnePairExistenceValidatorImpl onePairExistenceValidator
    ) {
        this.flushExistenceValidator = flushExistenceValidator;
        this.straightExistenceValidator = straightExistenceValidator;
        this.fourOfAKindExistenceValidator = fourOfAKindExistenceValidator;
        this.threeOfAKindExistenceValidator = threeOfAKindExistenceValidator;
        this.twoPairExistenceValidator = twoPairExistenceValidator;
        this.onePairExistenceValidator = onePairExistenceValidator;
    }

    @Override
    public HandCategory identifyHandCategory(final Hand hand) {
        if (flushExistenceValidator.validateExistence(hand) && straightExistenceValidator.validateExistence(hand)) {
            return HandCategory.StraightFlush;
        }

        if (fourOfAKindExistenceValidator.validateExistence(hand)) {
            return HandCategory.FourOfAKind;
        }

        if (threeOfAKindExistenceValidator.validateExistence(hand) && onePairExistenceValidator.validateExistence(hand)) {
            return HandCategory.FullHouse;
        }

        if (flushExistenceValidator.validateExistence(hand)) {
            return HandCategory.Flush;
        }

        if (straightExistenceValidator.validateExistence(hand)) {
            return HandCategory.Straight;
        }

        if (threeOfAKindExistenceValidator.validateExistence(hand)) {
            return HandCategory.ThreeOfAKind;
        }

        if (twoPairExistenceValidator.validateExistence(hand)) {
            return HandCategory.TwoPair;
        }

        if (onePairExistenceValidator.validateExistence(hand)) {
            return HandCategory.OnePair;
        }

        return HandCategory.HighCard;
    }
}
