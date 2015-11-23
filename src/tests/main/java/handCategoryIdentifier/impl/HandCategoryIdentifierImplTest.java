package main.java.handCategoryIdentifier.impl;

import main.java.common.model.*;
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

        final HandCategoryIdentifierImpl handCategoryIdentifier2 = new HandCategoryIdentifierImpl(
                flushExistenceValidator,
                straightExistenceValidator,
                fourOfAKindNonExistenceValidator,
                threeOfAKindNonExistenceValidator,
                twoPairNonExistenceValidator,
                onePairNonExistenceValidator
        );

        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        Assert.assertEquals(
                HandCategory.StraightFlush,
                handCategoryIdentifier1.identifyHandCategory(
                        fooHand
                )
        );

        Assert.assertEquals(
                HandCategory.StraightFlush,
                handCategoryIdentifier2.identifyHandCategory(
                        fooHand
                )
        );
    }

    @Test
    public void testFourOfAKind() {
        final HandCategoryIdentifierImpl handCategoryIdentifier1 = new HandCategoryIdentifierImpl(
                flushNonExistenceValidator,
                straightNonExistenceValidator,
                fourOfAKindExistenceValidator,
                threeOfAKindExistenceValidator,
                twoPairExistenceValidator,
                onePairExistenceValidator
        );

        final HandCategoryIdentifierImpl handCategoryIdentifier2 = new HandCategoryIdentifierImpl(
                flushNonExistenceValidator,
                straightNonExistenceValidator,
                fourOfAKindExistenceValidator,
                threeOfAKindNonExistenceValidator,
                twoPairNonExistenceValidator,
                onePairNonExistenceValidator
        );

        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        Assert.assertEquals(
                HandCategory.FourOfAKind,
                handCategoryIdentifier1.identifyHandCategory(fooHand)
        );

        Assert.assertEquals(
                HandCategory.FourOfAKind,
                handCategoryIdentifier2.identifyHandCategory(fooHand)
        );
    }

    @Test
    public void testFullHouse() {
        final HandCategoryIdentifierImpl handCategoryIdentifier1 = new HandCategoryIdentifierImpl(
                flushNonExistenceValidator,
                straightNonExistenceValidator,
                fourOfAKindNonExistenceValidator,
                threeOfAKindExistenceValidator,
                twoPairExistenceValidator,
                onePairExistenceValidator
        );

        final HandCategoryIdentifierImpl handCategoryIdentifier2 = new HandCategoryIdentifierImpl(
                flushNonExistenceValidator,
                straightNonExistenceValidator,
                fourOfAKindNonExistenceValidator,
                threeOfAKindExistenceValidator,
                twoPairNonExistenceValidator,
                onePairExistenceValidator
        );

        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        Assert.assertEquals(
                HandCategory.FullHouse,
                handCategoryIdentifier1.identifyHandCategory(fooHand)
        );

        Assert.assertEquals(
                HandCategory.FullHouse,
                handCategoryIdentifier2.identifyHandCategory(fooHand)
        );
    }

    @Test
    public void testThreeOfAKind() {
        final HandCategoryIdentifierImpl handCategoryIdentifier1 = new HandCategoryIdentifierImpl(
                flushNonExistenceValidator,
                straightNonExistenceValidator,
                fourOfAKindNonExistenceValidator,
                threeOfAKindExistenceValidator,
                twoPairExistenceValidator,
                onePairNonExistenceValidator
        );

        final HandCategoryIdentifierImpl handCategoryIdentifier2 = new HandCategoryIdentifierImpl(
                flushNonExistenceValidator,
                straightNonExistenceValidator,
                fourOfAKindNonExistenceValidator,
                threeOfAKindExistenceValidator,
                twoPairNonExistenceValidator,
                onePairNonExistenceValidator
        );

        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        Assert.assertEquals(
                HandCategory.ThreeOfAKind,
                handCategoryIdentifier1.identifyHandCategory(fooHand)
        );

        Assert.assertEquals(
                HandCategory.ThreeOfAKind,
                handCategoryIdentifier2.identifyHandCategory(fooHand)
        );
    }

    @Test
    public void testTwoPair() {
        final HandCategoryIdentifierImpl handCategoryIdentifier1 = new HandCategoryIdentifierImpl(
                flushNonExistenceValidator,
                straightNonExistenceValidator,
                fourOfAKindNonExistenceValidator,
                threeOfAKindNonExistenceValidator,
                twoPairExistenceValidator,
                onePairExistenceValidator
        );

        final HandCategoryIdentifierImpl handCategoryIdentifier2 = new HandCategoryIdentifierImpl(
                flushNonExistenceValidator,
                straightNonExistenceValidator,
                fourOfAKindNonExistenceValidator,
                threeOfAKindNonExistenceValidator,
                twoPairExistenceValidator,
                onePairNonExistenceValidator
        );

        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        Assert.assertEquals(
                HandCategory.TwoPair,
                handCategoryIdentifier1.identifyHandCategory(fooHand)
        );

        Assert.assertEquals(
                HandCategory.TwoPair,
                handCategoryIdentifier2.identifyHandCategory(fooHand)
        );
    }

    @Test
    public void testOnePair() {
        final HandCategoryIdentifierImpl handCategoryIdentifier1 = new HandCategoryIdentifierImpl(
                flushNonExistenceValidator,
                straightNonExistenceValidator,
                fourOfAKindNonExistenceValidator,
                threeOfAKindNonExistenceValidator,
                twoPairNonExistenceValidator,
                onePairExistenceValidator
        );

        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        Assert.assertEquals(
                HandCategory.OnePair,
                handCategoryIdentifier1.identifyHandCategory(fooHand)
        );
    }

    @Test
    public void testHighCard() {
        final HandCategoryIdentifierImpl handCategoryIdentifier1 = new HandCategoryIdentifierImpl(
                flushNonExistenceValidator,
                straightNonExistenceValidator,
                fourOfAKindNonExistenceValidator,
                threeOfAKindNonExistenceValidator,
                twoPairNonExistenceValidator,
                onePairNonExistenceValidator
        );

        final HashSet<Card> cardHashSet = new HashSet<>();
        cardHashSet.add(new Card(CardCategory.ACE, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TWO, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.JACK, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.SPADES));
        cardHashSet.add(new Card(CardCategory.TEN, Suit.DIAMONDS));
        final Hand fooHand = new Hand(cardHashSet);

        Assert.assertEquals(
                HandCategory.HighCard,
                handCategoryIdentifier1.identifyHandCategory(fooHand)
        );
    }

}