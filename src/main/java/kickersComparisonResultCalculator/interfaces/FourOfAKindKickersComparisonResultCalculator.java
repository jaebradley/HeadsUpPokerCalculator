package main.java.kickersComparisonResultCalculator.interfaces;

import main.java.common.model.FourOfAKindKickers;
import main.java.common.model.KickersComparisonResult;

public interface FourOfAKindKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(final FourOfAKindKickers fourOfAKindKickers1, final FourOfAKindKickers fourOfAKindKickers2);
}
