package main.java.kickers.comparator.interfaces;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.TwoPairKickers;

public interface TwoPairKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final TwoPairKickers dealerTwoPairKickers,
            final TwoPairKickers bigBlindTwoPairKickers
    );
}
