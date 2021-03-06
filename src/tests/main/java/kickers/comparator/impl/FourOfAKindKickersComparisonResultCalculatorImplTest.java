package main.java.kickers.comparator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.KickersComparisonResult;
import main.java.common.model.kickers.FourOfAKindKickers;
import org.junit.Assert;
import org.junit.Test;

public class FourOfAKindKickersComparisonResultCalculatorImplTest {
    private final FourOfAKindKickersComparisonResultCalculatorImpl fourOfAKindKicersComparisonResultCalculator = new FourOfAKindKickersComparisonResultCalculatorImpl();

    // Tests
    // Test each case

    @Test
    public void testNull() {
        final FourOfAKindKickers fourOfAKindKickers1 = new FourOfAKindKickers(CardCategory.ACE, CardCategory.TWO);
        final FourOfAKindKickers fourOfAKindKickers2 = new FourOfAKindKickers(CardCategory.JACK, CardCategory.TEN);
        try {
            fourOfAKindKicersComparisonResultCalculator.calculateKickersComparisonResult(null, fourOfAKindKickers2);
        } catch (AssertionError e) {
            // expected
        }

        try {
            fourOfAKindKicersComparisonResultCalculator.calculateKickersComparisonResult(fourOfAKindKickers1, null);
        } catch (AssertionError e) {
            // expected
        }
    }

    @Test
    public void testFourOfAKindCardCategoryInitialResult() {
        final FourOfAKindKickers fourOfAKindKickers1 = new FourOfAKindKickers(CardCategory.QUEEN, CardCategory.TWO);
        final FourOfAKindKickers fourOfAKindKickers2 = new FourOfAKindKickers(CardCategory.JACK, CardCategory.TEN);
        final FourOfAKindKickers fourOfAKindKickers3 = new FourOfAKindKickers(CardCategory.KING, CardCategory.TEN);
        Assert.assertEquals(fourOfAKindKicersComparisonResultCalculator.calculateKickersComparisonResult(fourOfAKindKickers1, fourOfAKindKickers2), KickersComparisonResult.DEALER_WINS);
        Assert.assertEquals(fourOfAKindKicersComparisonResultCalculator.calculateKickersComparisonResult(fourOfAKindKickers1, fourOfAKindKickers3), KickersComparisonResult.BIG_BLIND_WINS);
    }

    @Test
    public void testFourOfAKindCardCategoryTieResults() {
        final FourOfAKindKickers fourOfAKindKickers1 = new FourOfAKindKickers(CardCategory.JACK, CardCategory.ACE);
        final FourOfAKindKickers fourOfAKindKickers2 = new FourOfAKindKickers(CardCategory.JACK, CardCategory.TEN);
        final FourOfAKindKickers fourOfAKindKickers3 = new FourOfAKindKickers(CardCategory.JACK, CardCategory.ACE);
        Assert.assertEquals(fourOfAKindKicersComparisonResultCalculator.calculateKickersComparisonResult(fourOfAKindKickers1, fourOfAKindKickers2), KickersComparisonResult.DEALER_WINS);
        Assert.assertEquals(fourOfAKindKicersComparisonResultCalculator.calculateKickersComparisonResult(fourOfAKindKickers2, fourOfAKindKickers1), KickersComparisonResult.BIG_BLIND_WINS);
        Assert.assertEquals(fourOfAKindKicersComparisonResultCalculator.calculateKickersComparisonResult(fourOfAKindKickers1, fourOfAKindKickers3), KickersComparisonResult.TIE);
    }

}