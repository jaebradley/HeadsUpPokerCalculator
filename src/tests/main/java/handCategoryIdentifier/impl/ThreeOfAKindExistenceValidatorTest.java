package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class ThreeOfAKindExistenceValidatorTest {
    private final CardCategoryCountMapper containsThreeCards = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            results.put(CardCategory.THREE, 3);
            return results;
        }
    };
    private final CardCategoryCountMapper doesNotContainThreeCards = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            results.put(CardCategory.THREE, 2);
            return results;
        }
    };
    private final ThreeOfAKindExistenceValidatorImpl containsThreeOfAKindExistenceValidator = new ThreeOfAKindExistenceValidatorImpl(containsThreeCards);
    private final ThreeOfAKindExistenceValidatorImpl doesNotContainThreeOfAKindExistenceValidator = new ThreeOfAKindExistenceValidatorImpl(doesNotContainThreeCards);

    @Test
    public void testNull() {
        try {
            containsThreeOfAKindExistenceValidator.threeOfAKindExists(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            doesNotContainThreeOfAKindExistenceValidator.threeOfAKindExists(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }
    }

    @Test
    public void testExpected() {
        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        Assert.assertTrue(containsThreeOfAKindExistenceValidator.threeOfAKindExists(fooHand));
        Assert.assertFalse(doesNotContainThreeOfAKindExistenceValidator.threeOfAKindExists(fooHand));
    }

}