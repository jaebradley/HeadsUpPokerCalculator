package main.java.kickers.calculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.TwoPairKickers;
import main.java.kickers.calculator.exceptions.HandDoesNotContainThreeDistinctCardCategoriesException;
import main.java.kickers.calculator.exceptions.HandDoesNotContainTwoOfAKindException;

public interface TwoPairKickersCalculator {
    TwoPairKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainThreeDistinctCardCategoriesException,
            HandDoesNotContainTwoOfAKindException;
}
