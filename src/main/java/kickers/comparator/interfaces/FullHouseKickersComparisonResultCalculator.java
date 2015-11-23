package main.java.kickers.comparator.interfaces;

import main.java.common.model.kickers.FullHouseKickers;
import main.java.common.model.KickersComparisonResult;

public interface FullHouseKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final FullHouseKickers fullHouseKickers1,
            final FullHouseKickers fullHouseKickers2
    );
}
