package main.java.kickersComparisonResultCalculator.interfaces;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.TwoPairKickers;

public interface TwoPairKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(final TwoPairKickers twoPairKickers1, final TwoPairKickers twoPairKickers2);
}
