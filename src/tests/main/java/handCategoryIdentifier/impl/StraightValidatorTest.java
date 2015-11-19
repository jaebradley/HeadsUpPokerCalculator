package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Card;
import main.java.common.model.CardCategory;
import main.java.common.model.Hand;
import main.java.common.model.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class StraightValidatorTest {
    private final StraightExistenceValidatorImpl straightValidator = new StraightExistenceValidatorImpl();

    @Test
    public void testStraights() {
        final CardCategory[] cardCategories = CardCategory.values();
        Arrays.sort(cardCategories);
        for (final Suit suit : Suit.values()) {
            for (int cardCategoryIndex = 0; cardCategoryIndex <= cardCategories.length - 5; cardCategoryIndex++) {
                final HashSet<Card> cards = new HashSet<>();
                cards.add(
                        new Card(
                                cardCategories[cardCategoryIndex],
                                suit
                        )
                );
                cards.add(
                        new Card(
                                cardCategories[cardCategoryIndex + 1],
                                suit
                        )
                );
                cards.add(
                        new Card(
                                cardCategories[cardCategoryIndex + 2],
                                suit
                        )
                );
                cards.add(
                        new Card(
                                cardCategories[cardCategoryIndex + 3],
                                suit
                        )
                );
                cards.add(
                        new Card(
                                cardCategories[cardCategoryIndex + 4],
                                suit
                        )
                );
                final Hand straightHand = new Hand(
                        cards
                );
                Assert.assertTrue(straightValidator.validateExistence(straightHand));
            }
        }

        //TODO: add ace low straights
    }
}