package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Hand;
import main.java.common.model.HandCategory;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import main.java.handCategoryIdentifier.interfaces.*;

public class HandCategoryIdentifierImpl implements HandCategoryIdentifier {
    private final FlushExistenceValidator flushExistenceValidator;
    private final StraightExistenceValidator straightExistenceValidator;
    private final FourOfAKindExistenceValidator fourOfAKindExistenceValidator;
    private final ThreeOfAKindExistenceValidator threeOfAKindExistenceValidator;
    private final TwoPairExistenceValidator twoPairExistenceValidator;
    private final OnePairExistenceValidator onePairExistenceValidator;
    private final SortedCardCategoryReturner sortedCardCategoryReturner;

    public HandCategoryIdentifierImpl(
            final FlushExistenceValidator flushExistenceValidator,
            final StraightExistenceValidator straightExistenceValidator,
            final FourOfAKindExistenceValidator fourOfAKindExistenceValidator,
            final ThreeOfAKindExistenceValidator threeOfAKindExistenceValidator,
            final TwoPairExistenceValidator twoPairExistenceValidator,
            final OnePairExistenceValidator onePairExistenceValidator,
            final SortedCardCategoryReturner sortedCardCategoryReturner) {
        this.flushExistenceValidator = flushExistenceValidator;
        this.straightExistenceValidator = straightExistenceValidator;
        this.fourOfAKindExistenceValidator = fourOfAKindExistenceValidator;
        this.threeOfAKindExistenceValidator = threeOfAKindExistenceValidator;
        this.twoPairExistenceValidator = twoPairExistenceValidator;
        this.onePairExistenceValidator = onePairExistenceValidator;
        this.sortedCardCategoryReturner = sortedCardCategoryReturner;
    }

    @Override
    public HandCategory identifyHandCategory(final Hand hand) {
        if (flushExistenceValidator.validateExistence(hand) && straightExistenceValidator.validateExistence(hand, sortedCardCategoryReturner)) {
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

        if (straightExistenceValidator.validateExistence(hand, sortedCardCategoryReturner)) {
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
