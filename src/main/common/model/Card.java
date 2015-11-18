package main.common.model;

public class Card {
    private final CardCategory cardCategory;
    private final Suit suit;

    public Card(final CardCategory cardCategory, final Suit suit) {

        this.cardCategory = cardCategory;
        this.suit = suit;
    }

    public CardCategory getCardCategory() {
        return cardCategory;
    }

    public Suit getSuit() {
        return suit;
    }
}
