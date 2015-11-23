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

        if (dealerThreeOfAKindKickers.getThreeOfAKindCardCategory().getValue() > bigBlindThreeOfAKindKickers.getThreeOfAKindCardCategory().getValue()) {
            return KickersComparisonResult.DEALER_WINS;
        }

        if (bigBlindThreeOfAKindKickers.getThreeOfAKindCardCategory().getValue() > dealerThreeOfAKindKickers.getThreeOfAKindCardCategory().getValue()) {
            return KickersComparisonResult.BIG_BLIND_WINS;
        }

        if (dealerThreeOfAKindKickers.getThreeOfAKindCardCategory().getValue() == bigBlindThreeOfAKindKickers.getThreeOfAKindCardCategory().getValue()) {
            if (dealerThreeOfAKindKickers.getHighestRemainingCardCategory().getValue() > bigBlindThreeOfAKindKickers.getHighestRemainingCardCategory().getValue()) {
                return KickersComparisonResult.DEALER_WINS;
            }

            if (bigBlindThreeOfAKindKickers.getHighestRemainingCardCategory().getValue() > dealerThreeOfAKindKickers.getHighestRemainingCardCategory().getValue()) {
                return KickersComparisonResult.BIG_BLIND_WINS;
            }

            if (dealerThreeOfAKindKickers.getHighestRemainingCardCategory().getValue() == bigBlindThreeOfAKindKickers.getHighestRemainingCardCategory().getValue()) {
                if (dealerThreeOfAKindKickers.getLowestRemainingCardCategory().getValue() > bigBlindThreeOfAKindKickers.getLowestRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.DEALER_WINS;
                }

                if (bigBlindThreeOfAKindKickers.getLowestRemainingCardCategory().getValue() > dealerThreeOfAKindKickers.getLowestRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.BIG_BLIND_WINS;
                }

                if (dealerThreeOfAKindKickers.getLowestRemainingCardCategory().getValue() == bigBlindThreeOfAKindKickers.getLowestRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.TIE;
                }
            }
        }

        throw new RuntimeException("unexpected");
    }
}
