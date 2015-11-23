package main.java.kickers.calculator.impl;

import main.java.common.model.*;
import main.java.common.utils.interfaces.SortedCardCategoryMapper;
import main.java.kickers.calculator.exceptions.HandDoesNotContainThreeDistinctCardCategoriesException;
import main.java.kickers.calculator.exceptions.HandDoesNotContainTwoOfAKindException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.TreeMap;

public class TwoPairKickersCalculatorImplTest {
    private final SortedCardCategoryMapper twoDifferentCardCategoriesMapper = new SortedCardCategoryMapper() {
        @Override
        public TreeMap<CardCategory, Integer> returnSortedCardCategoryAscending(final Hand hand) {
            final TreeMap<CardCategory, Integer> results = new TreeMap<>();
            results.put(CardCategory.ACE, 4);
            results.put(CardCategory.TWO, 1);
            return results;
        }
    };
    private final SortedCardCategoryMapper threeOfAKindCardCategoriesMapper = new SortedCardCategoryMapper() {
        @Override
        public TreeMap<CardCategory, Integer> returnSortedCardCategoryAscending(final Hand hand) {
            final TreeMap<CardCategory, Integer> results = new TreeMap<>();
            results.put(CardCategory.ACE, 3);
            results.put(CardCategory.TWO, 1);
            results.put(CardCategory.THREE, 1);
            return results;
        }
    };
    private final SortedCardCategoryMapper fourDifferentCardCategoriesMapper = new SortedCardCategoryMapper() {
        @Override
        public TreeMap<CardCategory, Integer> returnSortedCardCategoryAscending(final Hand hand) {
            final TreeMap<CardCategory, Integer> results = new TreeMap<>();
            results.put(CardCategory.ACE, 2);
            results.put(CardCategory.TWO, 1);
            results.put(CardCategory.THREE, 1);
            results.put(CardCategory.FOUR, 1);
            return results;
        }
    };
    private final SortedCardCategoryMapper fiveDifferentCardCategoriesMapper = new SortedCardCategoryMapper() {
        @Override
        public TreeMap<CardCategory, Integer> returnSortedCardCategoryAscending(final Hand hand) {
            final TreeMap<CardCategory, Integer> results = new TreeMap<>();
            results.put(CardCategory.ACE, 1);
            results.put(CardCategory.TWO, 1);
            results.put(CardCategory.THREE, 1);
            results.put(CardCategory.FOUR, 1);
            results.put(CardCategory.KING, 1);
            return results;
        }
    };
    private final SortedCardCategoryMapper twoPairCardCategoriesMapper = new SortedCardCategoryMapper() {
        @Override
        public TreeMap<CardCategory, Integer> returnSortedCardCategoryAscending(final Hand hand) {
            final TreeMap<CardCategory, Integer> results = new TreeMap<>();
            results.put(CardCategory.ACE, 2);
            results.put(CardCategory.TWO, 2);
            results.put(CardCategory.THREE, 1);
            return results;
        }
    };
    private final TwoPairKickersCalculatorImpl twoDifferentCardCategoriesKickersCalculator = new TwoPairKickersCalculatorImpl(twoDifferentCardCategoriesMapper);
    private final TwoPairKickersCalculatorImpl fourDifferentCardCategoriesKickersCalculator = new TwoPairKickersCalculatorImpl(fourDifferentCardCategoriesMapper);
    private final TwoPairKickersCalculatorImpl fiveDifferentCardCategoriesKickersCalculator = new TwoPairKickersCalculatorImpl(fiveDifferentCardCategoriesMapper);
    private final TwoPairKickersCalculatorImpl threeOfAKindKickersCalculator = new TwoPairKickersCalculatorImpl(threeOfAKindCardCategoriesMapper);
    private final TwoPairKickersCalculatorImpl twoPairKickersCalculator = new TwoPairKickersCalculatorImpl(twoPairCardCategoriesMapper);

    // Tests
    // test 2, 4, 5 different card categories
    // test 3 of a kind
    // test 2 pair and check values

    @Test
    public void testDifferentCardCategories() throws HandDoesNotContainThreeDistinctCardCategoriesException, HandDoesNotContainTwoOfAKindException {
        final HashSet<Card> cards = new HashSet<>();
        cards.add(new Card(CardCategory.THREE, Suit.CLUBS));
        cards.add(new Card(CardCategory.FOUR, Suit.DIAMONDS));
        cards.add(new Card(CardCategory.SIX, Suit.HEARTS));
        cards.add(new Card(CardCategory.JACK, Suit.SPADES));
        cards.add(new Card(CardCategory.NINE, Suit.SPADES));
        final Hand hand = new Hand(cards);

        try {
            twoDifferentCardCategoriesKickersCalculator.calculateKickers(hand);
        } catch (HandDoesNotContainThreeDistinctCardCategoriesException e) {
            // expected
        }

        try {
            fourDifferentCardCategoriesKickersCalculator.calculateKickers(hand);
        } catch (HandDoesNotContainThreeDistinctCardCategoriesException e) {
            // expected
        }

        try {
            fiveDifferentCardCategoriesKickersCalculator.calculateKickers(hand);
        } catch (HandDoesNotContainThreeDistinctCardCategoriesException e) {
            // expected
        }
    }

    @Test
    public void testThreeOfAKindCardCategories() throws HandDoesNotContainThreeDistinctCardCategoriesException, HandDoesNotContainTwoOfAKindException {
        final HashSet<Card> cards = new HashSet<>();
        cards.add(new Card(CardCategory.THREE, Suit.CLUBS));
        cards.add(new Card(CardCategory.FOUR, Suit.DIAMONDS));
        cards.add(new Card(CardCategory.SIX, Suit.HEARTS));
        cards.add(new Card(CardCategory.JACK, Suit.SPADES));
        cards.add(new Card(CardCategory.NINE, Suit.SPADES));
        final Hand hand = new Hand(cards);

        try {
            threeOfAKindKickersCalculator.calculateKickers(hand);
        } catch (HandDoesNotContainTwoOfAKindException e) {
            // expected
        }
    }

    @Test
    public void testExpected() throws HandDoesNotContainThreeDistinctCardCategoriesException, HandDoesNotContainTwoOfAKindException {
        final HashSet<Card> cards = new HashSet<>();
        cards.add(new Card(CardCategory.THREE, Suit.CLUBS));
        cards.add(new Card(CardCategory.FOUR, Suit.DIAMONDS));
        cards.add(new Card(CardCategory.SIX, Suit.HEARTS));
        cards.add(new Card(CardCategory.JACK, Suit.SPADES));
        cards.add(new Card(CardCategory.NINE, Suit.SPADES));
        final Hand hand = new Hand(cards);

        final TwoPairKickers twoPairKickers = twoPairKickersCalculator.calculateKickers(hand);
        Assert.assertNotNull(twoPairKickers);
        Assert.assertEquals(CardCategory.ACE, twoPairKickers.getHighestPairCardCategory());
        Assert.assertEquals(CardCategory.TWO, twoPairKickers.getLowestPairCardCategory());
        Assert.assertEquals(CardCategory.THREE, twoPairKickers.getRemainingCardCategory());
    }

}