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

        if (dealerFullHouseKickers.getThreeOfAKindCardCategory().getRankValue() > bigBlindFullHouseKickers.getThreeOfAKindCardCategory().getRankValue()) {
            return KickersComparisonResult.DEALER_WINS;
        }

        if (bigBlindFullHouseKickers.getThreeOfAKindCardCategory().getRankValue() > dealerFullHouseKickers.getThreeOfAKindCardCategory().getRankValue()) {
            return KickersComparisonResult.BIG_BLIND_WINS;
        }

        if (dealerFullHouseKickers.getThreeOfAKindCardCategory().getRankValue() == dealerFullHouseKickers.getThreeOfAKindCardCategory().getRankValue()) {
            if (dealerFullHouseKickers.getTwoOfAKindCardCategory().getRankValue() > bigBlindFullHouseKickers.getTwoOfAKindCardCategory().getRankValue()) {
                return KickersComparisonResult.DEALER_WINS;
            }

            if (bigBlindFullHouseKickers.getTwoOfAKindCardCategory().getRankValue() > dealerFullHouseKickers.getTwoOfAKindCardCategory().getRankValue()) {
                return KickersComparisonResult.BIG_BLIND_WINS;
            }

            if (dealerFullHouseKickers.getTwoOfAKindCardCategory().getRankValue() == bigBlindFullHouseKickers.getTwoOfAKindCardCategory().getRankValue()) {
                return KickersComparisonResult.TIE;
            }
        }

        throw new RuntimeException("unexpected");
    }
}
