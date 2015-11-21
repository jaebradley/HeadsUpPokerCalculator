package main.java.handCategoryIdentifier.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.HandCategory;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import main.java.common.utils.interfaces.CardCategoryPairCounter;
import main.java.common.utils.interfaces.DistinctSuitsReturner;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;

public interface HandCategoryIdentifier {
    HandCategory identifyHandCategory(
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
    );
}
