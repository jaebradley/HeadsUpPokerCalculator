package main.java.handCategoryIdentifier.impl;

import main.java.common.model.*;
import main.java.handCategoryIdentifier.interfaces.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class HandCategoryIdentifierImplTest {

    private final FlushExistenceValidator flushNonExistenceValidator = new FlushExistenceValidator() {
        @Override
        public boolean validateExistence(final Hand hand) {
            return false;
        }
    };

    private final FlushExistenceValidator flushExistenceValidator = new FlushExistenceValidator() {
        @Override
        public boolean validateExistence(final Hand hand) {
            return true;
        }
    };

    private final StraightExistenceValidator straightNonExistenceValidator = new StraightExistenceValidator() {
        @Override
        public boolean validateExistence(final Hand hand) {
            return false;
        }
    };

    private final StraightExistenceValidator straightExistenceValidator = new StraightExistenceValidator() {
        @Override
        public boolean validateExistence(final Hand hand) {
            return true;
        }
    };

    private final FourOfAKindExistenceValidator fourOfAKindNonExistenceValidator = new FourOfAKindExistenceValidator() {
        @Override
        public boolean validateExistence(final Hand hand) {
            return false;
        }
    };

    private final FourOfAKindExistenceValidator fourOfAKindExistenceValidator = new FourOfAKindExistenceValidator() {
        @Override
        public boolean validateExistence(final Hand hand) {
            return true;
        }
    };

    private final ThreeOfAKindExistenceValidator threeOfAKindNonExistenceValidator = new ThreeOfAKindExistenceValidator() {
        @Override
        public boolean validateExistence(final Hand hand) {
            return false;
        }
    };

    private final ThreeOfAKindExistenceValidator threeOfAKindExistenceValidator = new ThreeOfAKindExistenceValidator() {
        @Override
        public boolean validateExistence(final Hand hand) {
            return true;
        }
    };

    private final TwoPairExistenceValidator twoPairNonExistenceValidator = new TwoPairExistenceValidator() {
        @Override
        public boolean validateExistence(final Hand hand) {
            return false;
        }
    };

    private final TwoPairExistenceValidator twoPairExistenceValidator = new TwoPairExistenceValidator() {
        @Override
        public boolean validateExistence(final Hand hand) {
            return true;
        }
    };

    private final OnePairExistenceValidator onePairNonExistenceValidator = new OnePairExistenceValidator() {
        @Override
        public boolean validateExistence(final Hand hand) {
            return false;
        }
    };

    private final OnePairExistenceValidator onePairExistenceValidator = new OnePairExistenceValidator() {
        @Override
        public boolean validateExistence(final Hand hand) {
            return true;
        }
    };

    @Test
    public void testStraightFlush() {
        final HashSet<Card> cards = new HashSet<>();
        cards.add(new Card(CardCategory.ACE, Suit.CLUBS));
        cards.add(new Card(CardCategory.TWO, Suit.CLUBS));
        cards.add(new Card(CardCategory.JACK, Suit.CLUBS));
        cards.add(new Card(CardCategory.FOUR, Suit.DIAMONDS));
        cards.add(new Card(CardCategory.SEVEN, Suit.HEARTS));
        final Hand hand = new Hand(cards);
        final HandCategoryIdentifierImpl handCategoryIdentifier1 = new HandCategoryIdentifierImpl(
                flushExistenceValidator,
                straightExistenceValidator,
                fourOfAKindExistenceValidator,
                threeOfAKindExistenceValidator,
                twoPairExistenceValidator,
                onePairExistenceValidator
        );

        Assert.assertEquals(HandCategory.StraightFlush, handCategoryIdentifier1.identifyHandCategory(hand));
    }

}