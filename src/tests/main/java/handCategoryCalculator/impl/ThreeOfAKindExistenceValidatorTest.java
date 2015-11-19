package main.java.handCategoryCalculator.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class ThreeOfAKindExistenceValidatorTest {
    private final ThreeOfAKindExistenceValidator threeOfAKindExistenceValidator = new ThreeOfAKindExistenceValidator();

    @Test
    public void testExpected() {
        // TODO: add more test cases
        final HashSet<Card> highCardHashSet = new HashSet<>();
        highCardHashSet.add(
                new Card(
                        CardCategory.ACE,
                        Suit.CLUBS
                )
        );
        highCardHashSet.add(
                new Card(
                        CardCategory.EIGHT,
                        Suit.DIAMONDS
                )
        );
        highCardHashSet.add(
                new Card(
                        CardCategory.FIVE,
                        Suit.CLUBS
                )
        );
        highCardHashSet.add(
                new Card(
                        CardCategory.FOUR,
                        Suit.SPADES
                )
        );
        highCardHashSet.add(
                new Card(
                        CardCategory.JACK,
                        Suit.HEARTS
                )
        );
        final Hand highCardhand = new Hand(highCardHashSet);
        Assert.assertFalse(threeOfAKindExistenceValidator.validateExistence(highCardhand));
    }

}