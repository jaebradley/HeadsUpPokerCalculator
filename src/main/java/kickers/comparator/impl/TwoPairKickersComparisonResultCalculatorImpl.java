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
        if (dealerTwoPairKickers.getHighestPairCardCategory().getRankValue() > bigBlindTwoPairKickers.getHighestPairCardCategory().getRankValue()) {
            return KickersComparisonResult.DEALER_WINS;
        }

        if (bigBlindTwoPairKickers.getHighestPairCardCategory().getRankValue() > dealerTwoPairKickers.getHighestPairCardCategory().getRankValue()) {
            return KickersComparisonResult.BIG_BLIND_WINS;
        }

        if (dealerTwoPairKickers.getHighestPairCardCategory().getRankValue() == dealerTwoPairKickers.getHighestPairCardCategory().getRankValue()) {
            if (dealerTwoPairKickers.getLowestPairCardCategory().getRankValue() > bigBlindTwoPairKickers.getLowestPairCardCategory().getRankValue()) {
                return KickersComparisonResult.DEALER_WINS;
            }

            if (bigBlindTwoPairKickers.getLowestPairCardCategory().getRankValue() > dealerTwoPairKickers.getLowestPairCardCategory().getRankValue()) {
                return KickersComparisonResult.BIG_BLIND_WINS;
            }

            if (dealerTwoPairKickers.getLowestPairCardCategory().getRankValue() == bigBlindTwoPairKickers.getLowestPairCardCategory().getRankValue()) {
                if (dealerTwoPairKickers.getRemainingCardCategory().getRankValue() > bigBlindTwoPairKickers.getRemainingCardCategory().getRankValue()) {
                    return KickersComparisonResult.DEALER_WINS;
                }

                if (bigBlindTwoPairKickers.getRemainingCardCategory().getRankValue() > dealerTwoPairKickers.getRemainingCardCategory().getRankValue()) {
                    return KickersComparisonResult.BIG_BLIND_WINS;
                }

                if (dealerTwoPairKickers.getRemainingCardCategory().getRankValue() == bigBlindTwoPairKickers.getRemainingCardCategory().getRankValue()) {
                    return KickersComparisonResult.TIE;
                }
            }
        }

        throw new RuntimeException("unexpected");
    }
}
