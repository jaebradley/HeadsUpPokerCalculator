package main.java.handCategoryCalculator.impl;

import main.java.common.model.Hand;
import main.java.common.model.HandCategory;

public class HandCategoryIdentifier implements main.java.handCategoryCalculator.interfaces.HandCategoryIdentifier {
    private final FlushExistenceValidator flushExistenceValidator = new FlushExistenceValidator();
    private final StraightExistenceValidator straightExistenceValidator = new StraightExistenceValidator();
    private final FourOfAKindExistenceValidator fourOfAKindExistenceValidator = new FourOfAKindExistenceValidator();
    private final ThreeOfAKindExistenceValidator threeOfAKindExistenceValidator = new ThreeOfAKindExistenceValidator();
    private final TwoPairExistenceValidator twoPairExistenceValidator = new TwoPairExistenceValidator();
    private final OnePairExistenceValidator onePairExistenceValidator = new OnePairExistenceValidator();

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
