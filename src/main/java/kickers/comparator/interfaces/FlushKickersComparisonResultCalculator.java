package main.java.kickers.comparator.interfaces;

import main.java.common.model.kickers.FlushKickers;
import main.java.common.model.KickersComparisonResult;

public interface FlushKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final FlushKickers flushKickers1,
            final FlushKickers flushKickers2
    );
}
