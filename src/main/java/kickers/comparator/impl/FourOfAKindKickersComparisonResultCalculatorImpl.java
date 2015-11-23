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

        if (dealerFourOfAKindKickers.getFourOfAKindCardCategory().getValue() > bigBlindFourOfAKindKickers.getFourOfAKindCardCategory().getValue()) {
            return KickersComparisonResult.DEALER_WINS;
        }

        if (bigBlindFourOfAKindKickers.getFourOfAKindCardCategory().getValue() > dealerFourOfAKindKickers.getFourOfAKindCardCategory().getValue()) {
            return KickersComparisonResult.BIG_BLIND_WINS;
        }

        if (dealerFourOfAKindKickers.getFourOfAKindCardCategory().getValue() == bigBlindFourOfAKindKickers.getFourOfAKindCardCategory().getValue()) {
            if (dealerFourOfAKindKickers.getRemainingCardCategory().getValue() > bigBlindFourOfAKindKickers.getRemainingCardCategory().getValue()) {
                return KickersComparisonResult.DEALER_WINS;
            }

            if (bigBlindFourOfAKindKickers.getRemainingCardCategory().getValue() > dealerFourOfAKindKickers.getRemainingCardCategory().getValue()) {
                return KickersComparisonResult.BIG_BLIND_WINS;
            }

            if (dealerFourOfAKindKickers.getRemainingCardCategory().getValue() == bigBlindFourOfAKindKickers.getRemainingCardCategory().getValue()) {
                return KickersComparisonResult.TIE;
            }
        }

        throw new RuntimeException("unexpected");
    }
}
