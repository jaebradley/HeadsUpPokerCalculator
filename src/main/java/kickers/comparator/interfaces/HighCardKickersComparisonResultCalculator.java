package main.java.kickers.comparator.interfaces;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.HighCardKickers;

public interface HighCardKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final HighCardKickers highCardKickers1,
            final HighCardKickers highCardKickers2
    );
}
