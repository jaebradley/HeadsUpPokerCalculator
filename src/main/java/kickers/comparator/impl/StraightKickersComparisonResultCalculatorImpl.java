package main.java.kickers.comparator.impl;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.StraightKickers;
import main.java.kickers.comparator.interfaces.StraightKickersComparisonResultCalculator;

public class StraightKickersComparisonResultCalculatorImpl implements StraightKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(final StraightKickers straightKickers1, final StraightKickers straightKickers2) {
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
