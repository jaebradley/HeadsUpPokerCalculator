package main.java.handCategoryIdentifier.impl;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.HandCategory;
import main.java.common.model.Suit;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import main.java.common.utils.interfaces.CardCategoryPairCounter;
import main.java.common.utils.interfaces.DistinctSuitsReturner;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import main.java.handCategoryIdentifier.interfaces.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class HandCategoryIdentifierImplTest {

    private final SortedCardCategoryReturner sortedCardCategoryReturner = new SortedCardCategoryReturner() {
        @Override
        public TreeSet<CardCategory> returnCardCategoriesInAscendingOrder(final Hand hand) {
            final TreeSet<CardCategory> cardCategories = new TreeSet<>();
            cardCategories.add(CardCategory.JACK);
            cardCategories.add(CardCategory.TEN);
            cardCategories.add(CardCategory.QUEEN);
            cardCategories.add(CardCategory.ACE);
            cardCategories.add(CardCategory.KING);
            return cardCategories;
        }
    };

    private final DistinctSuitsReturner distinctSuitsReturner = new DistinctSuitsReturner() {
        @Override
        public HashSet<Suit> returnDistinctSuits(final Hand hand) {
            final HashSet<Suit> suits = new HashSet<>();
            suits.add(Suit.CLUBS);
            return suits;
        }
    };

    private final CardCategoryCountMapper cardCategoryCountMapper = new CardCategoryCountMapper() {
        @Override
        public HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand) {
            return null;
        }
    };

    private final CardCategoryPairCounter cardCategoryPairCounter = new CardCategoryPairCounter() {
        @Override
        public int countCardCategoryPairs(final Hand hand) {
            return 0;
        }
    };

    private final FlushExistenceValidator flushNonExistenceValidator = new FlushExistenceValidator() {
        @Override
        public boolean flushExists(final Hand hand) {
            return false;
        }
    };

    private final FlushExistenceValidator flushExistenceValidator = new FlushExistenceValidator() {
        @Override
        public boolean flushExists(final Hand hand) {
            return true;
        }
    };

    private final StraightExistenceValidator straightNonExistenceValidator = new StraightExistenceValidator() {
        @Override
        public boolean straightExists(final Hand hand) {
            return false;
        }
    };

    private final StraightExistenceValidator straightExistenceValidator = new StraightExistenceValidator() {
        @Override
        public boolean straightExists(final Hand hand) {
            return true;
        }
    };

    private final FourOfAKindExistenceValidator fourOfAKindNonExistenceValidator = new FourOfAKindExistenceValidator() {
        @Override
        public boolean fourOfAKindExists(final Hand hand) {
            return false;
        }
    };

    private final FourOfAKindExistenceValidator fourOfAKindExistenceValidator = new FourOfAKindExistenceValidator() {
        @Override
        public boolean fourOfAKindExists(final Hand hand) {
            return true;
        }
    };

    private final ThreeOfAKindExistenceValidator threeOfAKindNonExistenceValidator = new ThreeOfAKindExistenceValidator() {
        @Override
        public boolean threeOfAKindExists(final Hand hand) {
            return false;
        }
    };

    private final ThreeOfAKindExistenceValidator threeOfAKindExistenceValidator = new ThreeOfAKindExistenceValidator() {
        @Override
        public boolean threeOfAKindExists(final Hand hand) {
            return true;
        }
    };

    private final TwoPairExistenceValidator twoPairNonExistenceValidator = new TwoPairExistenceValidator() {
        @Override
        public boolean twoPairExists(final Hand hand) {
            return false;
        }
    };

    private final TwoPairExistenceValidator twoPairExistenceValidator = new TwoPairExistenceValidator() {
        @Override
        public boolean twoPairExists(final Hand hand) {
            return true;
        }
    };

    private final OnePairExistenceValidator onePairNonExistenceValidator = new OnePairExistenceValidator() {
        @Override
        public boolean onePairExists(final Hand hand) {
            return false;
        }
    };

    private final OnePairExistenceValidator onePairExistenceValidator = new OnePairExistenceValidator() {
        @Override
        public boolean onePairExists(final Hand hand) {
            return true;
        }
    };

    //TODO: add more test cases

    @Test
    public void testStraightFlush() {
        final HandCategoryIdentifierImpl handCategoryIdentifier1 = new HandCategoryIdentifierImpl(
                flushExistenceValidator,
                straightExistenceValidator,
                fourOfAKindExistenceValidator,
                threeOfAKindExistenceValidator,
                twoPairExistenceValidator,
                onePairExistenceValidator
        );

        Assert.assertEquals(
                HandCategory.StraightFlush,
                handCategoryIdentifier1.identifyHandCategory(
                        null
                )
        );

        Assert.assertEquals(
                HandCategory.StraightFlush,
                handCategoryIdentifier1.identifyHandCategory(
                        null
                )
        );
    }

}