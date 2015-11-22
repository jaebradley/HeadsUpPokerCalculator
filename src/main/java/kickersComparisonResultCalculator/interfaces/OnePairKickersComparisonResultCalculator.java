package main.java.kickersComparisonResultCalculator.interfaces;

import main.java.common.model.KickersComparisonResult;
import main.java.common.model.OnePairKickers;

public interface OnePairKickersComparisonResultCalculator {
    KickersComparisonResult calculateKickersComparisonResult(
            final OnePairKickers onePairKickers1,
            final OnePairKickers onePairKickers2
    );
}
