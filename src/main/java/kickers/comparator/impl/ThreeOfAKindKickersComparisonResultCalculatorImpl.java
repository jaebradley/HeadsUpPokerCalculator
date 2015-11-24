package main.java.kickers.comparator.impl;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.ThreeOfAKindKickers;
import main.java.kickers.comparator.interfaces.ThreeOfAKindKickersComparisonResultCalculator;

public class ThreeOfAKindKickersComparisonResultCalculatorImpl implements ThreeOfAKindKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(
            final ThreeOfAKindKickers dealerThreeOfAKindKickers,
            final ThreeOfAKindKickers bigBlindThreeOfAKindKickers
    ) {
        assert null != dealerThreeOfAKindKickers;
        assert null != bigBlindThreeOfAKindKickers;

        if (dealerThreeOfAKindKickers.getThreeOfAKindCardCategory().getRankValue() > bigBlindThreeOfAKindKickers.getThreeOfAKindCardCategory().getRankValue()) {
            return KickersComparisonResult.DEALER_WINS;
        }

        if (bigBlindThreeOfAKindKickers.getThreeOfAKindCardCategory().getRankValue() > dealerThreeOfAKindKickers.getThreeOfAKindCardCategory().getRankValue()) {
            return KickersComparisonResult.BIG_BLIND_WINS;
        }

        if (dealerThreeOfAKindKickers.getThreeOfAKindCardCategory().getRankValue() == bigBlindThreeOfAKindKickers.getThreeOfAKindCardCategory().getRankValue()) {
            if (dealerThreeOfAKindKickers.getHighestRemainingCardCategory().getRankValue() > bigBlindThreeOfAKindKickers.getHighestRemainingCardCategory().getRankValue()) {
                return KickersComparisonResult.DEALER_WINS;
            }

            if (bigBlindThreeOfAKindKickers.getHighestRemainingCardCategory().getRankValue() > dealerThreeOfAKindKickers.getHighestRemainingCardCategory().getRankValue()) {
                return KickersComparisonResult.BIG_BLIND_WINS;
            }

            if (dealerThreeOfAKindKickers.getHighestRemainingCardCategory().getRankValue() == bigBlindThreeOfAKindKickers.getHighestRemainingCardCategory().getRankValue()) {
                if (dealerThreeOfAKindKickers.getLowestRemainingCardCategory().getRankValue() > bigBlindThreeOfAKindKickers.getLowestRemainingCardCategory().getRankValue()) {
                    return KickersComparisonResult.DEALER_WINS;
                }

                if (bigBlindThreeOfAKindKickers.getLowestRemainingCardCategory().getRankValue() > dealerThreeOfAKindKickers.getLowestRemainingCardCategory().getRankValue()) {
                    return KickersComparisonResult.BIG_BLIND_WINS;
                }

                if (dealerThreeOfAKindKickers.getLowestRemainingCardCategory().getRankValue() == bigBlindThreeOfAKindKickers.getLowestRemainingCardCategory().getRankValue()) {
                    return KickersComparisonResult.TIE;
                }
            }
        }

        throw new RuntimeException("unexpected");
    }
}
