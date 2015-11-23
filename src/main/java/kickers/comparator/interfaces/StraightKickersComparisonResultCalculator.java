package main.java.kickers.comparator.interfaces;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.StraightKickers;

public interface StraightKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final StraightKickers dealerStraightKickers,
            final StraightKickers bigBlindStraightKickers
    );
}
