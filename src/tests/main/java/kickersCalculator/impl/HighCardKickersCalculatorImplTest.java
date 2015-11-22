package main.java.kickersCalculator.impl;

import main.java.common.model.*;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.TreeSet;

public class HighCardKickersCalculatorImplTest {
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

    private final HighCardKickersCalculatorImpl sortedFlushKickersCalculator = new HighCardKickersCalculatorImpl(
            sortedCardCategoryReturner
    );
    @Test
    public void testExpected() throws Exception {
        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        final HighCardKickers results = sortedFlushKickersCalculator.calculateKickers(fooHand);
        Assert.assertNotNull(results);
        Assert.assertEquals(results.getHighestCardCategory(), CardCategory.ACE);
        Assert.assertEquals(results.getSecondHighestCardCategory(), CardCategory.JACK);
        Assert.assertEquals(results.getThirdHighestCardCategory(), CardCategory.FIVE);
        Assert.assertEquals(results.getFourthHighestCardCategory(), CardCategory.THREE);
        Assert.assertEquals(results.getFifthHighestCardCategory(), CardCategory.TWO);
    }
}