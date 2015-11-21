package main.java.kickersCalculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.TwoPairKickers;
import main.java.common.utils.interfaces.SortedCardCategoryMapper;
import main.java.kickersCalculator.exceptions.HandDoesNotContainThreeDifferentCardCategoriesException;
import main.java.kickersCalculator.exceptions.HandDoesNotContainTwoOfAKindException;
import org.junit.Assert;
import org.junit.Test;

import java.util.TreeMap;

public class TwoPairKickersCalculatorImplTest {
    private final TwoPairKickersCalculatorImpl twoPairKickersCalculator = new TwoPairKickersCalculatorImpl();
    private final SortedCardCategoryMapper twoDifferentCardCategoriesMapper = new SortedCardCategoryMapper() {
        @Override
        public TreeMap<CardCategory, Integer> returnSortedCardCategoryAscending(final Hand hand) {
            final TreeMap<CardCategory, Integer> results = new TreeMap<>();
            results.put(CardCategory.ACE, 4);
            results.put(CardCategory.TWO, 1);
            return results;
        }
    };
    private final SortedCardCategoryMapper threeOfAKindCardCategoriesMapper = new SortedCardCategoryMapper() {
        @Override
        public TreeMap<CardCategory, Integer> returnSortedCardCategoryAscending(final Hand hand) {
            final TreeMap<CardCategory, Integer> results = new TreeMap<>();
            results.put(CardCategory.ACE, 3);
            results.put(CardCategory.TWO, 1);
            results.put(CardCategory.THREE, 1);
            return results;
        }
    };
    private final SortedCardCategoryMapper fourDifferentCardCategoriesMapper = new SortedCardCategoryMapper() {
        @Override
        public TreeMap<CardCategory, Integer> returnSortedCardCategoryAscending(final Hand hand) {
            final TreeMap<CardCategory, Integer> results = new TreeMap<>();
            results.put(CardCategory.ACE, 2);
            results.put(CardCategory.TWO, 1);
            results.put(CardCategory.THREE, 1);
            results.put(CardCategory.FOUR, 1);
            return results;
        }
    };
    private final SortedCardCategoryMapper fiveDifferentCardCategoriesMapper = new SortedCardCategoryMapper() {
        @Override
        public TreeMap<CardCategory, Integer> returnSortedCardCategoryAscending(final Hand hand) {
            final TreeMap<CardCategory, Integer> results = new TreeMap<>();
            results.put(CardCategory.ACE, 1);
            results.put(CardCategory.TWO, 1);
            results.put(CardCategory.THREE, 1);
            results.put(CardCategory.FOUR, 1);
            results.put(CardCategory.KING, 1);
            return results;
        }
    };
    private final SortedCardCategoryMapper twoPairCardCategoriesMapper = new SortedCardCategoryMapper() {
        @Override
        public TreeMap<CardCategory, Integer> returnSortedCardCategoryAscending(final Hand hand) {
            final TreeMap<CardCategory, Integer> results = new TreeMap<>();
            results.put(CardCategory.ACE, 2);
            results.put(CardCategory.TWO, 2);
            results.put(CardCategory.THREE, 1);
            return results;
        }
    };

    // Tests
    // test 2, 4, 5 different card categories
    // test 3 of a kind
    // test 2 pair and check values

    @Test
    public void testDifferentCardCategories() throws HandDoesNotContainThreeDifferentCardCategoriesException, HandDoesNotContainTwoOfAKindException {
        try {
            twoPairKickersCalculator.calculateKickers(null, twoDifferentCardCategoriesMapper);
        } catch (HandDoesNotContainThreeDifferentCardCategoriesException e) {
            // expected
        }

        try {
            twoPairKickersCalculator.calculateKickers(null, fourDifferentCardCategoriesMapper);
        } catch (HandDoesNotContainThreeDifferentCardCategoriesException e) {
            // expected
        }

        try {
            twoPairKickersCalculator.calculateKickers(null, fiveDifferentCardCategoriesMapper);
        } catch (HandDoesNotContainThreeDifferentCardCategoriesException e) {
            // expected
        }
    }

    @Test
    public void testThreeOfAKindCardCategories() throws HandDoesNotContainThreeDifferentCardCategoriesException, HandDoesNotContainTwoOfAKindException {
        try {
            twoPairKickersCalculator.calculateKickers(null, threeOfAKindCardCategoriesMapper);
        } catch (HandDoesNotContainTwoOfAKindException e) {
            // expected
        }
    }

    @Test
    public void testExpected() throws HandDoesNotContainThreeDifferentCardCategoriesException, HandDoesNotContainTwoOfAKindException {
        final TwoPairKickers twoPairKickers = twoPairKickersCalculator.calculateKickers(null, twoPairCardCategoriesMapper);
        Assert.assertNotNull(twoPairKickers);
        Assert.assertEquals(CardCategory.ACE, twoPairKickers.getHighestPairCardCategory());
        Assert.assertEquals(CardCategory.TWO, twoPairKickers.getLowestPairCardCategory());
        Assert.assertEquals(CardCategory.THREE, twoPairKickers.getRemainingCardCategory());
    }

}