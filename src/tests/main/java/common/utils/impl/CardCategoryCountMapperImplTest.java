package main.java.common.utils.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

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
}