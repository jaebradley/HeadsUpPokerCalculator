package main.java.kickersCalculator.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.FlushKickers;
import main.java.common.model.Hand;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import org.junit.Assert;
import org.junit.Test;

import java.util.TreeSet;

public class FlushKickersCalculatorImplTest {
    private final FlushKickersCalculatorImpl flushKickersCalculator = new FlushKickersCalculatorImpl();
    private final SortedCardCategoryReturner sortedCardCategoryReturner = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> results = new TreeSet<>();
            results.add(CardCategory.TWO);
            results.add(CardCategory.THREE);
            results.add(CardCategory.FIVE);
            results.add(CardCategory.ACE);
            results.add(CardCategory.JACK);
            return results;
        }
    };
    private final SortedCardCategoryReturner wrongNumberOfCardCategoriesReturner = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> results = new TreeSet<>();
            results.add(CardCategory.TWO);
            results.add(CardCategory.THREE);
            results.add(CardCategory.FIVE);
            results.add(CardCategory.ACE);
            return results;
        }
    };

    @Test
    public void testExpected() throws Exception {
        final FlushKickers results = flushKickersCalculator.calculateKickers(null, sortedCardCategoryReturner);
        Assert.assertNotNull(results);
        Assert.assertEquals(results.getHighestCardCategory(), CardCategory.ACE);
        Assert.assertEquals(results.getSecondHighestCardCategory(), CardCategory.JACK);
        Assert.assertEquals(results.getThirdHighestCardCategory(), CardCategory.FIVE);
        Assert.assertEquals(results.getFourthHighestCardCategory(), CardCategory.THREE);
        Assert.assertEquals(results.getFifthHighestCardCategory(), CardCategory.TWO);
    }
}