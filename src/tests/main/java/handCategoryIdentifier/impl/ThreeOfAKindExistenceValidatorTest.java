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
    private final ThreeOfAKindExistenceValidatorImpl threeOfAKindExistenceValidator = new ThreeOfAKindExistenceValidatorImpl();
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

    @Test
    public void testExpected() {
        // TODO: add more test cases
        Assert.assertTrue(threeOfAKindExistenceValidator.validateExistence(null, containsThreeCards));
        Assert.assertFalse(threeOfAKindExistenceValidator.validateExistence(null, doesNotContainThreeCards));
    }

}