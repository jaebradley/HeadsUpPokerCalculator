package main.java.headsUpResultCalculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.HeadsUpResult;
import main.java.kickersCalculator.exceptions.*;

public interface HeadsUpResultCalculator {
    HeadsUpResult calculateHeadsUpResult(
            final Hand dealerHand,
            final Hand bigBlindHand
    ) throws HandDoesNotContainFiveDistinctCardCategoriesException, HandDoesNotContainTwoOfAKindException, HandDoesNotContainThreeOfAKindException, HandDoesNotContainThreeDistinctCardCategoriesException, HandDoesNotContainFourDistinctCardCategoriesException;
}
