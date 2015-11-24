package main.java.kickers.comparator.impl;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.FlushKickers;
import main.java.kickers.comparator.interfaces.FlushKickersComparisonResultCalculator;

public class FlushKickersComparisonResultCalculatorImpl implements FlushKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(final FlushKickers dealerFlushKickers, final FlushKickers bigBlindFlushKickers) {
        if (dealerFlushKickers.getHighestCardCategory().getRankValue() > bigBlindFlushKickers.getHighestCardCategory().getRankValue()) {
            return KickersComparisonResult.DEALER_WINS;
        }

        if (bigBlindFlushKickers.getHighestCardCategory().getRankValue() > dealerFlushKickers.getHighestCardCategory().getRankValue()) {
            return KickersComparisonResult.BIG_BLIND_WINS;
        }

        if (dealerFlushKickers.getHighestCardCategory().getRankValue() == bigBlindFlushKickers.getHighestCardCategory().getRankValue()) {
            if (dealerFlushKickers.getSecondHighestCardCategory().getRankValue() > bigBlindFlushKickers.getSecondHighestCardCategory().getRankValue()) {
                return KickersComparisonResult.DEALER_WINS;
            }

            if (bigBlindFlushKickers.getSecondHighestCardCategory().getRankValue() > dealerFlushKickers.getSecondHighestCardCategory().getRankValue()) {
                return KickersComparisonResult.BIG_BLIND_WINS;
            }

            if (dealerFlushKickers.getSecondHighestCardCategory().getRankValue() == bigBlindFlushKickers.getSecondHighestCardCategory().getRankValue()) {
                if (dealerFlushKickers.getThirdHighestCardCategory().getRankValue() > bigBlindFlushKickers.getThirdHighestCardCategory().getRankValue()) {
                    return KickersComparisonResult.DEALER_WINS;
                }

                if (bigBlindFlushKickers.getThirdHighestCardCategory().getRankValue() > dealerFlushKickers.getThirdHighestCardCategory().getRankValue()) {
                    return KickersComparisonResult.BIG_BLIND_WINS;
                }

                if (dealerFlushKickers.getThirdHighestCardCategory().getRankValue() == bigBlindFlushKickers.getThirdHighestCardCategory().getRankValue()) {
                    if (dealerFlushKickers.getFourthHighestCardCategory().getRankValue() > bigBlindFlushKickers.getFourthHighestCardCategory().getRankValue()) {
                        return KickersComparisonResult.DEALER_WINS;
                    }

                    if (bigBlindFlushKickers.getFourthHighestCardCategory().getRankValue() > dealerFlushKickers.getFourthHighestCardCategory().getRankValue()) {
                        return KickersComparisonResult.BIG_BLIND_WINS;
                    }

                    if (dealerFlushKickers.getFourthHighestCardCategory().getRankValue() == bigBlindFlushKickers.getFourthHighestCardCategory().getRankValue()) {
                        if (dealerFlushKickers.getFifthHighestCardCategory().getRankValue() > bigBlindFlushKickers.getFifthHighestCardCategory().getRankValue()) {
                            return KickersComparisonResult.DEALER_WINS;
                        }

                        if (bigBlindFlushKickers.getFifthHighestCardCategory().getRankValue() > dealerFlushKickers.getFifthHighestCardCategory().getRankValue()) {
                            return KickersComparisonResult.BIG_BLIND_WINS;
                        }

                        if (dealerFlushKickers.getFifthHighestCardCategory().getRankValue() == bigBlindFlushKickers.getFifthHighestCardCategory().getRankValue()) {
                            return KickersComparisonResult.TIE;
                        }
                    }
                }
            }
        }

        throw new RuntimeException("unexpected");
    }
}
