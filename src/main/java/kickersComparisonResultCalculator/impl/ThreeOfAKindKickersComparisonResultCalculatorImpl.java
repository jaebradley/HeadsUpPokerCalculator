package main.java.kickersComparisonResultCalculator.impl;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.ThreeOfAKindKickers;
import main.java.kickersCalculator.interfaces.ThreeOfAKindKickersCalculator;
import main.java.kickersComparisonResultCalculator.interfaces.ThreeOfAKindKickersComparisonResultCalculator;

public class ThreeOfAKindKickersComparisonResultCalculatorImpl implements ThreeOfAKindKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(
            final ThreeOfAKindKickers threeOfAKindKickers1,
            final ThreeOfAKindKickers threeOfAKindKickers2
    ) {
        assert null != threeOfAKindKickers1;
        assert null != threeOfAKindKickers2;

        if (threeOfAKindKickers1.getThreeOfAKindCardCategory().getValue() > threeOfAKindKickers2.getThreeOfAKindCardCategory().getValue()) {
            return KickersComparisonResult.FIRST;
        }

        if (threeOfAKindKickers2.getThreeOfAKindCardCategory().getValue() > threeOfAKindKickers1.getThreeOfAKindCardCategory().getValue()) {
            return KickersComparisonResult.SECOND;
        }

        if (threeOfAKindKickers1.getThreeOfAKindCardCategory().getValue() == threeOfAKindKickers2.getThreeOfAKindCardCategory().getValue()) {
            if (threeOfAKindKickers1.getHighestRemainingCardCategory().getValue() > threeOfAKindKickers2.getHighestRemainingCardCategory().getValue()) {
                return KickersComparisonResult.FIRST;
            }

            if (threeOfAKindKickers2.getHighestRemainingCardCategory().getValue() > threeOfAKindKickers1.getHighestRemainingCardCategory().getValue()) {
                return KickersComparisonResult.SECOND;
            }

            if (threeOfAKindKickers1.getHighestRemainingCardCategory().getValue() == threeOfAKindKickers2.getHighestRemainingCardCategory().getValue()) {
                if (threeOfAKindKickers1.getLowestRemainingCardCategory().getValue() > threeOfAKindKickers2.getLowestRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.FIRST;
                }

                if (threeOfAKindKickers2.getLowestRemainingCardCategory().getValue() > threeOfAKindKickers1.getLowestRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.SECOND;
                }

                if (threeOfAKindKickers1.getLowestRemainingCardCategory().getValue() == threeOfAKindKickers2.getLowestRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.TIE;
                }
            }
        }

        throw new RuntimeException("unexpected");
    }
}
