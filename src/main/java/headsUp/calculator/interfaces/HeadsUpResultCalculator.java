package main.java.headsUp.calculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.HeadsUpResult;
import main.java.headsUp.calculator.exceptions.UnableToCalculateHeadsUpResultException;

public interface HeadsUpResultCalculator {
    HeadsUpResult calculateHeadsUpResult(
            final Hand dealerHand,
            final Hand bigBlindHand
    ) throws UnableToCalculateHeadsUpResultException;
}
