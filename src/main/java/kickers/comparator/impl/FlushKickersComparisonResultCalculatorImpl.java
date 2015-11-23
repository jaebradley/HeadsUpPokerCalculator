package main.java.kickers.comparator.impl;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.FlushKickers;
import main.java.kickers.comparator.interfaces.FlushKickersComparisonResultCalculator;

public class FlushKickersComparisonResultCalculatorImpl implements FlushKickersComparisonResultCalculator {
    @Override
    public KickersComparisonResult calculateKickersComparisonResult(final FlushKickers dealerFlushKickers, final FlushKickers bigBlindFlushKickers) {
        if (dealerFlushKickers.getHighestCardCategory().getValue() > bigBlindFlushKickers.getHighestCardCategory().getValue()) {
            return KickersComparisonResult.DEALER_WINS;
        }

        if (bigBlindFlushKickers.getHighestCardCategory().getValue() > dealerFlushKickers.getHighestCardCategory().getValue()) {
            return KickersComparisonResult.BIG_BLIND_WINS;
        }

        if (dealerFlushKickers.getHighestCardCategory().getValue() == bigBlindFlushKickers.getHighestCardCategory().getValue()) {
            if (dealerFlushKickers.getSecondHighestCardCategory().getValue() > bigBlindFlushKickers.getSecondHighestCardCategory().getValue()) {
                return KickersComparisonResult.DEALER_WINS;
            }

            if (bigBlindFlushKickers.getSecondHighestCardCategory().getValue() > dealerFlushKickers.getSecondHighestCardCategory().getValue()) {
                return KickersComparisonResult.BIG_BLIND_WINS;
            }

            if (dealerFlushKickers.getSecondHighestCardCategory().getValue() == bigBlindFlushKickers.getSecondHighestCardCategory().getValue()) {
                if (dealerFlushKickers.getThirdHighestCardCategory().getValue() > bigBlindFlushKickers.getThirdHighestCardCategory().getValue()) {
                    return KickersComparisonResult.DEALER_WINS;
                }

                if (bigBlindFlushKickers.getThirdHighestCardCategory().getValue() > dealerFlushKickers.getThirdHighestCardCategory().getValue()) {
                    return KickersComparisonResult.BIG_BLIND_WINS;
                }

                if (dealerFlushKickers.getThirdHighestCardCategory().getValue() == bigBlindFlushKickers.getThirdHighestCardCategory().getValue()) {
                    if (dealerFlushKickers.getFourthHighestCardCategory().getValue() > bigBlindFlushKickers.getFourthHighestCardCategory().getValue()) {
                        return KickersComparisonResult.DEALER_WINS;
                    }

                    if (bigBlindFlushKickers.getFourthHighestCardCategory().getValue() > dealerFlushKickers.getFourthHighestCardCategory().getValue()) {
                        return KickersComparisonResult.BIG_BLIND_WINS;
                    }

                    if (dealerFlushKickers.getFourthHighestCardCategory().getValue() == bigBlindFlushKickers.getFourthHighestCardCategory().getValue()) {
                        if (dealerFlushKickers.getFifthHighestCardCategory().getValue() > bigBlindFlushKickers.getFifthHighestCardCategory().getValue()) {
                            return KickersComparisonResult.DEALER_WINS;
                        }

                        if (bigBlindFlushKickers.getFifthHighestCardCategory().getValue() > dealerFlushKickers.getFifthHighestCardCategory().getValue()) {
                            return KickersComparisonResult.BIG_BLIND_WINS;
                        }

                        if (dealerFlushKickers.getFifthHighestCardCategory().getValue() == bigBlindFlushKickers.getFifthHighestCardCategory().getValue()) {
                            return KickersComparisonResult.TIE;
                        }
                    }
                }
            }
        }

        throw new RuntimeException("unexpected");
    }
}
