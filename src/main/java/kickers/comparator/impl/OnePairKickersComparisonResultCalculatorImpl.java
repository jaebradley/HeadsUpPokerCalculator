package main.java.kickers.comparator.impl;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.OnePairKickers;
import main.java.kickers.comparator.interfaces.OnePairKickersComparisonResultCalculator;


public class OnePairKickersComparisonResultCalculatorImpl implements OnePairKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(
            final OnePairKickers dealerOnePairKickers,
            final OnePairKickers bigBlindOnePairKickers
    ) {
        if (dealerOnePairKickers.getPairCardCategory().getRankValue() > bigBlindOnePairKickers.getPairCardCategory().getRankValue()) {
            return KickersComparisonResult.DEALER_WINS;
        }

        if (bigBlindOnePairKickers.getPairCardCategory().getRankValue() > dealerOnePairKickers.getPairCardCategory().getRankValue()) {
            return KickersComparisonResult.BIG_BLIND_WINS;
        }

        if (dealerOnePairKickers.getPairCardCategory().getRankValue() == bigBlindOnePairKickers.getPairCardCategory().getRankValue()) {
            if (dealerOnePairKickers.getHighestRemainingCardCategory().getRankValue() > bigBlindOnePairKickers.getHighestRemainingCardCategory().getRankValue()) {
                return KickersComparisonResult.DEALER_WINS;
            }

            if (bigBlindOnePairKickers.getHighestRemainingCardCategory().getRankValue() > dealerOnePairKickers.getHighestRemainingCardCategory().getRankValue()) {
                return KickersComparisonResult.BIG_BLIND_WINS;
            }

            if (dealerOnePairKickers.getHighestRemainingCardCategory().getRankValue() == bigBlindOnePairKickers.getHighestRemainingCardCategory().getRankValue()) {
                if (dealerOnePairKickers.getSecondHighestRemainingCardCategory().getRankValue() > bigBlindOnePairKickers.getSecondHighestRemainingCardCategory().getRankValue()) {
                    return KickersComparisonResult.DEALER_WINS;
                }

                if (bigBlindOnePairKickers.getSecondHighestRemainingCardCategory().getRankValue() > dealerOnePairKickers.getSecondHighestRemainingCardCategory().getRankValue()) {
                    return KickersComparisonResult.BIG_BLIND_WINS;
                }

                if (dealerOnePairKickers.getSecondHighestRemainingCardCategory().getRankValue() == bigBlindOnePairKickers.getSecondHighestRemainingCardCategory().getRankValue()) {
                    if (dealerOnePairKickers.getLowestRemainingCardCategory().getRankValue() > bigBlindOnePairKickers.getLowestRemainingCardCategory().getRankValue()) {
                        return KickersComparisonResult.DEALER_WINS;
                    }

                    if (bigBlindOnePairKickers.getLowestRemainingCardCategory().getRankValue() > dealerOnePairKickers.getLowestRemainingCardCategory().getRankValue()) {
                        return KickersComparisonResult.BIG_BLIND_WINS;
                    }

                    if (dealerOnePairKickers.getLowestRemainingCardCategory().getRankValue() == bigBlindOnePairKickers.getLowestRemainingCardCategory().getRankValue()) {
                        return KickersComparisonResult.TIE;
                    }
                }
            }
        }

        throw new RuntimeException("unexpected");
    }
}
