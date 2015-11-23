package main.java.common.model.kickers;

import main.java.common.model.CardCategory;

public class TwoPairKickers {
    private final CardCategory highestPairCardCategory;
    private final CardCategory lowestPairCardCategory;
    private final CardCategory remainingCardCategory;

    public TwoPairKickers(
            final CardCategory highestPairCardCategory,
            final CardCategory lowestPairCardCategory,
            final CardCategory remainingCardCategory
    ) {
        assert highestPairCardCategory.getValue() > lowestPairCardCategory.getValue();

        this.highestPairCardCategory = highestPairCardCategory;
        this.lowestPairCardCategory = lowestPairCardCategory;
        this.remainingCardCategory = remainingCardCategory;
    }

    public CardCategory getHighestPairCardCategory() {
        return highestPairCardCategory;
    }

    public CardCategory getLowestPairCardCategory() {
        return lowestPairCardCategory;
    }

    public CardCategory getRemainingCardCategory() {
        return remainingCardCategory;
    }
}
