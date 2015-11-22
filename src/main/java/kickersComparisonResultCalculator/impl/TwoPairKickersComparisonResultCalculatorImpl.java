package main.java.kickersComparisonResultCalculator.impl;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.TwoPairKickers;
import main.java.kickersComparisonResultCalculator.interfaces.TwoPairKickersComparisonResultCalculator;

public class TwoPairKickersComparisonResultCalculatorImpl implements TwoPairKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(
            final TwoPairKickers twoPairKickers1,
            final TwoPairKickers twoPairKickers2
    ) {
        if (twoPairKickers1.getHighestPairCardCategory().getValue() > twoPairKickers2.getHighestPairCardCategory().getValue()) {
            return KickersComparisonResult.FIRST;
        }

        if (twoPairKickers2.getHighestPairCardCategory().getValue() > twoPairKickers1.getHighestPairCardCategory().getValue()) {
            return KickersComparisonResult.SECOND;
        }

        if (twoPairKickers1.getHighestPairCardCategory().getValue() == twoPairKickers1.getHighestPairCardCategory().getValue()) {
            if (twoPairKickers1.getLowestPairCardCategory().getValue() > twoPairKickers2.getLowestPairCardCategory().getValue()) {
                return KickersComparisonResult.FIRST;
            }

            if (twoPairKickers2.getLowestPairCardCategory().getValue() > twoPairKickers1.getLowestPairCardCategory().getValue()) {
                return KickersComparisonResult.SECOND;
            }

            if (twoPairKickers1.getLowestPairCardCategory().getValue() == twoPairKickers2.getLowestPairCardCategory().getValue()) {
                if (twoPairKickers1.getRemainingCardCategory().getValue() > twoPairKickers2.getRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.FIRST;
                }

                if (twoPairKickers2.getRemainingCardCategory().getValue() > twoPairKickers1.getRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.SECOND;
                }

                if (twoPairKickers1.getRemainingCardCategory().getValue() == twoPairKickers2.getRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.TIE;
                }
            }
        }

        throw new RuntimeException("unexpected");
    }
}
