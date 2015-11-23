package main.java.kickers.comparator.interfaces;

import main.java.common.model.kickers.FourOfAKindKickers;
import main.java.common.model.KickersComparisonResult;

public interface FourOfAKindKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final FourOfAKindKickers fourOfAKindKickers1,
            final FourOfAKindKickers fourOfAKindKickers2
    );
}
