package main.java.kickers.comparator.impl;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.TwoPairKickers;
import main.java.kickers.comparator.interfaces.TwoPairKickersComparisonResultCalculator;

public class TwoPairKickersComparisonResultCalculatorImpl implements TwoPairKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(
            final TwoPairKickers dealerTwoPairKickers,
            final TwoPairKickers bigBlindTwoPairKickers
    ) {
        if (dealerTwoPairKickers.getHighestPairCardCategory().getValue() > bigBlindTwoPairKickers.getHighestPairCardCategory().getValue()) {
            return KickersComparisonResult.DEALER_WINS;
        }

        if (bigBlindTwoPairKickers.getHighestPairCardCategory().getValue() > dealerTwoPairKickers.getHighestPairCardCategory().getValue()) {
            return KickersComparisonResult.BIG_BLIND_WINS;
        }

        if (dealerTwoPairKickers.getHighestPairCardCategory().getValue() == dealerTwoPairKickers.getHighestPairCardCategory().getValue()) {
            if (dealerTwoPairKickers.getLowestPairCardCategory().getValue() > bigBlindTwoPairKickers.getLowestPairCardCategory().getValue()) {
                return KickersComparisonResult.DEALER_WINS;
            }

            if (bigBlindTwoPairKickers.getLowestPairCardCategory().getValue() > dealerTwoPairKickers.getLowestPairCardCategory().getValue()) {
                return KickersComparisonResult.BIG_BLIND_WINS;
            }

            if (dealerTwoPairKickers.getLowestPairCardCategory().getValue() == bigBlindTwoPairKickers.getLowestPairCardCategory().getValue()) {
                if (dealerTwoPairKickers.getRemainingCardCategory().getValue() > bigBlindTwoPairKickers.getRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.DEALER_WINS;
                }

                if (bigBlindTwoPairKickers.getRemainingCardCategory().getValue() > dealerTwoPairKickers.getRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.BIG_BLIND_WINS;
                }

                if (dealerTwoPairKickers.getRemainingCardCategory().getValue() == bigBlindTwoPairKickers.getRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.TIE;
                }
            }
        }

        throw new RuntimeException("unexpected");
    }
}
