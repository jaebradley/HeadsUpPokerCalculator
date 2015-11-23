package main.java.headsUp.calculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.HeadsUpResult;
import main.java.kickers.calculator.exceptions.*;

public interface HeadsUpResultCalculator {
    HeadsUpResult calculateHeadsUpResult(
            final Hand dealerHand,
            final Hand bigBlindHand
    ) throws HandDoesNotContainFiveDistinctCardCategoriesException, HandDoesNotContainTwoOfAKindException, HandDoesNotContainThreeOfAKindException, HandDoesNotContainThreeDistinctCardCategoriesException, HandDoesNotContainFourDistinctCardCategoriesException, HandDoesNotContainTwoDistinctCardCategoriesException, HandDoesNotContainFourOfAKindException, HandDoesNotContainOneOfAKindException;
}
