package main.java.headsUp.calculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.HeadsUpResult;
import main.java.headsUp.calculator.exceptions.UnableToCompareKickersException;

public interface IdenticalHandCategoriesHeadsUpResultCalculator {
    HeadsUpResult calculateHeadsUpResultForHandsWithIdenticalCategories(
            final Hand dealerHand,
            final Hand bigBlindHand
    ) throws UnableToCompareKickersException;
}
