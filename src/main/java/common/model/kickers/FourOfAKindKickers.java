package main.java.common.model.kickers;

import main.java.common.model.CardCategory;

public class FourOfAKindKickers {
    private final CardCategory fourOfAKindCardCategory;
    private final CardCategory remainingCardCategory;

    public FourOfAKindKickers(final CardCategory fourOfAKindCardCategory, final CardCategory remainingCardCategory) {
        this.fourOfAKindCardCategory = fourOfAKindCardCategory;
        this.remainingCardCategory = remainingCardCategory;
    }

    public CardCategory getFourOfAKindCardCategory() {
        return fourOfAKindCardCategory;
    }

    public CardCategory getRemainingCardCategory() {
        return remainingCardCategory;
    }
}
