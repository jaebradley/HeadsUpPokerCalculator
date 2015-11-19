package main.java.common.utils.interfaces;

import main.java.common.model.Card;
import main.java.common.model.Hand;

import java.util.TreeSet;

public interface SortedCardsReturner {
    TreeSet<Card> returnSortedCardsAscending(final Hand hand);
}
