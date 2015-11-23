package main.java.common.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class HandTest {

    @Test
    public void testNull() {
        try {
            new Hand(null);
        } catch (AssertionError e) {
            // expected
        }
    }

    @Test
    public void testDifferentSizedInputCards() {
        final Set<Card> emptyCardsSet = new HashSet<>();
        try {
            new Hand(emptyCardsSet);
        } catch (AssertionError e) {
            // expected
        }

        final Set<Card> oneCardSet = new HashSet<>();
        oneCardSet.add(new Card(CardCategory.ACE, Suit.CLUBS));
        try {
            new Hand(oneCardSet);
        } catch (AssertionError e) {
            // expected
        }

        final Set<Card> twoCardSet = new HashSet<>();
        twoCardSet.add(new Card(CardCategory.ACE, Suit.CLUBS));
        twoCardSet.add(new Card(CardCategory.JACK, Suit.CLUBS));
        try {
            new Hand(twoCardSet);
        } catch (AssertionError e) {
            // expected
        }

        final Set<Card> threeCardSet = new HashSet<>();
        threeCardSet.add(new Card(CardCategory.ACE, Suit.CLUBS));
        threeCardSet.add(new Card(CardCategory.JACK, Suit.CLUBS));
        threeCardSet.add(new Card(CardCategory.QUEEN, Suit.CLUBS));
        try {
            new Hand(threeCardSet);
        } catch (AssertionError e) {
            // expected
        }

        final Set<Card> fourCardSet = new HashSet<>();
        fourCardSet.add(new Card(CardCategory.ACE, Suit.CLUBS));
        fourCardSet.add(new Card(CardCategory.JACK, Suit.CLUBS));
        fourCardSet.add(new Card(CardCategory.QUEEN, Suit.CLUBS));
        fourCardSet.add(new Card(CardCategory.NINE, Suit.DIAMONDS));
        try {
            new Hand(fourCardSet);
        } catch (AssertionError e) {
            // expected
        }

        final Set<Card> sixCardSet = new HashSet<>();
        sixCardSet.add(new Card(CardCategory.ACE, Suit.CLUBS));
        sixCardSet.add(new Card(CardCategory.JACK, Suit.CLUBS));
        sixCardSet.add(new Card(CardCategory.QUEEN, Suit.CLUBS));
        sixCardSet.add(new Card(CardCategory.NINE, Suit.DIAMONDS));
        sixCardSet.add(new Card(CardCategory.EIGHT, Suit.DIAMONDS));
        sixCardSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        try {
            new Hand(sixCardSet);
        } catch (AssertionError e) {
            // expected
        }
    }

    @Test
    public void testExpected() {
        final Set<Card> fiveCardSet = new HashSet<>();
        fiveCardSet.add(new Card(CardCategory.ACE, Suit.CLUBS));
        fiveCardSet.add(new Card(CardCategory.JACK, Suit.CLUBS));
        fiveCardSet.add(new Card(CardCategory.QUEEN, Suit.CLUBS));
        fiveCardSet.add(new Card(CardCategory.NINE, Suit.DIAMONDS));
        fiveCardSet.add(new Card(CardCategory.EIGHT, Suit.DIAMONDS));
        final Hand result = new Hand(fiveCardSet);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getCards(), fiveCardSet);
    }

}