package main.java.common.model;

public class OnePairKickers {
    private final CardCategory pairCardCategory;
    private final CardCategory highestRemainingCardCategory;
    private final CardCategory secondHighestRemainingCardCategory;
    private final CardCategory lowestRemainingCardCategory;

    public OnePairKickers(
            final CardCategory pairCardCategory,
            final CardCategory highestRemainingCardCategory,
            final CardCategory secondHighestRemainingCardCategory,
            final CardCategory lowestRemainingCardCategory
    ) {
        this.pairCardCategory = pairCardCategory;
        this.highestRemainingCardCategory = highestRemainingCardCategory;
        this.secondHighestRemainingCardCategory = secondHighestRemainingCardCategory;
        this.lowestRemainingCardCategory = lowestRemainingCardCategory;
    }

    public CardCategory getPairCardCategory() {
        return pairCardCategory;
    }

    public CardCategory getHighestRemainingCardCategory() {
        return highestRemainingCardCategory;
    }

    public CardCategory getSecondHighestRemainingCardCategory() {
        return secondHighestRemainingCardCategory;
    }

    public CardCategory getLowestRemainingCardCategory() {
        return lowestRemainingCardCategory;
    }
}
