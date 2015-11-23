package main.java.kickers.calculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.OnePairKickers;
import main.java.kickers.calculator.exceptions.HandDoesNotContainFourDistinctCardCategoriesException;
import main.java.kickers.calculator.exceptions.HandDoesNotContainTwoOfAKindException;

public interface OnePairKickersCalculator {
    OnePairKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainFourDistinctCardCategoriesException, HandDoesNotContainTwoOfAKindException;
}
