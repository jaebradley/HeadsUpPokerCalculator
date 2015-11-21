package main.java.kickersCalculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.OnePairKickers;
import main.java.common.utils.interfaces.SortedCardCategoryMapper;
import main.java.kickersCalculator.exceptions.HandDoesNotContainFourDistinctCardCategoriesException;
import main.java.kickersCalculator.exceptions.HandDoesNotContainTwoOfAKindException;
import org.junit.Assert;
import org.junit.Test;

import java.util.TreeMap;

public class OnePairKickersCalculatorImplTest {
    private final OnePairKickersCalculatorImpl onePairKickersCalculator = new OnePairKickersCalculatorImpl();
    private final SortedCardCategoryMapper twoDistinctCardCategoriesMapper = new SortedCardCategoryMapper() {
        @Override
        public TreeMap<CardCategory, Integer> returnSortedCardCategoryAscending(final Hand hand) {
            final TreeMap<CardCategory, Integer> results = new TreeMap<>();
            results.put(CardCategory.ACE, 4);
            results.put(CardCategory.TWO, 1);
            return results;
        }
    };

    private final SortedCardCategoryMapper threeDistinctCardCategoriesMapper = new SortedCardCategoryMapper() {
        @Override
        public TreeMap<CardCategory, Integer> returnSortedCardCategoryAscending(final Hand hand) {
            final TreeMap<CardCategory, Integer> results = new TreeMap<>();
            results.put(CardCategory.ACE, 3);
            results.put(CardCategory.TWO, 1);
            results.put(CardCategory.THREE, 1);
            return results;
        }
    };

    private final SortedCardCategoryMapper fiveDistinctCardCategoriesMapper = new SortedCardCategoryMapper() {
        @Override
        public TreeMap<CardCategory, Integer> returnSortedCardCategoryAscending(final Hand hand) {
            final TreeMap<CardCategory, Integer> results = new TreeMap<>();
            results.put(CardCategory.ACE, 1);
            results.put(CardCategory.TWO, 1);
            results.put(CardCategory.THREE, 1);
            results.put(CardCategory.FOUR, 1);
            results.put(CardCategory.FIVE, 1);
            return results;
        }
    };

    private final SortedCardCategoryMapper onePairCardCategoriesMapper = new SortedCardCategoryMapper() {
        @Override
        public TreeMap<CardCategory, Integer> returnSortedCardCategoryAscending(final Hand hand) {
            final TreeMap<CardCategory, Integer> results = new TreeMap<>();
            results.put(CardCategory.FIVE, 2);
            results.put(CardCategory.ACE, 1);
            results.put(CardCategory.TWO, 1);
            results.put(CardCategory.THREE, 1);
            return results;
        }
    };

    // Tests
    // Test 2, 3, 5 Distinct Card
    // Test Expected and get Values

    @Test
    public void testDistinctCardException() throws HandDoesNotContainFourDistinctCardCategoriesException, HandDoesNotContainTwoOfAKindException {
        try {
            onePairKickersCalculator.calculateKickers(null, twoDistinctCardCategoriesMapper);
        } catch (HandDoesNotContainFourDistinctCardCategoriesException e) {
            // expected
        }

        try {
            onePairKickersCalculator.calculateKickers(null, threeDistinctCardCategoriesMapper);
        } catch (HandDoesNotContainFourDistinctCardCategoriesException e) {
            // expected
        }

        try {
            onePairKickersCalculator.calculateKickers(null, fiveDistinctCardCategoriesMapper);
        } catch (HandDoesNotContainFourDistinctCardCategoriesException e) {
            // expected
        }
    }

    @Test
    public void testExpected() throws HandDoesNotContainFourDistinctCardCategoriesException, HandDoesNotContainTwoOfAKindException {
        final OnePairKickers onePairKickers = onePairKickersCalculator.calculateKickers(null, onePairCardCategoriesMapper);
        Assert.assertNotNull(onePairKickers);
        Assert.assertEquals(onePairKickers.getPairCardCategory(), CardCategory.FIVE);
        Assert.assertEquals(onePairKickers.getHighestRemainingCardCategory(), CardCategory.ACE);
        Assert.assertEquals(onePairKickers.getSecondHighestRemainingCardCategory(), CardCategory.THREE);
        Assert.assertEquals(onePairKickers.getLowestRemainingCardCategory(), CardCategory.TWO);
    }

}