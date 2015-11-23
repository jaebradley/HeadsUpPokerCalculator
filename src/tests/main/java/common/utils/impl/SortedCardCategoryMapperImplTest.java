package main.java.common.utils.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.TreeMap;

public class SortedCardCategoryMapperImplTest {
    // Tests
    // Test null hand
    // Test hand with 2, 3, 4, 5 distinct card categories

    private final SortedCardCategoryMapperImpl sortedCardCategoryMapper = new SortedCardCategoryMapperImpl();

    @Test
    public void testNull() {
        try {
            sortedCardCategoryMapper.returnSortedCardCategoryAscending(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }
    }

    @Test
    public void testHandsWithTwoDifferentCardCategories() {

        final HashSet<Card> twoDistinctCardCategoriesCards = new HashSet<>();
        twoDistinctCardCategoriesCards.add(new Card(CardCategory.ACE, Suit.CLUBS));
        twoDistinctCardCategoriesCards.add(new Card(CardCategory.ACE, Suit.SPADES));
        twoDistinctCardCategoriesCards.add(new Card(CardCategory.ACE, Suit.DIAMONDS));
        twoDistinctCardCategoriesCards.add(new Card(CardCategory.ACE, Suit.HEARTS));
        twoDistinctCardCategoriesCards.add(new Card(CardCategory.TWO, Suit.DIAMONDS));
        final Hand twoDistinctCardCategoriesHand = new Hand(twoDistinctCardCategoriesCards);
        final TreeMap<CardCategory, Integer> twoDistinctCardCategoriesMap = sortedCardCategoryMapper.returnSortedCardCategoryAscending(twoDistinctCardCategoriesHand);
        Assert.assertNotNull(twoDistinctCardCategoriesMap);
        Assert.assertEquals(twoDistinctCardCategoriesMap.size(), 2);
        Assert.assertTrue(twoDistinctCardCategoriesMap.containsKey(CardCategory.ACE));
        Assert.assertTrue(twoDistinctCardCategoriesMap.containsKey(CardCategory.TWO));
        Assert.assertEquals(twoDistinctCardCategoriesMap.get(CardCategory.ACE), new Integer(4));
        Assert.assertEquals(twoDistinctCardCategoriesMap.get(CardCategory.TWO), new Integer(1));
        Assert.assertEquals(twoDistinctCardCategoriesMap.firstKey(), CardCategory.TWO);
        Assert.assertEquals(twoDistinctCardCategoriesMap.lastKey(), CardCategory.ACE);
    }

    @Test
    public void testHandsWithThreeDifferentCardCategories() {

        final HashSet<Card> threeDistinctCardCategoriesCards = new HashSet<>();
        threeDistinctCardCategoriesCards.add(new Card(CardCategory.TEN, Suit.CLUBS));
        threeDistinctCardCategoriesCards.add(new Card(CardCategory.ACE, Suit.SPADES));
        threeDistinctCardCategoriesCards.add(new Card(CardCategory.ACE, Suit.DIAMONDS));
        threeDistinctCardCategoriesCards.add(new Card(CardCategory.ACE, Suit.HEARTS));
        threeDistinctCardCategoriesCards.add(new Card(CardCategory.TWO, Suit.DIAMONDS));
        final Hand threeDistinctCardCategoriesHand = new Hand(threeDistinctCardCategoriesCards);
        final TreeMap<CardCategory, Integer> threeDistinctCardCategoriesMap = sortedCardCategoryMapper.returnSortedCardCategoryAscending(threeDistinctCardCategoriesHand);
        Assert.assertNotNull(threeDistinctCardCategoriesMap);
        Assert.assertEquals(threeDistinctCardCategoriesMap.size(), 3);
        Assert.assertTrue(threeDistinctCardCategoriesMap.containsKey(CardCategory.ACE));
        Assert.assertTrue(threeDistinctCardCategoriesMap.containsKey(CardCategory.TWO));
        Assert.assertTrue(threeDistinctCardCategoriesMap.containsKey(CardCategory.TEN));
        Assert.assertEquals(threeDistinctCardCategoriesMap.get(CardCategory.ACE), new Integer(3));
        Assert.assertEquals(threeDistinctCardCategoriesMap.get(CardCategory.TWO), new Integer(1));
        Assert.assertEquals(threeDistinctCardCategoriesMap.get(CardCategory.TEN), new Integer(1));

        int counter = 0;
        for (final CardCategory key : threeDistinctCardCategoriesMap.keySet()) {
            switch (counter) {
                case 0: {
                    Assert.assertEquals(key, CardCategory.TWO);
                    break;
                }

                case 1: {
                    Assert.assertEquals(key, CardCategory.TEN);
                    break;
                }

                case 2: {
                    Assert.assertEquals(key, CardCategory.ACE);
                    break;
                }

                default: {
                    Assert.fail();
                }
            }

            counter++;
        }
    }

    @Test
    public void testCardsWithFourDifferentCardCategories() {

        final HashSet<Card> fourDistinctCardCategoriesCards = new HashSet<>();
        fourDistinctCardCategoriesCards.add(new Card(CardCategory.TEN, Suit.CLUBS));
        fourDistinctCardCategoriesCards.add(new Card(CardCategory.ACE, Suit.SPADES));
        fourDistinctCardCategoriesCards.add(new Card(CardCategory.THREE, Suit.DIAMONDS));
        fourDistinctCardCategoriesCards.add(new Card(CardCategory.ACE, Suit.HEARTS));
        fourDistinctCardCategoriesCards.add(new Card(CardCategory.TWO, Suit.DIAMONDS));
        final Hand fourDistinctCardCategoriesHand = new Hand(fourDistinctCardCategoriesCards);
        final TreeMap<CardCategory, Integer> fourDistinctCardCategoriesMap = sortedCardCategoryMapper.returnSortedCardCategoryAscending(fourDistinctCardCategoriesHand);
        Assert.assertNotNull(fourDistinctCardCategoriesMap);
        Assert.assertEquals(fourDistinctCardCategoriesMap.size(), 4);
        Assert.assertTrue(fourDistinctCardCategoriesMap.containsKey(CardCategory.ACE));
        Assert.assertTrue(fourDistinctCardCategoriesMap.containsKey(CardCategory.TWO));
        Assert.assertTrue(fourDistinctCardCategoriesMap.containsKey(CardCategory.TEN));
        Assert.assertTrue(fourDistinctCardCategoriesMap.containsKey(CardCategory.THREE));
        Assert.assertEquals(fourDistinctCardCategoriesMap.get(CardCategory.ACE), new Integer(2));
        Assert.assertEquals(fourDistinctCardCategoriesMap.get(CardCategory.TWO), new Integer(1));
        Assert.assertEquals(fourDistinctCardCategoriesMap.get(CardCategory.TEN), new Integer(1));
        Assert.assertEquals(fourDistinctCardCategoriesMap.get(CardCategory.THREE), new Integer(1));

        int counter = 0;
        for (final CardCategory key : fourDistinctCardCategoriesMap.keySet()) {
            switch (counter) {
                case 0: {
                    Assert.assertEquals(key, CardCategory.TWO);
                    break;
                }

                case 1: {
                    Assert.assertEquals(key, CardCategory.THREE);
                    break;
                }

                case 2: {
                    Assert.assertEquals(key, CardCategory.TEN);
                    break;
                }

                case 3: {
                    Assert.assertEquals(key, CardCategory.ACE);
                    break;
                }

                default: {
                    Assert.fail();
                }
            }

            counter++;
        }
    }

    @Test
    public void testCardsWithFiveDifferentCardCategories() {

        final HashSet<Card> fiveDistinctCardCategoriesCards = new HashSet<>();
        fiveDistinctCardCategoriesCards.add(new Card(CardCategory.TEN, Suit.CLUBS));
        fiveDistinctCardCategoriesCards.add(new Card(CardCategory.ACE, Suit.SPADES));
        fiveDistinctCardCategoriesCards.add(new Card(CardCategory.THREE, Suit.DIAMONDS));
        fiveDistinctCardCategoriesCards.add(new Card(CardCategory.JACK, Suit.HEARTS));
        fiveDistinctCardCategoriesCards.add(new Card(CardCategory.TWO, Suit.DIAMONDS));
        final Hand fiveDistinctCardCategoriesHand = new Hand(fiveDistinctCardCategoriesCards);
        final TreeMap<CardCategory, Integer> fiveDistinctCardCategoriesMap = sortedCardCategoryMapper.returnSortedCardCategoryAscending(fiveDistinctCardCategoriesHand);
        Assert.assertNotNull(fiveDistinctCardCategoriesMap);
        Assert.assertEquals(fiveDistinctCardCategoriesMap.size(), 5);
        Assert.assertTrue(fiveDistinctCardCategoriesMap.containsKey(CardCategory.ACE));
        Assert.assertTrue(fiveDistinctCardCategoriesMap.containsKey(CardCategory.TWO));
        Assert.assertTrue(fiveDistinctCardCategoriesMap.containsKey(CardCategory.TEN));
        Assert.assertTrue(fiveDistinctCardCategoriesMap.containsKey(CardCategory.THREE));
        Assert.assertTrue(fiveDistinctCardCategoriesMap.containsKey(CardCategory.JACK));
        Assert.assertEquals(fiveDistinctCardCategoriesMap.get(CardCategory.ACE), new Integer(1));
        Assert.assertEquals(fiveDistinctCardCategoriesMap.get(CardCategory.TWO), new Integer(1));
        Assert.assertEquals(fiveDistinctCardCategoriesMap.get(CardCategory.TEN), new Integer(1));
        Assert.assertEquals(fiveDistinctCardCategoriesMap.get(CardCategory.THREE), new Integer(1));
        Assert.assertEquals(fiveDistinctCardCategoriesMap.get(CardCategory.JACK), new Integer(1));
        int counter = 0;
        for (final CardCategory key : fiveDistinctCardCategoriesMap.keySet()) {
            switch (counter) {
                case 0: {
                    Assert.assertEquals(key, CardCategory.TWO);
                    break;
                }

                case 1: {
                    Assert.assertEquals(key, CardCategory.THREE);
                    break;
                }

                case 2: {
                    Assert.assertEquals(key, CardCategory.TEN);
                    break;
                }

                case 3: {
                    Assert.assertEquals(key, CardCategory.JACK);
                    break;
                }

                case 4: {
                    Assert.assertEquals(key, CardCategory.ACE);
                    break;
                }

                default: {
                    Assert.fail();
                }
            }

            counter++;
        }

    }

}