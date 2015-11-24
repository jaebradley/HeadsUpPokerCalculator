package main.java.kickers.comparator.impl;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.FourOfAKindKickers;
import main.java.kickers.comparator.interfaces.FourOfAKindKickersComparisonResultCalculator;

public class FourOfAKindKickersComparisonResultCalculatorImpl implements FourOfAKindKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(
            final FourOfAKindKickers dealerFourOfAKindKickers,
            final FourOfAKindKickers bigBlindFourOfAKindKickers
    ) {
        assert null != dealerFourOfAKindKickers;
        assert null != bigBlindFourOfAKindKickers;

        if (dealerFourOfAKindKickers.getFourOfAKindCardCategory().getRankValue() > bigBlindFourOfAKindKickers.getFourOfAKindCardCategory().getRankValue()) {
            return KickersComparisonResult.DEALER_WINS;
        }

        if (bigBlindFourOfAKindKickers.getFourOfAKindCardCategory().getRankValue() > dealerFourOfAKindKickers.getFourOfAKindCardCategory().getRankValue()) {
            return KickersComparisonResult.BIG_BLIND_WINS;
        }

        if (dealerFourOfAKindKickers.getFourOfAKindCardCategory().getRankValue() == bigBlindFourOfAKindKickers.getFourOfAKindCardCategory().getRankValue()) {
            if (dealerFourOfAKindKickers.getRemainingCardCategory().getRankValue() > bigBlindFourOfAKindKickers.getRemainingCardCategory().getRankValue()) {
                return KickersComparisonResult.DEALER_WINS;
            }

            if (bigBlindFourOfAKindKickers.getRemainingCardCategory().getRankValue() > dealerFourOfAKindKickers.getRemainingCardCategory().getRankValue()) {
                return KickersComparisonResult.BIG_BLIND_WINS;
            }

            if (dealerFourOfAKindKickers.getRemainingCardCategory().getRankValue() == bigBlindFourOfAKindKickers.getRemainingCardCategory().getRankValue()) {
                return KickersComparisonResult.TIE;
            }
        }

        throw new RuntimeException("unexpected");
    }
}
