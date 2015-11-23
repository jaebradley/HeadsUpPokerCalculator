package main.java.kickers.comparator.interfaces;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.ThreeOfAKindKickers;

public interface ThreeOfAKindKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final ThreeOfAKindKickers threeOfAKindKickers1,
            final ThreeOfAKindKickers threeOfAKindKickers2
    );
}
