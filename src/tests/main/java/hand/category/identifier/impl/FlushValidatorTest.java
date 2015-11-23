package main.java.hand.category.identifier.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class FlushValidatorTest {

    private final FlushExistenceValidatorImpl flushValidator = new FlushExistenceValidatorImpl();

    // Tests
    // Test null hand
    // Test 1, 2, 3, 4 distinct suits


    @Test
    public void testNull() {
        try {
            flushValidator.flushExists(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }
    }

    @Test
    public void expectedCase() {
        final HashSet<Card> oneDistinctSuitCards = new HashSet<>();
        oneDistinctSuitCards.add(new Card(CardCategory.ACE, Suit.SPADES));
        oneDistinctSuitCards.add(new Card(CardCategory.TWO, Suit.SPADES));
        oneDistinctSuitCards.add(new Card(CardCategory.JACK, Suit.SPADES));
        oneDistinctSuitCards.add(new Card(CardCategory.TEN, Suit.SPADES));
        oneDistinctSuitCards.add(new Card(CardCategory.NINE, Suit.SPADES));
        final Hand flushHand = new Hand(oneDistinctSuitCards);
        Assert.assertTrue(flushValidator.flushExists(flushHand));

        final HashSet<Card> twoDistinctSuitsCards = new HashSet<>();
        twoDistinctSuitsCards.add(new Card(CardCategory.ACE, Suit.SPADES));
        twoDistinctSuitsCards.add(new Card(CardCategory.TWO, Suit.SPADES));
        twoDistinctSuitsCards.add(new Card(CardCategory.JACK, Suit.SPADES));
        twoDistinctSuitsCards.add(new Card(CardCategory.TEN, Suit.SPADES));
        twoDistinctSuitsCards.add(new Card(CardCategory.NINE, Suit.DIAMONDS));
        final Hand twoDistinctSuitsHand = new Hand(twoDistinctSuitsCards);
        Assert.assertFalse(flushValidator.flushExists(twoDistinctSuitsHand));

        final HashSet<Card> threeDistinctSuitsCards = new HashSet<>();
        threeDistinctSuitsCards.add(new Card(CardCategory.ACE, Suit.SPADES));
        threeDistinctSuitsCards.add(new Card(CardCategory.TWO, Suit.SPADES));
        threeDistinctSuitsCards.add(new Card(CardCategory.JACK, Suit.SPADES));
        threeDistinctSuitsCards.add(new Card(CardCategory.TEN, Suit.HEARTS));
        threeDistinctSuitsCards.add(new Card(CardCategory.NINE, Suit.DIAMONDS));
        final Hand threeDistinctSuitsHand = new Hand(threeDistinctSuitsCards);
        Assert.assertFalse(flushValidator.flushExists(threeDistinctSuitsHand));

        final HashSet<Card> fourDistinctSuitsCards = new HashSet<>();
        fourDistinctSuitsCards.add(new Card(CardCategory.ACE, Suit.SPADES));
        fourDistinctSuitsCards.add(new Card(CardCategory.TWO, Suit.SPADES));
        fourDistinctSuitsCards.add(new Card(CardCategory.JACK, Suit.CLUBS));
        fourDistinctSuitsCards.add(new Card(CardCategory.TEN, Suit.HEARTS));
        fourDistinctSuitsCards.add(new Card(CardCategory.NINE, Suit.DIAMONDS));
        final Hand fourDistinctSuitsHand = new Hand(fourDistinctSuitsCards);
        Assert.assertFalse(flushValidator.flushExists(fourDistinctSuitsHand));
    }

}