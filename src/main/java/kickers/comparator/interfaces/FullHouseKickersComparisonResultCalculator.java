package main.java.kickers.comparator.interfaces;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.FullHouseKickers;

public interface FullHouseKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final FullHouseKickers fullHouseKickers1,
            final FullHouseKickers fullHouseKickers2
    );
}
