package main.java.kickers.comparator.impl;

import main.java.common.model.HighCardKickers;
import main.java.common.model.KickersComparisonResult;
import main.java.kickers.comparator.interfaces.HighCardKickersComparisonResultCalculator;

public class HighCardKickersComparisonResultCalculatorImpl implements HighCardKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(
            final HighCardKickers highCardKickers1,
            final HighCardKickers highCardKickers2
    ) {
        if (highCardKickers1.getHighestCardCategory().getValue() > highCardKickers2.getHighestCardCategory().getValue()) {
            return KickersComparisonResult.FIRST;
        }

        if (highCardKickers2.getHighestCardCategory().getValue() > highCardKickers1.getHighestCardCategory().getValue()) {
            return KickersComparisonResult.SECOND;
        }

        if (highCardKickers1.getHighestCardCategory().getValue() == highCardKickers2.getHighestCardCategory().getValue()) {
            if (highCardKickers1.getSecondHighestCardCategory().getValue() > highCardKickers2.getSecondHighestCardCategory().getValue()) {
                return KickersComparisonResult.FIRST;
            }

            if (highCardKickers2.getSecondHighestCardCategory().getValue() > highCardKickers1.getSecondHighestCardCategory().getValue()) {
                return KickersComparisonResult.SECOND;
            }

            if (highCardKickers1.getSecondHighestCardCategory().getValue() == highCardKickers2.getSecondHighestCardCategory().getValue()) {
                if (highCardKickers1.getThirdHighestCardCategory().getValue() > highCardKickers2.getThirdHighestCardCategory().getValue()) {
                    return KickersComparisonResult.FIRST;
                }

                if (highCardKickers2.getThirdHighestCardCategory().getValue() > highCardKickers1.getThirdHighestCardCategory().getValue()) {
                    return KickersComparisonResult.SECOND;
                }

                if (highCardKickers1.getThirdHighestCardCategory().getValue() == highCardKickers2.getThirdHighestCardCategory().getValue()) {
                    if (highCardKickers1.getFourthHighestCardCategory().getValue() > highCardKickers2.getFourthHighestCardCategory().getValue()) {
                        return KickersComparisonResult.FIRST;
                    }

                    if (highCardKickers2.getFourthHighestCardCategory().getValue() > highCardKickers1.getFourthHighestCardCategory().getValue()) {
                        return KickersComparisonResult.SECOND;
                    }

                    if (highCardKickers1.getFourthHighestCardCategory().getValue() == highCardKickers2.getFourthHighestCardCategory().getValue()) {
                        if (highCardKickers1.getFifthHighestCardCategory().getValue() > highCardKickers2.getFifthHighestCardCategory().getValue()) {
                            return KickersComparisonResult.FIRST;
                        }

                        if (highCardKickers2.getFifthHighestCardCategory().getValue() > highCardKickers1.getFifthHighestCardCategory().getValue()) {
                            return KickersComparisonResult.SECOND;
                        }

                        if (highCardKickers1.getFifthHighestCardCategory().getValue() == highCardKickers2.getFifthHighestCardCategory().getValue()) {
                            return KickersComparisonResult.TIE;
                        }
                    }
                }
            }
        }

        throw new RuntimeException("unexpected");
    }
}
