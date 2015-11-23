package main.java.kickers.comparator.impl;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.FullHouseKickers;
import main.java.kickers.comparator.interfaces.FullHouseKickersComparisonResultCalculator;

public class FullHouseKickersComparisonResultCalculatorImpl implements FullHouseKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(
            final FullHouseKickers dealerFullHouseKickers,
            final FullHouseKickers bigBlindFullHouseKickers
    ) {
        assert null != dealerFullHouseKickers;
        assert null != bigBlindFullHouseKickers;

        if (dealerFullHouseKickers.getThreeOfAKindCardCategory().getValue() > bigBlindFullHouseKickers.getThreeOfAKindCardCategory().getValue()) {
            return KickersComparisonResult.DEALER_WINS;
        }

        if (bigBlindFullHouseKickers.getThreeOfAKindCardCategory().getValue() > dealerFullHouseKickers.getThreeOfAKindCardCategory().getValue()) {
            return KickersComparisonResult.BIG_BLIND_WINS;
        }

        if (dealerFullHouseKickers.getThreeOfAKindCardCategory().getValue() == dealerFullHouseKickers.getThreeOfAKindCardCategory().getValue()) {
            if (dealerFullHouseKickers.getTwoOfAKindCardCategory().getValue() > bigBlindFullHouseKickers.getTwoOfAKindCardCategory().getValue()) {
                return KickersComparisonResult.DEALER_WINS;
            }

            if (bigBlindFullHouseKickers.getTwoOfAKindCardCategory().getValue() > dealerFullHouseKickers.getTwoOfAKindCardCategory().getValue()) {
                return KickersComparisonResult.BIG_BLIND_WINS;
            }

            if (dealerFullHouseKickers.getTwoOfAKindCardCategory().getValue() == bigBlindFullHouseKickers.getTwoOfAKindCardCategory().getValue()) {
                return KickersComparisonResult.TIE;
            }
        }

        throw new RuntimeException("unexpected");
    }
}
