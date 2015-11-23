package main.java.hand.category.identifier.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.TreeSet;

public class StraightValidatorTest {
    private final SortedCardCategoryReturner twoDistinctSortedCardCategoryReturner = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> cardCategories = new TreeSet<>();
            cardCategories.add(CardCategory.NINE);
            cardCategories.add(CardCategory.FIVE);
            return cardCategories;
        }
    };
    private final SortedCardCategoryReturner threeDistinctSortedCardCategoryReturner = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> cardCategories = new TreeSet<>();
            cardCategories.add(CardCategory.NINE);
            cardCategories.add(CardCategory.FIVE);
            cardCategories.add(CardCategory.SIX);
            return cardCategories;
        }
    };
    private final SortedCardCategoryReturner fourDistinctSortedCardCategoryReturner = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> cardCategories = new TreeSet<>();
            cardCategories.add(CardCategory.EIGHT);
            cardCategories.add(CardCategory.FIVE);
            cardCategories.add(CardCategory.SIX);
            cardCategories.add(CardCategory.NINE);
            return cardCategories;
        }
    };
    private final SortedCardCategoryReturner fiveDistinctSortedCardCategoryReturner = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> cardCategories = new TreeSet<>();
            cardCategories.add(CardCategory.EIGHT);
            cardCategories.add(CardCategory.FIVE);
            cardCategories.add(CardCategory.SIX);
            cardCategories.add(CardCategory.NINE);
            cardCategories.add(CardCategory.TWO);
            return cardCategories;
        }
    };
    private final SortedCardCategoryReturner lowStraightSortedCardCategoryReturner = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> cardCategories = new TreeSet<>();
            cardCategories.add(CardCategory.TWO);
            cardCategories.add(CardCategory.FIVE);
            cardCategories.add(CardCategory.FOUR);
            cardCategories.add(CardCategory.ACE);
            cardCategories.add(CardCategory.THREE);
            return cardCategories;
        }
    };
    private final SortedCardCategoryReturner highStraightSortedCardCategoryReturner = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> cardCategories = new TreeSet<>();
            cardCategories.add(CardCategory.KING);
            cardCategories.add(CardCategory.QUEEN);
            cardCategories.add(CardCategory.TEN);
            cardCategories.add(CardCategory.ACE);
            cardCategories.add(CardCategory.JACK);
            return cardCategories;
        }
    };
    private final SortedCardCategoryReturner middleStraightSortedCardCategoryReturner = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> cardCategories = new TreeSet<>();
            cardCategories.add(CardCategory.NINE);
            cardCategories.add(CardCategory.EIGHT);
            cardCategories.add(CardCategory.SIX);
            cardCategories.add(CardCategory.SEVEN);
            cardCategories.add(CardCategory.TEN);
            return cardCategories;
        }
    };
    private final StraightExistenceValidatorImpl twoDistinctValuesStraightValidator = new StraightExistenceValidatorImpl(twoDistinctSortedCardCategoryReturner);
    private final StraightExistenceValidatorImpl threeDistinctValuesStraightValidator = new StraightExistenceValidatorImpl(threeDistinctSortedCardCategoryReturner);
    private final StraightExistenceValidatorImpl fourDistinctValuesStraightValidator = new StraightExistenceValidatorImpl(fourDistinctSortedCardCategoryReturner);
    private final StraightExistenceValidatorImpl fiveDistinctValuesStraightValidator = new StraightExistenceValidatorImpl(fiveDistinctSortedCardCategoryReturner);
    private final StraightExistenceValidatorImpl lowStraightValidator = new StraightExistenceValidatorImpl(lowStraightSortedCardCategoryReturner);
    private final StraightExistenceValidatorImpl middleStraightValidator = new StraightExistenceValidatorImpl(middleStraightSortedCardCategoryReturner);
    private final StraightExistenceValidatorImpl highStraightValidator = new StraightExistenceValidatorImpl(highStraightSortedCardCategoryReturner);



    // tests
    // test 2, 3, 4 distinct values where difference between largest and smallest is 4
    // test low straight
    // test regular straight

    @Test
    public void testDifferentDistinctValues() {
        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        Assert.assertFalse(twoDistinctValuesStraightValidator.straightExists(fooHand));
        Assert.assertFalse(threeDistinctValuesStraightValidator.straightExists(fooHand));
        Assert.assertFalse(fourDistinctValuesStraightValidator.straightExists(fooHand));
        Assert.assertFalse(fiveDistinctValuesStraightValidator.straightExists(fooHand));
    }

    @Test
    public void testStraights() {
        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        Assert.assertTrue(lowStraightValidator.straightExists(fooHand));
        Assert.assertTrue(middleStraightValidator.straightExists(fooHand));
        Assert.assertTrue(highStraightValidator.straightExists(fooHand));
    }
}