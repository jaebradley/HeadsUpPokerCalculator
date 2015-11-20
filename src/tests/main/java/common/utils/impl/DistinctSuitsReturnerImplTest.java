package main.java.common.utils.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class DistinctSuitsReturnerImplTest {
    private final DistinctSuitsReturnerImpl distinctSuitsReturner = new DistinctSuitsReturnerImpl();

    // tests
    // test with hands that have 1, 2, 3, and 4 distinct suits

    @Test
    public void testDistinctSuits() {
        // test 1 distinct suit
        final HashSet<Card> oneDistinctSuitCards = new HashSet<>();
        oneDistinctSuitCards.add(new Card(CardCategory.ACE, Suit.CLUBS));
        oneDistinctSuitCards.add(new Card(CardCategory.THREE, Suit.CLUBS));
        oneDistinctSuitCards.add(new Card(CardCategory.FOUR, Suit.CLUBS));
        oneDistinctSuitCards.add(new Card(CardCategory.FIVE, Suit.CLUBS));
        oneDistinctSuitCards.add(new Card(CardCategory.SIX, Suit.CLUBS));
        final Hand oneDistinctSuitHand = new Hand(oneDistinctSuitCards);
        final HashSet<Suit> expectedOneDistinctSuitResult = new HashSet<>();
        expectedOneDistinctSuitResult.add(Suit.CLUBS);
        Assert.assertEquals(expectedOneDistinctSuitResult, distinctSuitsReturner.returnDistinctSuits(oneDistinctSuitHand));

        // test 2 distinct suits
        final HashSet<Card> twoDistinctSuitCards = new HashSet<>();
        twoDistinctSuitCards.add(new Card(CardCategory.ACE, Suit.HEARTS));
        twoDistinctSuitCards.add(new Card(CardCategory.THREE, Suit.CLUBS));
        twoDistinctSuitCards.add(new Card(CardCategory.FOUR, Suit.CLUBS));
        twoDistinctSuitCards.add(new Card(CardCategory.FIVE, Suit.CLUBS));
        twoDistinctSuitCards.add(new Card(CardCategory.SIX, Suit.CLUBS));
        final Hand twoDistinctSuitsHand = new Hand(twoDistinctSuitCards);
        final HashSet<Suit> expectedTwoDistinctSuitResult = new HashSet<>();
        expectedTwoDistinctSuitResult.add(Suit.CLUBS);
        expectedTwoDistinctSuitResult.add(Suit.HEARTS);
        Assert.assertEquals(expectedTwoDistinctSuitResult, distinctSuitsReturner.returnDistinctSuits(twoDistinctSuitsHand));

        // test 3 distinct suits
        final HashSet<Card> threeDistinctSuitCards = new HashSet<>();
        threeDistinctSuitCards.add(new Card(CardCategory.ACE, Suit.HEARTS));
        threeDistinctSuitCards.add(new Card(CardCategory.THREE, Suit.CLUBS));
        threeDistinctSuitCards.add(new Card(CardCategory.FOUR, Suit.DIAMONDS));
        threeDistinctSuitCards.add(new Card(CardCategory.FIVE, Suit.CLUBS));
        threeDistinctSuitCards.add(new Card(CardCategory.SIX, Suit.CLUBS));
        final Hand threeDistinctSuitsHand = new Hand(threeDistinctSuitCards);
        final HashSet<Suit> expectedThreeDistinctSuitResult = new HashSet<>();
        expectedThreeDistinctSuitResult.add(Suit.CLUBS);
        expectedThreeDistinctSuitResult.add(Suit.HEARTS);
        expectedThreeDistinctSuitResult.add(Suit.DIAMONDS);
        Assert.assertEquals(expectedThreeDistinctSuitResult, distinctSuitsReturner.returnDistinctSuits(threeDistinctSuitsHand));

        // test 4 distinct suits
        final HashSet<Card> fourDistinctSuitCards = new HashSet<>();
        fourDistinctSuitCards.add(new Card(CardCategory.ACE, Suit.HEARTS));
        fourDistinctSuitCards.add(new Card(CardCategory.THREE, Suit.CLUBS));
        fourDistinctSuitCards.add(new Card(CardCategory.FOUR, Suit.DIAMONDS));
        fourDistinctSuitCards.add(new Card(CardCategory.FIVE, Suit.SPADES));
        fourDistinctSuitCards.add(new Card(CardCategory.SIX, Suit.CLUBS));
        final Hand fourDistinctSuitsHand = new Hand(fourDistinctSuitCards);
        final HashSet<Suit> expectedFourDistinctSuitResult = new HashSet<>();
        expectedFourDistinctSuitResult.add(Suit.CLUBS);
        expectedFourDistinctSuitResult.add(Suit.HEARTS);
        expectedFourDistinctSuitResult.add(Suit.DIAMONDS);
        expectedFourDistinctSuitResult.add(Suit.SPADES);
        Assert.assertEquals(expectedFourDistinctSuitResult, distinctSuitsReturner.returnDistinctSuits(fourDistinctSuitsHand));
    }

}