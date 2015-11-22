package main.java.kickersComparisonResultCalculator.impl;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.OnePairKickers;
import main.java.kickersComparisonResultCalculator.interfaces.OnePairKickersComparisonResultCalculator;

import javax.management.RuntimeErrorException;
import javax.rmi.CORBA.Tie;

public class OnePairKickersComparisonResultCalculatorImpl implements OnePairKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(
            final OnePairKickers onePairKickers1,
            final OnePairKickers onePairKickers2
    ) {
        if (onePairKickers1.getPairCardCategory().getValue() > onePairKickers2.getPairCardCategory().getValue()) {
            return KickersComparisonResult.FIRST;
        }

        if (onePairKickers2.getPairCardCategory().getValue() > onePairKickers1.getPairCardCategory().getValue()) {
            return KickersComparisonResult.SECOND;
        }

        if (onePairKickers1.getPairCardCategory().getValue() == onePairKickers2.getPairCardCategory().getValue()) {
            if (onePairKickers1.getHighestRemainingCardCategory().getValue() > onePairKickers2.getHighestRemainingCardCategory().getValue()) {
                return KickersComparisonResult.FIRST;
            }

            if (onePairKickers2.getHighestRemainingCardCategory().getValue() > onePairKickers1.getHighestRemainingCardCategory().getValue()) {
                return KickersComparisonResult.SECOND;
            }

            if (onePairKickers1.getHighestRemainingCardCategory().getValue() == onePairKickers2.getHighestRemainingCardCategory().getValue()) {
                if (onePairKickers1.getSecondHighestRemainingCardCategory().getValue() > onePairKickers2.getSecondHighestRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.FIRST;
                }

                if (onePairKickers2.getSecondHighestRemainingCardCategory().getValue() > onePairKickers1.getSecondHighestRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.SECOND;
                }

                if (onePairKickers1.getSecondHighestRemainingCardCategory().getValue() == onePairKickers2.getSecondHighestRemainingCardCategory().getValue()) {
                    if (onePairKickers1.getLowestRemainingCardCategory().getValue() > onePairKickers2.getLowestRemainingCardCategory().getValue()) {
                        return KickersComparisonResult.FIRST;
                    }

                    if (onePairKickers2.getLowestRemainingCardCategory().getValue() > onePairKickers1.getLowestRemainingCardCategory().getValue()) {
                        return KickersComparisonResult.SECOND;
                    }

                    if (onePairKickers1.getLowestRemainingCardCategory().getValue() == onePairKickers2.getLowestRemainingCardCategory().getValue()) {
                        return KickersComparisonResult.TIE;
                    }
                }
            }
        }

        throw new RuntimeException("unexpected");
    }
}
