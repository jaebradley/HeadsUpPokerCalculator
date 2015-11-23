package main.java.kickers.calculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.kickers.FourOfAKindKickers;
import main.java.kickers.calculator.exceptions.HandDoesNotContainFourOfAKindException;
import main.java.kickers.calculator.exceptions.HandDoesNotContainOneOfAKindException;
import main.java.kickers.calculator.exceptions.HandDoesNotContainTwoDistinctCardCategoriesException;

public interface FourOfAKindKickersCalculator {
    FourOfAKindKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainFourOfAKindException,
            HandDoesNotContainTwoDistinctCardCategoriesException,
            HandDoesNotContainOneOfAKindException;
}
