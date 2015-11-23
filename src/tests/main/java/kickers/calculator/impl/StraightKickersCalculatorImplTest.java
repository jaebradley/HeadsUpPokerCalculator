package main.java.kickers.calculator.impl;

import main.java.common.model.*;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.TreeSet;

public class StraightKickersCalculatorImplTest {
    private final SortedCardCategoryReturner sortedCardCategoryReturner = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> results = new TreeSet<>();
            results.add(CardCategory.ACE);
            results.add(CardCategory.TWO);
            results.add(CardCategory.FIVE);
            results.add(CardCategory.KING);
            results.add(CardCategory.NINE);
            return results;
        }
    };
    private final SortedCardCategoryReturner lowStraightCardCategoryReturner = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> results = new TreeSet<>();
            results.add(CardCategory.ACE);
            results.add(CardCategory.TWO);
            results.add(CardCategory.THREE);
            results.add(CardCategory.FOUR);
            results.add(CardCategory.FIVE);
            return results;
        }
    };

    private final StraightKickersCalculatorImpl sortedStraightKickersReturner = new StraightKickersCalculatorImpl(sortedCardCategoryReturner);
    private final StraightKickersCalculatorImpl lowStraightKickersReturner = new StraightKickersCalculatorImpl(lowStraightCardCategoryReturner);
    @Test
    public void testExpected() throws Exception {
        final HashSet<Card> cards = new HashSet<>();
        cards.add(new Card(CardCategory.THREE, Suit.CLUBS));
        cards.add(new Card(CardCategory.FOUR, Suit.DIAMONDS));
        cards.add(new Card(CardCategory.SIX, Suit.HEARTS));
        cards.add(new Card(CardCategory.JACK, Suit.SPADES));
        cards.add(new Card(CardCategory.NINE, Suit.SPADES));
        final Hand hand = new Hand(cards);
        final StraightKickers straightKickers = sortedStraightKickersReturner.calculateKickers(hand);
        Assert.assertEquals(CardCategory.ACE, straightKickers.getHighestCardCategory());
    }

    @Test
    public void testLowStraight() throws Exception  {
        final HashSet<Card> cards = new HashSet<>();
        cards.add(new Card(CardCategory.THREE, Suit.CLUBS));
        cards.add(new Card(CardCategory.FOUR, Suit.DIAMONDS));
        cards.add(new Card(CardCategory.SIX, Suit.HEARTS));
        cards.add(new Card(CardCategory.JACK, Suit.SPADES));
        cards.add(new Card(CardCategory.NINE, Suit.SPADES));
        final Hand hand = new Hand(cards);
        final StraightKickers straightKickers = lowStraightKickersReturner.calculateKickers(hand);
        Assert.assertEquals(CardCategory.FIVE, straightKickers.getHighestCardCategory());
    }

}