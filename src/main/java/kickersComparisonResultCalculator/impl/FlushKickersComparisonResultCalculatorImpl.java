package main.java.kickersComparisonResultCalculator.impl;

import main.java.common.model.FlushKickers;
import main.java.common.model.KickersComparisonResult;
import main.java.kickersComparisonResultCalculator.interfaces.FlushKickersComparisonResultCalculator;

public class FlushKickersComparisonResultCalculatorImpl implements FlushKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(final FlushKickers flushKickers1, final FlushKickers flushKickers2) {
        if (flushKickers1.getHighestCardCategory().getValue() > flushKickers2.getHighestCardCategory().getValue()) {
            return KickersComparisonResult.FIRST;
        }

        if (flushKickers2.getHighestCardCategory().getValue() > flushKickers1.getHighestCardCategory().getValue()) {
            return KickersComparisonResult.SECOND;
        }

        if (flushKickers1.getHighestCardCategory().getValue() == flushKickers2.getHighestCardCategory().getValue()) {
            if (flushKickers1.getSecondHighestCardCategory().getValue() > flushKickers2.getSecondHighestCardCategory().getValue()) {
                return KickersComparisonResult.FIRST;
            }

            if (flushKickers2.getSecondHighestCardCategory().getValue() > flushKickers1.getSecondHighestCardCategory().getValue()) {
                return KickersComparisonResult.SECOND;
            }

            if (flushKickers1.getSecondHighestCardCategory().getValue() == flushKickers2.getSecondHighestCardCategory().getValue()) {
                if (flushKickers1.getThirdHighestCardCategory().getValue() > flushKickers2.getThirdHighestCardCategory().getValue()) {
                    return KickersComparisonResult.FIRST;
                }

                if (flushKickers2.getThirdHighestCardCategory().getValue() > flushKickers1.getThirdHighestCardCategory().getValue()) {
                    return KickersComparisonResult.SECOND;
                }

                if (flushKickers1.getThirdHighestCardCategory().getValue() == flushKickers2.getThirdHighestCardCategory().getValue()) {
                    if (flushKickers1.getFourthHighestCardCategory().getValue() > flushKickers2.getFourthHighestCardCategory().getValue()) {
                        return KickersComparisonResult.FIRST;
                    }

                    if (flushKickers2.getFourthHighestCardCategory().getValue() > flushKickers1.getFourthHighestCardCategory().getValue()) {
                        return KickersComparisonResult.SECOND;
                    }

                    if (flushKickers1.getFourthHighestCardCategory().getValue() == flushKickers2.getFourthHighestCardCategory().getValue()) {
                        if (flushKickers1.getFifthHighestCardCategory().getValue() > flushKickers2.getFifthHighestCardCategory().getValue()) {
                            return KickersComparisonResult.FIRST;
                        }

                        if (flushKickers2.getFifthHighestCardCategory().getValue() > flushKickers1.getFifthHighestCardCategory().getValue()) {
                            return KickersComparisonResult.SECOND;
                        }

                        if (flushKickers1.getFifthHighestCardCategory().getValue() == flushKickers2.getFifthHighestCardCategory().getValue()) {
                            return KickersComparisonResult.TIE;
                        }
                    }
                }
            }
        }

        throw new RuntimeException("unexpected");
    }
}
