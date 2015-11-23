package main.java.kickers.comparator.interfaces;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.FlushKickers;

public interface FlushKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final FlushKickers dealerFlushKickers,
            final FlushKickers bigBlindFlushKickers
    );
}
