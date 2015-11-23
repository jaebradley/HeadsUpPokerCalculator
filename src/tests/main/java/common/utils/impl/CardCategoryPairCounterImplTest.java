package main.java.common.utils.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class CardCategoryPairCounterImplTest {

    // Tests
    // Null hand
    // Null mapping, empty mapping, no pair mapping, 1 pair mapping, 2 pair mapping

    private final CardCategoryCountMapper nullMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            return null;
        }
    };

    private final CardCategoryCountMapper emptyMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            return results;
        }
    };

    private final CardCategoryCountMapper noPairMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            results.put(CardCategory.ACE, 1);
            results.put(CardCategory.FOUR, 3);
            results.put(CardCategory.FIVE, 4);
            results.put(CardCategory.SIX, 5);
            return results;
        }
    };

    private final CardCategoryCountMapper onePairMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            results.put(CardCategory.ACE, 1);
            results.put(CardCategory.FOUR, 2);
            results.put(CardCategory.FIVE, 4);
            results.put(CardCategory.SIX, 5);
            return results;
        }
    };

    private final CardCategoryCountMapper twoPairMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            results.put(CardCategory.ACE, 1);
            results.put(CardCategory.FOUR, 2);
            results.put(CardCategory.FIVE, 2);
            results.put(CardCategory.SIX, 5);
            return results;
        }
    };

    private final CardCategoryPairCounterImpl nullCardCategoryPairCounter = new CardCategoryPairCounterImpl(nullMapper);
    private final CardCategoryPairCounterImpl emptyCardCategoryPairCounter = new CardCategoryPairCounterImpl(emptyMapper);
    private final CardCategoryPairCounterImpl noCardCategoryPairCounter = new CardCategoryPairCounterImpl(noPairMapper);
    private final CardCategoryPairCounterImpl oneCardCategoryPairCounter = new CardCategoryPairCounterImpl(onePairMapper);
    private final CardCategoryPairCounterImpl twoCardCategoryPairCounter = new CardCategoryPairCounterImpl(twoPairMapper);

    @Test
    public void testNull() {
        try {
            nullCardCategoryPairCounter.countCardCategoryPairs(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            emptyCardCategoryPairCounter.countCardCategoryPairs(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            noCardCategoryPairCounter.countCardCategoryPairs(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            oneCardCategoryPairCounter.countCardCategoryPairs(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            twoCardCategoryPairCounter.countCardCategoryPairs(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }
    }

    @Test
    public void testCardCategoryCounters() {
        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        try {
            nullCardCategoryPairCounter.countCardCategoryPairs(fooHand);
        } catch (AssertionError e) {
            // expected
        }

        Assert.assertEquals(0, noCardCategoryPairCounter.countCardCategoryPairs(fooHand));
        Assert.assertEquals(1, oneCardCategoryPairCounter.countCardCategoryPairs(fooHand));
        Assert.assertEquals(2, twoCardCategoryPairCounter.countCardCategoryPairs(fooHand));
    }
}