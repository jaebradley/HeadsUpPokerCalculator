package main.java.kickersComparisonResultCalculator.interfaces;

import main.java.common.model.FullHouseKickers;
import main.java.common.model.KickersComparisonResult;

public interface FullHouseKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final FullHouseKickers fullHouseKickers1,
            final FullHouseKickers fullHouseKickers2
    );
}
