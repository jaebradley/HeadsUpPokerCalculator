package main.java.kickers.comparator.interfaces;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.FourOfAKindKickers;

public interface FourOfAKindKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final FourOfAKindKickers dealerFourOfAKindKickers,
            final FourOfAKindKickers bigBlindFourOfAKindKickers
    );
}
