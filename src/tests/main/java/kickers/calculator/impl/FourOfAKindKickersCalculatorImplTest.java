package main.java.kickers.calculator.impl;

import main.java.common.model.*;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import main.java.kickers.calculator.exceptions.HandDoesNotContainFourOfAKindException;
import main.java.kickers.calculator.exceptions.HandDoesNotContainOneOfAKindException;
import main.java.kickers.calculator.exceptions.HandDoesNotContainTwoDistinctCardCategoriesException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class FourOfAKindKickersCalculatorImplTest {
    // Tests
    // Test null hand
    // Test null, 0, 1, 3, 4, 5 Distinct Card Categories
    // Test 2 Distinct Card Categories but no 4s
    // Test 2 Distinct Card Categories but no 1s
    // Test expected
    private final CardCategoryCountMapper nullCardCategoryCountMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            return null;
        }
    };

    private final CardCategoryCountMapper emptyCardCategoryCountMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            return results;
        }
    };

    private final CardCategoryCountMapper oneCardCategoryCountMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            results.put(CardCategory.THREE, 5);
            return results;
        }
    };

    private final CardCategoryCountMapper threeCardCategoryCountMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            results.put(CardCategory.THREE, 5);
            results.put(CardCategory.FOUR, 3);
            results.put(CardCategory.FIVE, 2);
            return results;
        }
    };

    private final CardCategoryCountMapper fourCardCategoryCountMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            results.put(CardCategory.THREE, 5);
            results.put(CardCategory.FOUR, 3);
            results.put(CardCategory.FIVE, 2);
            results.put(CardCategory.JACK, 2);
            return results;
        }
    };

    private final CardCategoryCountMapper fiveCardCategoryCountMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            results.put(CardCategory.THREE, 5);
            results.put(CardCategory.FOUR, 3);
            results.put(CardCategory.FIVE, 2);
            results.put(CardCategory.JACK, 2);
            results.put(CardCategory.TWO, 2);
            return results;
        }
    };

    private final CardCategoryCountMapper noFourOfAKindCardCategoryCountMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            results.put(CardCategory.THREE, 5);
            results.put(CardCategory.FOUR, 1);
            return results;
        }
    };

    private final CardCategoryCountMapper noOneOfAKindCardCategoryCountMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            results.put(CardCategory.THREE, 4);
            results.put(CardCategory.FOUR, 2);
            return results;
        }
    };

    private final CardCategoryCountMapper fourOfAKindCardCategoryCountMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            results.put(CardCategory.THREE, 4);
            results.put(CardCategory.FOUR, 1);
            return results;
        }
    };

    private final FourOfAKindKickersCalculatorImpl nullKickersCalculator = new FourOfAKindKickersCalculatorImpl(nullCardCategoryCountMapper);
    private final FourOfAKindKickersCalculatorImpl emptyKickersCalculator = new FourOfAKindKickersCalculatorImpl(emptyCardCategoryCountMapper);
    private final FourOfAKindKickersCalculatorImpl oneCardKickersCalculator = new FourOfAKindKickersCalculatorImpl(oneCardCategoryCountMapper);
    private final FourOfAKindKickersCalculatorImpl threeCardKickersCalculator = new FourOfAKindKickersCalculatorImpl(threeCardCategoryCountMapper);
    private final FourOfAKindKickersCalculatorImpl fourCardKickersCalculator = new FourOfAKindKickersCalculatorImpl(fourCardCategoryCountMapper);
    private final FourOfAKindKickersCalculatorImpl fiveCardKickersCalculator = new FourOfAKindKickersCalculatorImpl(fiveCardCategoryCountMapper);
    private final FourOfAKindKickersCalculatorImpl noFourOfAKindKickersCalculator = new FourOfAKindKickersCalculatorImpl(noFourOfAKindCardCategoryCountMapper);
    private final FourOfAKindKickersCalculatorImpl noOneOfAKindKickersCalculator = new FourOfAKindKickersCalculatorImpl(noOneOfAKindCardCategoryCountMapper);
    private final FourOfAKindKickersCalculatorImpl fourOfAKindKickersCalculator = new FourOfAKindKickersCalculatorImpl(fourOfAKindCardCategoryCountMapper);

    @Test
    public void testNull() throws HandDoesNotContainTwoDistinctCardCategoriesException, HandDoesNotContainFourOfAKindException, HandDoesNotContainOneOfAKindException {
        try {
            nullKickersCalculator.calculateKickers(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            emptyKickersCalculator.calculateKickers(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            oneCardKickersCalculator.calculateKickers(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            threeCardKickersCalculator.calculateKickers(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            fourCardKickersCalculator.calculateKickers(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            fiveCardKickersCalculator.calculateKickers(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            noFourOfAKindKickersCalculator.calculateKickers(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            noOneOfAKindKickersCalculator.calculateKickers(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            fourOfAKindKickersCalculator.calculateKickers(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }
    }

    @Test
    public void testDifferentCardCategories() {
        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        try {
            nullKickersCalculator.calculateKickers(fooHand);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        } catch (HandDoesNotContainOneOfAKindException | HandDoesNotContainTwoDistinctCardCategoriesException | HandDoesNotContainFourOfAKindException e) {
            Assert.fail();
        }

        try {
            emptyKickersCalculator.calculateKickers(fooHand);
            Assert.fail();
        } catch (HandDoesNotContainTwoDistinctCardCategoriesException e) {
            // expected
        } catch (HandDoesNotContainOneOfAKindException | HandDoesNotContainFourOfAKindException e) {
            Assert.fail();
        }

        try {
            oneCardKickersCalculator.calculateKickers(fooHand);
            Assert.fail();
        } catch (HandDoesNotContainTwoDistinctCardCategoriesException e) {
            // expected
        } catch (HandDoesNotContainOneOfAKindException | HandDoesNotContainFourOfAKindException e) {
            Assert.fail();
        }

        try {
            threeCardKickersCalculator.calculateKickers(fooHand);
            Assert.fail();
        } catch (HandDoesNotContainTwoDistinctCardCategoriesException e) {
            // expected
        } catch (HandDoesNotContainOneOfAKindException | HandDoesNotContainFourOfAKindException e) {
            Assert.fail();
        }

        try {
            fourCardKickersCalculator.calculateKickers(fooHand);
            Assert.fail();
        } catch (HandDoesNotContainTwoDistinctCardCategoriesException e) {
            // expected
        } catch (HandDoesNotContainOneOfAKindException | HandDoesNotContainFourOfAKindException e) {
            Assert.fail();
        }

        try {
            fiveCardKickersCalculator.calculateKickers(fooHand);
            Assert.fail();
        } catch (HandDoesNotContainTwoDistinctCardCategoriesException e) {
            // expected
        } catch (HandDoesNotContainOneOfAKindException | HandDoesNotContainFourOfAKindException e) {
            Assert.fail();
        }
    }

    @Test
    public void testHandDoesNotContainOneOfAKind() {
        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        try {
            noOneOfAKindKickersCalculator.calculateKickers(fooHand);
            Assert.fail();
        } catch (HandDoesNotContainOneOfAKindException e) {
            // expected
        } catch (HandDoesNotContainTwoDistinctCardCategoriesException | HandDoesNotContainFourOfAKindException e) {
            Assert.fail();
        }
    }

    @Test
    public void testHandDoesNotContainFourOfAKind() {
        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        try {
            noFourOfAKindKickersCalculator.calculateKickers(fooHand);
            Assert.fail();
        } catch (HandDoesNotContainFourOfAKindException e) {
            // expected
        } catch (HandDoesNotContainTwoDistinctCardCategoriesException | HandDoesNotContainOneOfAKindException e) {
            Assert.fail();
        }
    }

    @Test
    public void testFourOfAKind() {
        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        try {
            final FourOfAKindKickers fourOfAKindKickers = fourOfAKindKickersCalculator.calculateKickers(fooHand);
            Assert.assertNotNull(fourOfAKindKickers);
            Assert.assertEquals(fourOfAKindKickers.getFourOfAKindCardCategory(), CardCategory.THREE);
            Assert.assertEquals(fourOfAKindKickers.getRemainingCardCategory(), CardCategory.FOUR);
        } catch (HandDoesNotContainTwoDistinctCardCategoriesException | HandDoesNotContainFourOfAKindException |  HandDoesNotContainOneOfAKindException e) {
            Assert.fail();
        }
    }

}