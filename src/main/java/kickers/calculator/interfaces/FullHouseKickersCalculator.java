package main.java.kickers.calculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.kickers.FullHouseKickers;
import main.java.kickers.calculator.exceptions.HandDoesNotContainThreeOfAKindException;
import main.java.kickers.calculator.exceptions.HandDoesNotContainTwoOfAKindException;

public interface FullHouseKickersCalculator {
    FullHouseKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainThreeOfAKindException,
            HandDoesNotContainTwoOfAKindException;
}
