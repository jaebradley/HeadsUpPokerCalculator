package main.java.kickers.comparator.impl;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.StraightKickers;
import main.java.kickers.comparator.interfaces.StraightKickersComparisonResultCalculator;

public class StraightKickersComparisonResultCalculatorImpl implements StraightKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(final StraightKickers dealerStraightKickers, final StraightKickers bigBlindStraightKickers) {
        assert null != dealerStraightKickers;
        assert null != bigBlindStraightKickers;

        if (dealerStraightKickers.getHighestCardCategory().getValue() > bigBlindStraightKickers.getHighestCardCategory().getValue()) {
            return KickersComparisonResult.DEALER_WINS;
        }

        if (bigBlindStraightKickers.getHighestCardCategory().getValue() > dealerStraightKickers.getHighestCardCategory().getValue()) {
            return KickersComparisonResult.BIG_BLIND_WINS;
        }

        if (dealerStraightKickers.getHighestCardCategory().getValue() == bigBlindStraightKickers.getHighestCardCategory().getValue()) {
            return KickersComparisonResult.TIE;
        }

        throw new RuntimeException("unexpected");
    }
}
