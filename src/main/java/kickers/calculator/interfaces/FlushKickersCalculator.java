package main.java.kickers.calculator.interfaces;

import main.java.common.model.FlushKickers;
import main.java.common.model.Hand;
import main.java.kickers.calculator.exceptions.HandDoesNotContainFiveDistinctCardCategoriesException;

public interface FlushKickersCalculator {
    FlushKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainFiveDistinctCardCategoriesException;
}
