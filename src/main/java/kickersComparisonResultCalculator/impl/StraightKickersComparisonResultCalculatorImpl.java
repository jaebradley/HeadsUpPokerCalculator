package main.java.kickersComparisonResultCalculator.impl;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.StraightKickers;
import main.java.kickersComparisonResultCalculator.interfaces.StraightKickersComparisonResultCalculator;

public class StraightKickersComparisonResultCalculatorImpl implements StraightKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersResult(final StraightKickers straightKickers1, final StraightKickers straightKickers2) {
        assert null != straightKickers1;
        assert null != straightKickers2;

        if (straightKickers1.getHighestCardCategory().getValue() > straightKickers2.getHighestCardCategory().getValue()) {
            return KickersComparisonResult.FIRST;
        }

        if (straightKickers2.getHighestCardCategory().getValue() > straightKickers1.getHighestCardCategory().getValue()) {
            return KickersComparisonResult.SECOND;
        }

        if (straightKickers1.getHighestCardCategory().getValue() == straightKickers2.getHighestCardCategory().getValue()) {
            return KickersComparisonResult.TIE;
        }

        throw new RuntimeException("unexpected");
    }
}
