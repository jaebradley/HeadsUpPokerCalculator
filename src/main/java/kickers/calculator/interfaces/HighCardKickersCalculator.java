package main.java.kickers.calculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.HighCardKickers;
import main.java.kickers.calculator.exceptions.HandDoesNotContainFiveDistinctCardCategoriesException;

public interface HighCardKickersCalculator {
    HighCardKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainFiveDistinctCardCategoriesException;
}
