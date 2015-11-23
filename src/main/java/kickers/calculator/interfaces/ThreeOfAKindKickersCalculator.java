package main.java.kickers.calculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.kickers.ThreeOfAKindKickers;
import main.java.kickers.calculator.exceptions.HandDoesNotContainThreeDistinctCardCategoriesException;
import main.java.kickers.calculator.exceptions.HandDoesNotContainThreeOfAKindException;

public interface ThreeOfAKindKickersCalculator {
    ThreeOfAKindKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainThreeOfAKindException,
            HandDoesNotContainThreeDistinctCardCategoriesException;
}
