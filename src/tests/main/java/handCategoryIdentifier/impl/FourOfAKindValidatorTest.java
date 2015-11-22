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

public class FourOfAKindValidatorTest {
    private final CardCategoryCountMapper containsFourCardsCategoryCountMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            results.put(CardCategory.FOUR, 4);
            return results;
        }
    };
    private final CardCategoryCountMapper doesNotContainFourCardsCategoryCountMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            final HashMap<CardCategory, Integer> results = new HashMap<>();
            results.put(CardCategory.FOUR, 2);
            return results;
        }
    };

    private final FourOfAKindExistenceValidatorImpl containsFourCardsFourOfAKindValidator = new FourOfAKindExistenceValidatorImpl(containsFourCardsCategoryCountMapper);
    private final FourOfAKindExistenceValidatorImpl doesNotContainFourCardsFourOfAKindValidator = new FourOfAKindExistenceValidatorImpl(doesNotContainFourCardsCategoryCountMapper);
    @Test
    public void testExpected() {
        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        Assert.assertTrue(containsFourCardsFourOfAKindValidator.fourOfAKindExists(fooHand));
        Assert.assertFalse(doesNotContainFourCardsFourOfAKindValidator.fourOfAKindExists(fooHand));
    }


}