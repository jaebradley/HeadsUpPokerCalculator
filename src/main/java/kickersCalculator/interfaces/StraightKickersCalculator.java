package main.java.kickersCalculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.StraightKickers;
import main.java.kickersCalculator.exceptions.HandDoesNotContainFiveDistinctCardCategoriesException;

public interface StraightKickersCalculator {
    StraightKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainFiveDistinctCardCategoriesException;
}
