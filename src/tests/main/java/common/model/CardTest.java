package main.java.common.model;

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
                Assert.assertEquals(cardCategory, resultCard.getCategory());
                Assert.assertEquals(suit, resultCard.getSuit());
            }
        }
    }

    @Test
    public void testNull() {
        try {
            new Card(null, Suit.CLUBS);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }

        try {
            new Card(CardCategory.ACE, null);
            Assert.fail();
        } catch (AssertionError e) {
            // expected
        }
    }
}