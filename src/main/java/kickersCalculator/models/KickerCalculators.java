package main.java.kickersCalculator.models;

import main.java.common.model.HighCardKickers;
import main.java.kickersCalculator.interfaces.*;

public class KickerCalculators {
    private final StraightKickersCalculator straightKickersCalculator;
    private final HighCardKickersCalculator highCardKickersCalculator;
    private final FourOfAKindKickersCalculator fourOfAKindKickersCalculator;
    private final FullHouseKickersCalculator fullHouseKickersCalculator;
    private final ThreeOfAKindKickersCalculator threeOfAKindKickersCalculator;
    private final TwoPairKickersCalculator twoPairKickersCalculator;
    private final OnePairKickersCalculator onePairKickersCalculator;

    public KickerCalculators(
            final StraightKickersCalculator straightKickersCalculator,
            final HighCardKickersCalculator highCardKickersCalculator,
            final FourOfAKindKickersCalculator fourOfAKindKickersCalculator,
            final FullHouseKickersCalculator fullHouseKickersCalculator,
            final ThreeOfAKindKickersCalculator threeOfAKindKickersCalculator,
            final TwoPairKickersCalculator twoPairKickersCalculator,
            final OnePairKickersCalculator onePairKickersCalculator
    ) {
        this.straightKickersCalculator = straightKickersCalculator;
        this.highCardKickersCalculator = highCardKickersCalculator;
        this.fourOfAKindKickersCalculator = fourOfAKindKickersCalculator;
        this.fullHouseKickersCalculator = fullHouseKickersCalculator;
        this.threeOfAKindKickersCalculator = threeOfAKindKickersCalculator;
        this.twoPairKickersCalculator = twoPairKickersCalculator;
        this.onePairKickersCalculator = onePairKickersCalculator;
    }

    public StraightKickersCalculator getStraightKickersCalculator() {
        return straightKickersCalculator;
    }

    public HighCardKickersCalculator getHighCardKickersCalculator() {
        return highCardKickersCalculator;
    }

    public FourOfAKindKickersCalculator getFourOfAKindKickersCalculator() {
        return fourOfAKindKickersCalculator;
    }

    public FullHouseKickersCalculator getFullHouseKickersCalculator() {
        return fullHouseKickersCalculator;
    }

    public ThreeOfAKindKickersCalculator getThreeOfAKindKickersCalculator() {
        return threeOfAKindKickersCalculator;
    }

    public TwoPairKickersCalculator getTwoPairKickersCalculator() {
        return twoPairKickersCalculator;
    }

    public OnePairKickersCalculator getOnePairKickersCalculator() {
        return onePairKickersCalculator;
    }
}
