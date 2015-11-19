package main.java.handCategoryCalculator.impl;

import main.java.common.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FlushValidatorTest {

    private final FlushValidator flushValidator = new FlushValidator();

    @Test
    public void expectedCase() {
        for (final Suit suit : Suit.values()) {
            for (int cardCategory1Index = 0; cardCategory1Index < CardCategory.values().length - 4; cardCategory1Index++) {
                for (int cardCategory2Index = cardCategory1Index + 1; cardCategory2Index < CardCategory.values().length - 3; cardCategory2Index++) {
                    for (int cardCategory3Index = cardCategory2Index + 1; cardCategory3Index < CardCategory.values().length - 2; cardCategory3Index++) {
                        for (int cardCategory4Index = cardCategory3Index + 1; cardCategory4Index < CardCategory.values().length - 1; cardCategory4Index++) {
                            for (int cardCategory5Index = cardCategory4Index + 1; cardCategory5Index < CardCategory.values().length - 1; cardCategory5Index++) {
                                final Set<Card> cards = new HashSet<>();
                                cards.add(
                                        new Card(
                                                CardCategory.values()[cardCategory1Index],
                                                suit
                                        )
                                );
                                cards.add(
                                        new Card(
                                                CardCategory.values()[cardCategory2Index],
                                                suit
                                        )
                                );
                                cards.add(
                                        new Card(
                                                CardCategory.values()[cardCategory3Index],
                                                suit
                                        )
                                );
                                cards.add(
                                        new Card(
                                                CardCategory.values()[cardCategory4Index],
                                                suit
                                        )
                                );
                                cards.add(
                                        new Card(
                                                CardCategory.values()[cardCategory5Index],
                                                suit
                                        )
                                );
                                final Hand hand = new Hand(cards);
                                Assert.assertTrue(flushValidator.validateHand(hand));
                            }
                        }
                    }
                }
            }
        }
    }

}