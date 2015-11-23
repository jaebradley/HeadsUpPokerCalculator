package main.java.kickers.comparator.interfaces;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.TwoPairKickers;

public interface TwoPairKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(final TwoPairKickers twoPairKickers1, final TwoPairKickers twoPairKickers2);
}
