package main.java.handCategoryCalculator.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class FourOfAKindValidatorTest {
    private final FourOfAKindValidator fourOfAKindValidator = new FourOfAKindValidator();

    @Test
    public void testFourOfAKinds() {
        // generate all possible four of a kinds
        // for loop through all possible four of a kind values
        // for loop through all possible suit values
        for (final CardCategory fourOfAKindCardCategory : CardCategory.values()) {
            for (final CardCategory fifthCardCategory : CardCategory.values()) {
                if (fifthCardCategory.getValue() != fourOfAKindCardCategory.getValue()) {
                    for (final Suit fifthCardSuit : Suit.values()) {
                        final HashSet<Card> cards = new HashSet<>();
                        cards.add(
                                new Card(
                                        fourOfAKindCardCategory,
                                        Suit.CLUBS
                                )
                        );
                        cards.add(
                                new Card(
                                        fourOfAKindCardCategory,
                                        Suit.DIAMONDS
                                )
                        );
                        cards.add(
                                new Card(
                                        fourOfAKindCardCategory,
                                        Suit.SPADES
                                )
                        );
                        cards.add(
                                new Card(
                                        fourOfAKindCardCategory,
                                        Suit.HEARTS
                                )
                        );
                        cards.add(
                                new Card(
                                        fifthCardCategory,
                                        fifthCardSuit
                                )
                        );
                        final Hand fourOfAKind = new Hand(cards);
                        Assert.assertTrue(fourOfAKindValidator.validateHand(fourOfAKind));
                    }
                }
            }
        }
    }
}