package main.java.handCategoryIdentifier.models;

import main.java.handCategoryIdentifier.interfaces.*;

public class HandCategoryExistenceValidators {
    private final StraightExistenceValidator straightExistenceValidator;
    private final FlushExistenceValidator flushExistenceValidator;
    private final FourOfAKindExistenceValidator fourOfAKindExistenceValidator;
    private final ThreeOfAKindExistenceValidator threeOfAKindExistenceValidator;
    private final TwoPairExistenceValidator twoPairExistenceValidator;
    private final OnePairExistenceValidator onePairExistenceValidator;

    public HandCategoryExistenceValidators(
            final StraightExistenceValidator straightExistenceValidator,
            final FlushExistenceValidator flushExistenceValidator,
            final FourOfAKindExistenceValidator fourOfAKindExistenceValidator,
            final ThreeOfAKindExistenceValidator threeOfAKindExistenceValidator,
            final TwoPairExistenceValidator twoPairExistenceValidator,
            final OnePairExistenceValidator onePairExistenceValidator
    ) {
        this.straightExistenceValidator = straightExistenceValidator;
        this.flushExistenceValidator = flushExistenceValidator;
        this.fourOfAKindExistenceValidator = fourOfAKindExistenceValidator;
        this.threeOfAKindExistenceValidator = threeOfAKindExistenceValidator;
        this.twoPairExistenceValidator = twoPairExistenceValidator;
        this.onePairExistenceValidator = onePairExistenceValidator;
    }

    public StraightExistenceValidator getStraightExistenceValidator() {
        return straightExistenceValidator;
    }

    public FlushExistenceValidator getFlushExistenceValidator() {
        return flushExistenceValidator;
    }

    public FourOfAKindExistenceValidator getFourOfAKindExistenceValidator() {
        return fourOfAKindExistenceValidator;
    }

    public ThreeOfAKindExistenceValidator getThreeOfAKindExistenceValidator() {
        return threeOfAKindExistenceValidator;
    }

    public TwoPairExistenceValidator getTwoPairExistenceValidator() {
        return twoPairExistenceValidator;
    }

    public OnePairExistenceValidator getOnePairExistenceValidator() {
        return onePairExistenceValidator;
    }
}
