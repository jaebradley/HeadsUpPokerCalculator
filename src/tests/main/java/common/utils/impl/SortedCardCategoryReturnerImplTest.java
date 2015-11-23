package main.java.common.utils.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.TreeSet;

public class SortedCardCategoryReturnerImplTest {
    // Tests
    // null hand
    // 2, 3, 4, 5 distinct card categories

    private final SortedCardCategoryReturnerImpl sortedCardCategoryReturner = new SortedCardCategoryReturnerImpl();

    @Test
    public void testNullHand() {
        try {
            sortedCardCategoryReturner.returnCardCategoriesInAscendingOrder(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }
    }

    @Test
    public void testHandWithTwoDistinctCardCategories() {
        final HashSet<Card> twoDistinctCardCategoryCards = new HashSet<>();
        twoDistinctCardCategoryCards.add(new Card(CardCategory.ACE, Suit.CLUBS));
        twoDistinctCardCategoryCards.add(new Card(CardCategory.ACE, Suit.DIAMONDS));
        twoDistinctCardCategoryCards.add(new Card(CardCategory.ACE, Suit.HEARTS));
        twoDistinctCardCategoryCards.add(new Card(CardCategory.ACE, Suit.SPADES));
        twoDistinctCardCategoryCards.add(new Card(CardCategory.NINE, Suit.SPADES));
        final Hand twoDistinctCardCategoryHand = new Hand(twoDistinctCardCategoryCards);
        final TreeSet<CardCategory> sortedCardCategories = sortedCardCategoryReturner.returnCardCategoriesInAscendingOrder(twoDistinctCardCategoryHand);
        Assert.assertNotNull(sortedCardCategories);
        Assert.assertEquals(sortedCardCategories.size(), 2);
        Assert.assertTrue(sortedCardCategories.contains(CardCategory.ACE));
        Assert.assertTrue(sortedCardCategories.contains(CardCategory.NINE));
    }

}