package main.java.kickers.comparator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.ThreeOfAKindKickers;
import org.junit.Assert;
import org.junit.Test;

public class ThreeOfAKindKickersComparisonResultCalculatorImplTest {
    private final ThreeOfAKindKickersComparisonResultCalculatorImpl threeOfAKindKickersComparisonResultCalculator = new ThreeOfAKindKickersComparisonResultCalculatorImpl();

    // Tests
    // Test nulls
    // Test each possible outcome when comparing two kickers

    @Test
    public void testNulls() {
        final ThreeOfAKindKickers threeOfAKindKickers = new ThreeOfAKindKickers(CardCategory.ACE, CardCategory.JACK, CardCategory.NINE);
        try {
            threeOfAKindKickersComparisonResultCalculator.calculateKickersComparisonResult(null, threeOfAKindKickers);
        } catch (AssertionError e) {
            // expected
        }

        try {
            threeOfAKindKickersComparisonResultCalculator.calculateKickersComparisonResult(threeOfAKindKickers, null);
        } catch (AssertionError e) {
            // expected
        }
    }

    @Test
    public void testHighestThreeOfAKindCardCategoryKickerComparison() {
        final ThreeOfAKindKickers threeOfAKindKickers1 = new ThreeOfAKindKickers(CardCategory.ACE, CardCategory.JACK, CardCategory.NINE);
        final ThreeOfAKindKickers threeOfAKindKickers2 = new ThreeOfAKindKickers(CardCategory.JACK, CardCategory.JACK, CardCategory.NINE);
        Assert.assertEquals(threeOfAKindKickersComparisonResultCalculator.calculateKickersComparisonResult(threeOfAKindKickers1, threeOfAKindKickers2), KickersComparisonResult.FIRST);
        Assert.assertEquals(threeOfAKindKickersComparisonResultCalculator.calculateKickersComparisonResult(threeOfAKindKickers2, threeOfAKindKickers1), KickersComparisonResult.SECOND);
    }

    @Test
    public void testHighestRemainingCardCategoryComparison() {
        final ThreeOfAKindKickers threeOfAKindKickers1 = new ThreeOfAKindKickers(CardCategory.ACE, CardCategory.JACK, CardCategory.NINE);
        final ThreeOfAKindKickers threeOfAKindKickers2 = new ThreeOfAKindKickers(CardCategory.ACE, CardCategory.TEN, CardCategory.NINE);
        Assert.assertEquals(threeOfAKindKickersComparisonResultCalculator.calculateKickersComparisonResult(threeOfAKindKickers1, threeOfAKindKickers2), KickersComparisonResult.FIRST);
        Assert.assertEquals(threeOfAKindKickersComparisonResultCalculator.calculateKickersComparisonResult(threeOfAKindKickers2, threeOfAKindKickers1), KickersComparisonResult.SECOND);
    }

    @Test
    public void testLowestRemainingCardCategoryComparison() {
        final ThreeOfAKindKickers threeOfAKindKickers1 = new ThreeOfAKindKickers(CardCategory.ACE, CardCategory.JACK, CardCategory.TEN);
        final ThreeOfAKindKickers threeOfAKindKickers2 = new ThreeOfAKindKickers(CardCategory.ACE, CardCategory.JACK, CardCategory.NINE);
        Assert.assertEquals(threeOfAKindKickersComparisonResultCalculator.calculateKickersComparisonResult(threeOfAKindKickers1, threeOfAKindKickers2), KickersComparisonResult.FIRST);
        Assert.assertEquals(threeOfAKindKickersComparisonResultCalculator.calculateKickersComparisonResult(threeOfAKindKickers2, threeOfAKindKickers1), KickersComparisonResult.SECOND);
        Assert.assertEquals(threeOfAKindKickersComparisonResultCalculator.calculateKickersComparisonResult(threeOfAKindKickers2, threeOfAKindKickers2), KickersComparisonResult.TIE);
    }

}