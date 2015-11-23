package main.java.kickersComparisonResultCalculator.interfaces;

import main.java.common.model.FlushKickers;
import main.java.common.model.KickersComparisonResult;

public interface FlushKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final FlushKickers flushKickers1,
            final FlushKickers flushKickers2
    );
}
