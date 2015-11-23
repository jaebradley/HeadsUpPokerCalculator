package main.java.kickers.calculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.kickers.StraightKickers;
import main.java.kickers.calculator.exceptions.HandDoesNotContainFiveDistinctCardCategoriesException;

public interface StraightKickersCalculator {
    StraightKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainFiveDistinctCardCategoriesException;
}
