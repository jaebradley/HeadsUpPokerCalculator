package main.java.kickers.comparator.impl;

import main.java.common.model.kickers.FourOfAKindKickers;
import main.java.common.model.KickersComparisonResult;
import main.java.kickers.comparator.interfaces.FourOfAKindKickersComparisonResultCalculator;

public class FourOfAKindKickersComparisonResultCalculatorImpl implements FourOfAKindKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(
            final FourOfAKindKickers fourOfAKindKickers1,
            final FourOfAKindKickers fourOfAKindKickers2
    ) {
        assert null != fourOfAKindKickers1;
        assert null != fourOfAKindKickers2;

        if (fourOfAKindKickers1.getFourOfAKindCardCategory().getValue() > fourOfAKindKickers2.getFourOfAKindCardCategory().getValue()) {
            return KickersComparisonResult.FIRST;
        }

        if (fourOfAKindKickers2.getFourOfAKindCardCategory().getValue() > fourOfAKindKickers1.getFourOfAKindCardCategory().getValue()) {
            return KickersComparisonResult.SECOND;
        }

        if (fourOfAKindKickers1.getFourOfAKindCardCategory().getValue() == fourOfAKindKickers2.getFourOfAKindCardCategory().getValue()) {
            if (fourOfAKindKickers1.getRemainingCardCategory().getValue() > fourOfAKindKickers2.getRemainingCardCategory().getValue()) {
                return KickersComparisonResult.FIRST;
            }

            if (fourOfAKindKickers2.getRemainingCardCategory().getValue() > fourOfAKindKickers1.getRemainingCardCategory().getValue()) {
                return KickersComparisonResult.SECOND;
            }

            if (fourOfAKindKickers1.getRemainingCardCategory().getValue() == fourOfAKindKickers2.getRemainingCardCategory().getValue()) {
                return KickersComparisonResult.TIE;
            }
        }

        throw new RuntimeException("unexpected");
    }
}
