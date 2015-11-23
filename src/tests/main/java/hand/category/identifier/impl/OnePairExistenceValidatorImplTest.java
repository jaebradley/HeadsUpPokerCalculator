package main.java.hand.category.identifier.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import main.java.common.utils.interfaces.CardCategoryPairCounter;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class OnePairExistenceValidatorImplTest {
    private final CardCategoryPairCounter onePairCardCategoryPairCounter = new CardCategoryPairCounter() {
        @Override
        public int countCardCategoryPairs(final Hand hand) {
            return 1;
        }
    };

    private final CardCategoryPairCounter twoPairCardCategoryPairCounter = new CardCategoryPairCounter() {
        @Override
        public int countCardCategoryPairs(final Hand hand) {
            return 2;
        }
    };

    private final CardCategoryPairCounter zeroPairCardCategoryPairCounter = new CardCategoryPairCounter() {
        @Override
        public int countCardCategoryPairs(final Hand hand) {
            return 0;
        }
    };

    private final OnePairExistenceValidatorImpl onePairExistenceValidatorReturnsOnePair = new OnePairExistenceValidatorImpl(onePairCardCategoryPairCounter);
    private final OnePairExistenceValidatorImpl onePairExistenceValidatorReturnsTwoPairs = new OnePairExistenceValidatorImpl(twoPairCardCategoryPairCounter);
    private final OnePairExistenceValidatorImpl onePairExistenceValidatorReturnsZeroPairs = new OnePairExistenceValidatorImpl(zeroPairCardCategoryPairCounter);

    @Test
    public void testNulls() {
        try {
            onePairExistenceValidatorReturnsZeroPairs.onePairExists(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            onePairExistenceValidatorReturnsOnePair.onePairExists(null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            onePairExistenceValidatorReturnsTwoPairs.onePairExists(null);
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
        Assert.assertFalse(onePairExistenceValidatorReturnsZeroPairs.onePairExists(fooHand));
        Assert.assertTrue(onePairExistenceValidatorReturnsOnePair.onePairExists(fooHand));
        Assert.assertFalse(onePairExistenceValidatorReturnsTwoPairs.onePairExists(fooHand));
    }

}