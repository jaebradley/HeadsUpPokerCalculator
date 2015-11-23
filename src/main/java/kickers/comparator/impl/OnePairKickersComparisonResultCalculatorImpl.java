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
        if (dealerOnePairKickers.getPairCardCategory().getValue() > bigBlindOnePairKickers.getPairCardCategory().getValue()) {
            return KickersComparisonResult.DEALER_WINS;
        }

        if (bigBlindOnePairKickers.getPairCardCategory().getValue() > dealerOnePairKickers.getPairCardCategory().getValue()) {
            return KickersComparisonResult.BIG_BLIND_WINS;
        }

        if (dealerOnePairKickers.getPairCardCategory().getValue() == bigBlindOnePairKickers.getPairCardCategory().getValue()) {
            if (dealerOnePairKickers.getHighestRemainingCardCategory().getValue() > bigBlindOnePairKickers.getHighestRemainingCardCategory().getValue()) {
                return KickersComparisonResult.DEALER_WINS;
            }

            if (bigBlindOnePairKickers.getHighestRemainingCardCategory().getValue() > dealerOnePairKickers.getHighestRemainingCardCategory().getValue()) {
                return KickersComparisonResult.BIG_BLIND_WINS;
            }

            if (dealerOnePairKickers.getHighestRemainingCardCategory().getValue() == bigBlindOnePairKickers.getHighestRemainingCardCategory().getValue()) {
                if (dealerOnePairKickers.getSecondHighestRemainingCardCategory().getValue() > bigBlindOnePairKickers.getSecondHighestRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.DEALER_WINS;
                }

                if (bigBlindOnePairKickers.getSecondHighestRemainingCardCategory().getValue() > dealerOnePairKickers.getSecondHighestRemainingCardCategory().getValue()) {
                    return KickersComparisonResult.BIG_BLIND_WINS;
                }

                if (dealerOnePairKickers.getSecondHighestRemainingCardCategory().getValue() == bigBlindOnePairKickers.getSecondHighestRemainingCardCategory().getValue()) {
                    if (dealerOnePairKickers.getLowestRemainingCardCategory().getValue() > bigBlindOnePairKickers.getLowestRemainingCardCategory().getValue()) {
                        return KickersComparisonResult.DEALER_WINS;
                    }

                    if (bigBlindOnePairKickers.getLowestRemainingCardCategory().getValue() > dealerOnePairKickers.getLowestRemainingCardCategory().getValue()) {
                        return KickersComparisonResult.BIG_BLIND_WINS;
                    }

                    if (dealerOnePairKickers.getLowestRemainingCardCategory().getValue() == bigBlindOnePairKickers.getLowestRemainingCardCategory().getValue()) {
                        return KickersComparisonResult.TIE;
                    }
                }
            }
        }

        throw new RuntimeException("unexpected");
    }
}
