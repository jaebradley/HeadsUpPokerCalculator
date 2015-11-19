package main.java.handCategoryCalculator.impl;

import main.java.common.model.Card;
import main.java.common.model.Hand;
import main.java.common.utils.impl.UniqueCardCategoryCounter;
import main.java.handCategoryCalculator.interfaces.HandCategoryValidator;

import java.util.TreeSet;

public class FourOfAKindValidator implements HandCategoryValidator {

    @Override
    public boolean validateHand(final Hand hand) {
        final TreeSet<Card> orderedCards = hand.getCardsOrderedByCategory();
        return (2 != UniqueCardCategoryCounter.countUniqueCardCategories(hand));
    }
}
