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
        if (dealerHighCardKickers.getHighestCardCategory().getRankValue() > bigBlindHighCardKickers.getHighestCardCategory().getRankValue()) {
            return KickersComparisonResult.DEALER_WINS;
        }

        if (bigBlindHighCardKickers.getHighestCardCategory().getRankValue() > dealerHighCardKickers.getHighestCardCategory().getRankValue()) {
            return KickersComparisonResult.BIG_BLIND_WINS;
        }

        if (dealerHighCardKickers.getHighestCardCategory().getRankValue() == bigBlindHighCardKickers.getHighestCardCategory().getRankValue()) {
            if (dealerHighCardKickers.getSecondHighestCardCategory().getRankValue() > bigBlindHighCardKickers.getSecondHighestCardCategory().getRankValue()) {
                return KickersComparisonResult.DEALER_WINS;
            }

            if (bigBlindHighCardKickers.getSecondHighestCardCategory().getRankValue() > dealerHighCardKickers.getSecondHighestCardCategory().getRankValue()) {
                return KickersComparisonResult.BIG_BLIND_WINS;
            }

            if (dealerHighCardKickers.getSecondHighestCardCategory().getRankValue() == bigBlindHighCardKickers.getSecondHighestCardCategory().getRankValue()) {
                if (dealerHighCardKickers.getThirdHighestCardCategory().getRankValue() > bigBlindHighCardKickers.getThirdHighestCardCategory().getRankValue()) {
                    return KickersComparisonResult.DEALER_WINS;
                }

                if (bigBlindHighCardKickers.getThirdHighestCardCategory().getRankValue() > dealerHighCardKickers.getThirdHighestCardCategory().getRankValue()) {
                    return KickersComparisonResult.BIG_BLIND_WINS;
                }

                if (dealerHighCardKickers.getThirdHighestCardCategory().getRankValue() == bigBlindHighCardKickers.getThirdHighestCardCategory().getRankValue()) {
                    if (dealerHighCardKickers.getFourthHighestCardCategory().getRankValue() > bigBlindHighCardKickers.getFourthHighestCardCategory().getRankValue()) {
                        return KickersComparisonResult.DEALER_WINS;
                    }

                    if (bigBlindHighCardKickers.getFourthHighestCardCategory().getRankValue() > dealerHighCardKickers.getFourthHighestCardCategory().getRankValue()) {
                        return KickersComparisonResult.BIG_BLIND_WINS;
                    }

                    if (dealerHighCardKickers.getFourthHighestCardCategory().getRankValue() == bigBlindHighCardKickers.getFourthHighestCardCategory().getRankValue()) {
                        if (dealerHighCardKickers.getFifthHighestCardCategory().getRankValue() > bigBlindHighCardKickers.getFifthHighestCardCategory().getRankValue()) {
                            return KickersComparisonResult.DEALER_WINS;
                        }

                        if (bigBlindHighCardKickers.getFifthHighestCardCategory().getRankValue() > dealerHighCardKickers.getFifthHighestCardCategory().getRankValue()) {
                            return KickersComparisonResult.BIG_BLIND_WINS;
                        }

                        if (dealerHighCardKickers.getFifthHighestCardCategory().getRankValue() == bigBlindHighCardKickers.getFifthHighestCardCategory().getRankValue()) {
                            return KickersComparisonResult.TIE;
                        }
                    }
                }
            }
        }

        throw new RuntimeException("unexpected");
    }
}
