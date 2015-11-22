package main.java.handCategoryIdentifier.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import org.junit.Assert;
import org.junit.Test;

import java.util.TreeSet;

public class StraightValidatorTest {
    private final StraightExistenceValidatorImpl straightValidator = new StraightExistenceValidatorImpl();
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



    // tests
    // test 2, 3, 4 distinct values where difference between largest and smallest is 4
    // test low straight
    // test regular straight

    @Test
    public void testDifferentDistinctValues() {
        Assert.assertFalse(straightValidator.validateExistence(null, twoDistinctSortedCardCategoryReturner));
        Assert.assertFalse(straightValidator.validateExistence(null, threeDistinctSortedCardCategoryReturner));
        Assert.assertFalse(straightValidator.validateExistence(null, fourDistinctSortedCardCategoryReturner));
        Assert.assertFalse(straightValidator.validateExistence(null, fiveDistinctSortedCardCategoryReturner));
    }

    @Test
    public void testStraights() {
        Assert.assertTrue(straightValidator.validateExistence(null, lowStraightSortedCardCategoryReturner));
        Assert.assertTrue(straightValidator.validateExistence(null, highStraightSortedCardCategoryReturner));
        Assert.assertTrue(straightValidator.validateExistence(null, middleStraightSortedCardCategoryReturner));
    }
}