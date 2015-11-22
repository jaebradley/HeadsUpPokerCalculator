package main.java.common.utils.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class CardCategoryCountMapperImplTest {
    private final CardCategoryCountMapperImpl cardCategoryCountMapper = new CardCategoryCountMapperImpl();

    // tests
    // null case
    // 2, 3, 4, 5 distinct card categories

    @Test
    public void testNull() {
        try {
            cardCategoryCountMapper.returnCardCategoryCountMap(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }
    }

    @Test
    public void twoDistinctCardCategories() {
        final HashSet<Card> twoDistinctCards = new HashSet<>();
        twoDistinctCards.add(new Card(CardCategory.ACE, Suit.CLUBS));
        twoDistinctCards.add(new Card(CardCategory.ACE, Suit.DIAMONDS));
        twoDistinctCards.add(new Card(CardCategory.ACE, Suit.HEARTS));
        twoDistinctCards.add(new Card(CardCategory.ACE, Suit.SPADES));
        twoDistinctCards.add(new Card(CardCategory.TWO, Suit.SPADES));
        final Hand twoDistinctCardsHand = new Hand(twoDistinctCards);
        final HashMap<CardCategory, Integer> expectedCardCategoryCountMap = new HashMap<>();
        expectedCardCategoryCountMap.put(CardCategory.ACE, new Integer(4));
        expectedCardCategoryCountMap.put(CardCategory.TWO, new Integer(1));
        Assert.assertEquals(expectedCardCategoryCountMap, cardCategoryCountMapper.returnCardCategoryCountMap(twoDistinctCardsHand));
    }

    @Test
    public void threeDistinctCardCategories() {
        final HashSet<Card> threeDistinctCards = new HashSet<>();
        threeDistinctCards.add(new Card(CardCategory.ACE, Suit.CLUBS));
        threeDistinctCards.add(new Card(CardCategory.ACE, Suit.DIAMONDS));
        threeDistinctCards.add(new Card(CardCategory.ACE, Suit.HEARTS));
        threeDistinctCards.add(new Card(CardCategory.THREE, Suit.SPADES));
        threeDistinctCards.add(new Card(CardCategory.TWO, Suit.SPADES));
        final Hand threeDistinctCardsHand = new Hand(threeDistinctCards);
        final HashMap<CardCategory, Integer> expectedCardCategoryCountMap = new HashMap<>();
        expectedCardCategoryCountMap.put(CardCategory.ACE, new Integer(3));
        expectedCardCategoryCountMap.put(CardCategory.TWO, new Integer(1));
        expectedCardCategoryCountMap.put(CardCategory.THREE, new Integer(1));
        Assert.assertEquals(expectedCardCategoryCountMap, cardCategoryCountMapper.returnCardCategoryCountMap(threeDistinctCardsHand));
    }

    @Test
    public void fourDistinctCardCategories() {
        final HashSet<Card> fourDistinctCards = new HashSet<>();
        fourDistinctCards.add(new Card(CardCategory.ACE, Suit.CLUBS));
        fourDistinctCards.add(new Card(CardCategory.ACE, Suit.DIAMONDS));
        fourDistinctCards.add(new Card(CardCategory.FOUR, Suit.HEARTS));
        fourDistinctCards.add(new Card(CardCategory.THREE, Suit.SPADES));
        fourDistinctCards.add(new Card(CardCategory.TWO, Suit.SPADES));
        final Hand fourDistinctCardsHand = new Hand(fourDistinctCards);
        final HashMap<CardCategory, Integer> expectedCardCategoryCountMap = new HashMap<>();
        expectedCardCategoryCountMap.put(CardCategory.ACE, new Integer(2));
        expectedCardCategoryCountMap.put(CardCategory.TWO, new Integer(1));
        expectedCardCategoryCountMap.put(CardCategory.THREE, new Integer(1));
        expectedCardCategoryCountMap.put(CardCategory.FOUR, new Integer(1));
        Assert.assertEquals(expectedCardCategoryCountMap, cardCategoryCountMapper.returnCardCategoryCountMap(fourDistinctCardsHand));
    }

    @Test
    public void fiveDistinctCardCategories() {
        final HashSet<Card> fiveDistinctCards = new HashSet<>();
        fiveDistinctCards.add(new Card(CardCategory.ACE, Suit.CLUBS));
        fiveDistinctCards.add(new Card(CardCategory.FIVE, Suit.DIAMONDS));
        fiveDistinctCards.add(new Card(CardCategory.FOUR, Suit.HEARTS));
        fiveDistinctCards.add(new Card(CardCategory.THREE, Suit.SPADES));
        fiveDistinctCards.add(new Card(CardCategory.TWO, Suit.SPADES));
        final Hand fiveDistinctCardsHand = new Hand(fiveDistinctCards);
        final HashMap<CardCategory, Integer> expectedCardCategoryCountMap = new HashMap<>();
        expectedCardCategoryCountMap.put(CardCategory.ACE, new Integer(1));
        expectedCardCategoryCountMap.put(CardCategory.TWO, new Integer(1));
        expectedCardCategoryCountMap.put(CardCategory.THREE, new Integer(1));
        expectedCardCategoryCountMap.put(CardCategory.FOUR, new Integer(1));
        expectedCardCategoryCountMap.put(CardCategory.FIVE, new Integer(1));
        Assert.assertEquals(expectedCardCategoryCountMap, cardCategoryCountMapper.returnCardCategoryCountMap(fiveDistinctCardsHand));
    }
}