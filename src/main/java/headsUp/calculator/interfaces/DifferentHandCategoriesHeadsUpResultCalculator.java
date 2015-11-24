package main.java.headsUp.calculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.HeadsUpResult;

public interface DifferentHandCategoriesHeadsUpResultCalculator {
    HeadsUpResult calculateHeadsUpResultForHandsWithDifferentHandCategories(final Hand dealerHand, final Hand bigBlindHand);
}
