package main.java.kickers.comparator.interfaces;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.OnePairKickers;

public interface OnePairKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final OnePairKickers dealerOnePairKickers,
            final OnePairKickers bigBlindOnePairKickers
    );
}
