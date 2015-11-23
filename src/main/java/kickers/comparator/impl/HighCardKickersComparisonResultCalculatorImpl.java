package main.java.kickers.comparator.impl;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.HighCardKickers;
import main.java.kickers.comparator.interfaces.HighCardKickersComparisonResultCalculator;

public class HighCardKickersComparisonResultCalculatorImpl implements HighCardKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(
            final HighCardKickers dealerHighCardKickers,
            final HighCardKickers bigBlindHighCardKickers
    ) {
        if (dealerHighCardKickers.getHighestCardCategory().getValue() > bigBlindHighCardKickers.getHighestCardCategory().getValue()) {
            return KickersComparisonResult.DEALER_WINS;
        }

        if (bigBlindHighCardKickers.getHighestCardCategory().getValue() > dealerHighCardKickers.getHighestCardCategory().getValue()) {
            return KickersComparisonResult.BIG_BLIND_WINS;
        }

        if (dealerHighCardKickers.getHighestCardCategory().getValue() == bigBlindHighCardKickers.getHighestCardCategory().getValue()) {
            if (dealerHighCardKickers.getSecondHighestCardCategory().getValue() > bigBlindHighCardKickers.getSecondHighestCardCategory().getValue()) {
                return KickersComparisonResult.DEALER_WINS;
            }

            if (bigBlindHighCardKickers.getSecondHighestCardCategory().getValue() > dealerHighCardKickers.getSecondHighestCardCategory().getValue()) {
                return KickersComparisonResult.BIG_BLIND_WINS;
            }

            if (dealerHighCardKickers.getSecondHighestCardCategory().getValue() == bigBlindHighCardKickers.getSecondHighestCardCategory().getValue()) {
                if (dealerHighCardKickers.getThirdHighestCardCategory().getValue() > bigBlindHighCardKickers.getThirdHighestCardCategory().getValue()) {
                    return KickersComparisonResult.DEALER_WINS;
                }

                if (bigBlindHighCardKickers.getThirdHighestCardCategory().getValue() > dealerHighCardKickers.getThirdHighestCardCategory().getValue()) {
                    return KickersComparisonResult.BIG_BLIND_WINS;
                }

                if (dealerHighCardKickers.getThirdHighestCardCategory().getValue() == bigBlindHighCardKickers.getThirdHighestCardCategory().getValue()) {
                    if (dealerHighCardKickers.getFourthHighestCardCategory().getValue() > bigBlindHighCardKickers.getFourthHighestCardCategory().getValue()) {
                        return KickersComparisonResult.DEALER_WINS;
                    }

                    if (bigBlindHighCardKickers.getFourthHighestCardCategory().getValue() > dealerHighCardKickers.getFourthHighestCardCategory().getValue()) {
                        return KickersComparisonResult.BIG_BLIND_WINS;
                    }

                    if (dealerHighCardKickers.getFourthHighestCardCategory().getValue() == bigBlindHighCardKickers.getFourthHighestCardCategory().getValue()) {
                        if (dealerHighCardKickers.getFifthHighestCardCategory().getValue() > bigBlindHighCardKickers.getFifthHighestCardCategory().getValue()) {
                            return KickersComparisonResult.DEALER_WINS;
                        }

                        if (bigBlindHighCardKickers.getFifthHighestCardCategory().getValue() > dealerHighCardKickers.getFifthHighestCardCategory().getValue()) {
                            return KickersComparisonResult.BIG_BLIND_WINS;
                        }

                        if (dealerHighCardKickers.getFifthHighestCardCategory().getValue() == bigBlindHighCardKickers.getFifthHighestCardCategory().getValue()) {
                            return KickersComparisonResult.TIE;
                        }
                    }
                }
            }
        }

        throw new RuntimeException("unexpected");
    }
}
