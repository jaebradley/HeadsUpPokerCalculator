package main.java.handCategoryCalculator.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.handCategoryCalculator.interfaces.HandCategoryValidator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class StraightValidator implements HandCategoryValidator {
    @Override
    public boolean validateHand(final Hand hand) {
        final TreeSet<Card> cards = hand.getCards();
        final Iterator<Card> cardIterator = cards.iterator();
        final ArrayList<CardCategory> cardCategories = new ArrayList<>();
        while (cardIterator.hasNext()) {
            cardCategories.add(cardIterator.next().getCategory());
        }

        return (cardCategories.contains(CardCategory.ACE) &&
                cardCategories.contains(CardCategory.TWO) &&
                cardCategories.contains(CardCategory.THREE) &&
                cardCategories.contains(CardCategory.FOUR) &&
                cardCategories.contains(CardCategory.FIVE)
            ) || (4 != cards.last().getCategory().getValue() - cards.first().getCategory().getValue());
    }
}
