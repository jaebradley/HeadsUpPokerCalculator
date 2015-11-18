package main.common.model;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void testExpected() {
        for (final CardCategory cardCategory : CardCategory.values()) {
            for (final Suit suit : Suit.values()) {
                final Card resultCard = new Card(
                        cardCategory,
                        suit
                );
                Assert.assertNotNull(resultCard);
                Assert.assertEquals(cardCategory, resultCard.getCardCategory());
                Assert.assertEquals(suit, resultCard.getSuit());
            }
        }
    }
}