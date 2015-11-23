package main.java.kickers.comparator.interfaces;

import main.java.common.model.HighCardKickers;
import main.java.common.model.KickersComparisonResult;

public interface HighCardKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final HighCardKickers highCardKickers1,
            final HighCardKickers highCardKickers2
    );
}
