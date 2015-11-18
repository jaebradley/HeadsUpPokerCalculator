package java.main.common.model;

public class Card {
    private final CardCategory category;
    private final Suit suit;

    public Card(final CardCategory category, final Suit suit) {

        this.category = category;
        this.suit = suit;
    }

    public CardCategory getCategory() {
        return category;
    }

    public Suit getSuit() {
        return suit;
    }
}
