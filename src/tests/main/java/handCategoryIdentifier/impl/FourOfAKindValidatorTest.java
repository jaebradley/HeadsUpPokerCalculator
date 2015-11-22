package main.java.handCategoryIdentifier.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class FourOfAKindValidatorTest {
    private final FourOfAKindExistenceValidatorImpl fourOfAKindValidator = new FourOfAKindExistenceValidatorImpl();
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

    @Test
    public void testExpected() {
        Assert.assertTrue(fourOfAKindValidator.validateExistence(null, containsFourCardsCategoryCountMapper));
        Assert.assertFalse(fourOfAKindValidator.validateExistence(null, doesNotContainFourCardsCategoryCountMapper));
    }


}