package main.java.hand.category.identifier.impl;

import main.java.common.model.Hand;
import main.java.common.model.HandCategory;
import main.java.hand.category.identifier.interfaces.*;

public class HandCategoryIdentifierImpl implements HandCategoryIdentifier {

    private final FlushExistenceValidator flushExistenceValidator;
    private final StraightExistenceValidator straightExistenceValidator;
    private final FourOfAKindExistenceValidator fourOfAKindExistenceValidator;
    private final ThreeOfAKindExistenceValidator threeOfAKindExistenceValidator;
    private final TwoPairExistenceValidator twoPairExistenceValidator;
    private final OnePairExistenceValidator onePairExistenceValidator;

    public HandCategoryIdentifierImpl(
            final FlushExistenceValidator flushExistenceValidator,
            final StraightExistenceValidator straightExistenceValidator,
            final FourOfAKindExistenceValidator fourOfAKindExistenceValidator,
            final ThreeOfAKindExistenceValidator threeOfAKindExistenceValidator,
            final TwoPairExistenceValidator twoPairExistenceValidator,
            final OnePairExistenceValidator onePairExistenceValidator
    ) {
        this.flushExistenceValidator = flushExistenceValidator;
        this.straightExistenceValidator = straightExistenceValidator;
        this.fourOfAKindExistenceValidator = fourOfAKindExistenceValidator;
        this.threeOfAKindExistenceValidator = threeOfAKindExistenceValidator;
        this.twoPairExistenceValidator = twoPairExistenceValidator;
        this.onePairExistenceValidator = onePairExistenceValidator;
    }

    @Override
    public HandCategory identifyHandCategory(
            final Hand hand
    ) {
        assert null != hand;

        if (flushExistenceValidator.flushExists(hand) && straightExistenceValidator.straightExists(hand)) {
            return HandCategory.StraightFlush;
        }

        if (fourOfAKindExistenceValidator.fourOfAKindExists(hand)) {
            return HandCategory.FourOfAKind;
        }

        if (threeOfAKindExistenceValidator.threeOfAKindExists(hand) && onePairExistenceValidator.onePairExists(hand)) {
            return HandCategory.FullHouse;
        }

        if (flushExistenceValidator.flushExists(hand)) {
            return HandCategory.Flush;
        }

        if (straightExistenceValidator.straightExists(hand)) {
            return HandCategory.Straight;
        }

        if (threeOfAKindExistenceValidator.threeOfAKindExists(hand)) {
            return HandCategory.ThreeOfAKind;
        }

        if (twoPairExistenceValidator.twoPairExists(hand)) {
            return HandCategory.TwoPair;
        }

        if (onePairExistenceValidator.onePairExists(hand)) {
            return HandCategory.OnePair;
        }

        return HandCategory.HighCard;
    }
}
