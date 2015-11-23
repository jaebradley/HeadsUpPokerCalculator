package main.java.kickersComparisonResultCalculator.interfaces;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.StraightKickers;

public interface StraightKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersResult(
            final StraightKickers straightKickers1,
            final StraightKickers straightKickers2
    );
}
