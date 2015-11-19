package main.java.common.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class HandTest {

    @Test
    public void expectedCase() {
        // TODO: cover all cases including insufficient size
        for (final Suit suit : Suit.values()) {
            for (int cardCategory1Index = 0; cardCategory1Index < CardCategory.values().length - 4; cardCategory1Index++) {
                for (int cardCategory2Index = cardCategory1Index + 1; cardCategory2Index < CardCategory.values().length - 3; cardCategory2Index++) {
                    for (int cardCategory3Index = cardCategory2Index + 1; cardCategory3Index < CardCategory.values().length - 2; cardCategory3Index++) {
                        for (int cardCategory4Index = cardCategory3Index + 1; cardCategory4Index < CardCategory.values().length - 1; cardCategory4Index++) {
                            for (int cardCategory5Index = cardCategory4Index + 1; cardCategory5Index < CardCategory.values().length - 1; cardCategory5Index++) {
                                final HashSet<Card> cards = new HashSet<>();
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
                                Assert.assertNotNull(hand);
                                Assert.assertEquals(cards, hand.getCards());
                            }
                        }
                    }
                }
            }
        }

    }
}