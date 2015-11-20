package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.utils.impl.SortedCardsReturnerImpl;
import main.java.common.utils.interfaces.SortedCardsReturner;
import main.java.handCategoryIdentifier.interfaces.StraightExistenceValidator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class StraightExistenceValidatorImpl implements StraightExistenceValidator {
    @Override
    public boolean validateExistence(final Hand hand) {
        final SortedCardsReturnerImpl sortedCardsReturner = new SortedCardsReturnerImpl();
        final TreeSet<Card> cards = sortedCardsReturner.returnSortedCardsAscending(hand);
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
            ) || (4 == cards.last().getCategory().getValue() - cards.first().getCategory().getValue());
    }
}
