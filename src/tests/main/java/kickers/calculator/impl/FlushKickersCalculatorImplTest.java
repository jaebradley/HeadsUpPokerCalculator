package main.java.kickers.calculator.impl;


import main.java.common.model.*;
import main.java.common.model.comparators.CardCategoryComparator;
import main.java.common.model.kickers.FlushKickers;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import main.java.kickers.calculator.exceptions.HandDoesNotContainFiveDistinctCardCategoriesException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.TreeSet;

public class FlushKickersCalculatorImplTest {

    // Tests
    // Test null hand
    // Test 2, 3, 4 distinct card categories
    // Test flush hand and expected kickers
    private final SortedCardCategoryReturner nullCardCategories = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            return null;
        }
    };
    private final SortedCardCategoryReturner emptyCardCategories = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> results = new TreeSet<>(new CardCategoryComparator());
            return results;
        }
    };

    private final SortedCardCategoryReturner twoDistinctCardCategories = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> results = new TreeSet<>(new CardCategoryComparator());
            results.add(CardCategory.NINE);
            results.add(CardCategory.EIGHT);
            return results;
        }
    };
    private final SortedCardCategoryReturner threeDistinctCardCategories = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> results = new TreeSet<>(new CardCategoryComparator());
            results.add(CardCategory.NINE);
            results.add(CardCategory.EIGHT);
            results.add(CardCategory.TEN);
            return results;
        }
    };
    private final SortedCardCategoryReturner fourDistinctCardCategories = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> results = new TreeSet<>(new CardCategoryComparator());
            results.add(CardCategory.NINE);
            results.add(CardCategory.EIGHT);
            results.add(CardCategory.TEN);
            results.add(CardCategory.JACK);
            return results;
        }
    };
    private final SortedCardCategoryReturner fiveDistinctCardCategories = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> results = new TreeSet<>(new CardCategoryComparator());
            results.add(CardCategory.NINE);
            results.add(CardCategory.EIGHT);
            results.add(CardCategory.TEN);
            results.add(CardCategory.JACK);
            results.add(CardCategory.FIVE);
            return results;
        }
    };
    private final FlushKickersCalculatorImpl nullCardCategoriesFlushKickersCalculator = new FlushKickersCalculatorImpl(nullCardCategories);
    private final FlushKickersCalculatorImpl emptyCardCategoriesFlushKickersCalculator = new FlushKickersCalculatorImpl(emptyCardCategories);
    private final FlushKickersCalculatorImpl twoDistinctCardCategoriesFlushKickersCalculator = new FlushKickersCalculatorImpl(twoDistinctCardCategories);
    private final FlushKickersCalculatorImpl threeDistinctCardCategoriesFlushKickersCalculator = new FlushKickersCalculatorImpl(threeDistinctCardCategories);
    private final FlushKickersCalculatorImpl fourDistinctCardCategoriesFlushKickersCalculator = new FlushKickersCalculatorImpl(fourDistinctCardCategories);
    private final FlushKickersCalculatorImpl fiveDistinctCardCategoriesFlushKickersCalculator = new FlushKickersCalculatorImpl(fiveDistinctCardCategories);

    @Test
    public void testNull() throws HandDoesNotContainFiveDistinctCardCategoriesException {
        try {
            nullCardCategoriesFlushKickersCalculator.calculateKickers(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            emptyCardCategoriesFlushKickersCalculator.calculateKickers(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            twoDistinctCardCategoriesFlushKickersCalculator.calculateKickers(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            threeDistinctCardCategoriesFlushKickersCalculator.calculateKickers(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            fourDistinctCardCategoriesFlushKickersCalculator.calculateKickers(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            fiveDistinctCardCategoriesFlushKickersCalculator.calculateKickers(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }
    }

    @Test
    public void testHandsWithoutFiveDistinctCardCategories() throws HandDoesNotContainFiveDistinctCardCategoriesException {
        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        try {
            nullCardCategoriesFlushKickersCalculator.calculateKickers(fooHand);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            emptyCardCategoriesFlushKickersCalculator.calculateKickers(fooHand);
            Assert.fail();
        } catch (HandDoesNotContainFiveDistinctCardCategoriesException e) {
            // expected
        }
        try {
            twoDistinctCardCategoriesFlushKickersCalculator.calculateKickers(fooHand);
            Assert.fail();
        } catch (HandDoesNotContainFiveDistinctCardCategoriesException e) {
            // expected
        }

        try {
            threeDistinctCardCategoriesFlushKickersCalculator.calculateKickers(fooHand);
            Assert.fail();
        } catch (HandDoesNotContainFiveDistinctCardCategoriesException e) {
            // expected
        }

        try {
            fourDistinctCardCategoriesFlushKickersCalculator.calculateKickers(fooHand);
            Assert.fail();
        } catch (HandDoesNotContainFiveDistinctCardCategoriesException e) {
            // expected
        }
    }

    @Test
    public void testFlush() throws HandDoesNotContainFiveDistinctCardCategoriesException {
        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);
        final FlushKickers result = fiveDistinctCardCategoriesFlushKickersCalculator.calculateKickers(fooHand);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getHighestCardCategory(), CardCategory.JACK);
        Assert.assertEquals(result.getSecondHighestCardCategory(), CardCategory.TEN);
        Assert.assertEquals(result.getThirdHighestCardCategory(), CardCategory.NINE);
        Assert.assertEquals(result.getFourthHighestCardCategory(), CardCategory.EIGHT);
        Assert.assertEquals(result.getFifthHighestCardCategory(), CardCategory.FIVE);
    }

}