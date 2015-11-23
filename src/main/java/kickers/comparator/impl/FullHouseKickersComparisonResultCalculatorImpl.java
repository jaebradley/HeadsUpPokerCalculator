package main.java.kickers.comparator.impl;

import main.java.common.model.FullHouseKickers;
import main.java.common.model.KickersComparisonResult;
import main.java.kickers.comparator.interfaces.FullHouseKickersComparisonResultCalculator;

public class FullHouseKickersComparisonResultCalculatorImpl implements FullHouseKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(
            final FullHouseKickers fullHouseKickers1,
            final FullHouseKickers fullHouseKickers2
    ) {
        assert null != fullHouseKickers1;
        assert null != fullHouseKickers2;

        if (fullHouseKickers1.getThreeOfAKindCardCategory().getValue() > fullHouseKickers2.getThreeOfAKindCardCategory().getValue()) {
            return KickersComparisonResult.FIRST;
        }

        if (fullHouseKickers2.getThreeOfAKindCardCategory().getValue() > fullHouseKickers1.getThreeOfAKindCardCategory().getValue()) {
            return KickersComparisonResult.SECOND;
        }

        if (fullHouseKickers1.getThreeOfAKindCardCategory().getValue() == fullHouseKickers1.getThreeOfAKindCardCategory().getValue()) {
            if (fullHouseKickers1.getTwoOfAKindCardCategory().getValue() > fullHouseKickers2.getTwoOfAKindCardCategory().getValue()) {
                return KickersComparisonResult.FIRST;
            }

            if (fullHouseKickers2.getTwoOfAKindCardCategory().getValue() > fullHouseKickers1.getTwoOfAKindCardCategory().getValue()) {
                return KickersComparisonResult.SECOND;
            }

            if (fullHouseKickers1.getTwoOfAKindCardCategory().getValue() == fullHouseKickers2.getTwoOfAKindCardCategory().getValue()) {
                return KickersComparisonResult.TIE;
            }
        }

        throw new RuntimeException("unexpected");
    }
}
