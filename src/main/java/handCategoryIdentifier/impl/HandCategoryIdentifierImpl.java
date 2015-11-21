package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Hand;
import main.java.common.model.HandCategory;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import main.java.common.utils.interfaces.CardCategoryPairCounter;
import main.java.common.utils.interfaces.DistinctSuitsReturner;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import main.java.handCategoryIdentifier.interfaces.*;

public class HandCategoryIdentifierImpl implements HandCategoryIdentifier {

    @Override
    public HandCategory identifyHandCategory(
            final Hand hand,
            final FlushExistenceValidator flushExistenceValidator,
            final StraightExistenceValidator straightExistenceValidator,
            final FourOfAKindExistenceValidator fourOfAKindExistenceValidator,
            final ThreeOfAKindExistenceValidator threeOfAKindExistenceValidator,
            final TwoPairExistenceValidator twoPairExistenceValidator,
            final OnePairExistenceValidator onePairExistenceValidator,
            final SortedCardCategoryReturner sortedCardCategoryReturner,
            final DistinctSuitsReturner distinctSuitsReturner,
            final CardCategoryCountMapper cardCategoryCountMapper,
            final CardCategoryPairCounter cardCategoryPairCounter
    ) {
        if (flushExistenceValidator.validateExistence(hand, distinctSuitsReturner) && straightExistenceValidator.validateExistence(hand, sortedCardCategoryReturner)) {
            return HandCategory.StraightFlush;
        }

        if (fourOfAKindExistenceValidator.validateExistence(hand, cardCategoryCountMapper)) {
            return HandCategory.FourOfAKind;
        }

        if (threeOfAKindExistenceValidator.validateExistence(hand, cardCategoryCountMapper) && onePairExistenceValidator.validateExistence(hand, cardCategoryPairCounter, cardCategoryCountMapper)) {
            return HandCategory.FullHouse;
        }

        if (flushExistenceValidator.validateExistence(hand, distinctSuitsReturner)) {
            return HandCategory.Flush;
        }

        if (straightExistenceValidator.validateExistence(hand, sortedCardCategoryReturner)) {
            return HandCategory.Straight;
        }

        if (threeOfAKindExistenceValidator.validateExistence(hand, cardCategoryCountMapper)) {
            return HandCategory.ThreeOfAKind;
        }

        if (twoPairExistenceValidator.validateExistence(hand, cardCategoryPairCounter, cardCategoryCountMapper)) {
            return HandCategory.TwoPair;
        }

        if (onePairExistenceValidator.validateExistence(hand, cardCategoryPairCounter, cardCategoryCountMapper)) {
            return HandCategory.OnePair;
        }

        return HandCategory.HighCard;
    }
}
