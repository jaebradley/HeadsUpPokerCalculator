package main.java.kickers.comparator.interfaces;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.ThreeOfAKindKickers;

public interface ThreeOfAKindKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final ThreeOfAKindKickers dealerThreeOfAKindKickers,
            final ThreeOfAKindKickers bigBlindThreeOfAKindKickers
    );
}
