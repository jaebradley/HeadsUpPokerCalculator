package main.java.common.model;

public class ThreeOfAKindKickers {
    private final CardCategory threeOfAKindCardCategory;
    private final CardCategory highestRemainingCardCategory;
    private final CardCategory lowestRemainingCardCategory;

    public ThreeOfAKindKickers(
            final CardCategory threeOfAKindCardCategory,
            final CardCategory highestRemainingCardCategory,
            final CardCategory lowestRemainingCardCategory
    ) {
        this.threeOfAKindCardCategory = threeOfAKindCardCategory;
        this.highestRemainingCardCategory = highestRemainingCardCategory;
        this.lowestRemainingCardCategory = lowestRemainingCardCategory;
    }

    public CardCategory getThreeOfAKindCardCategory() {
        return threeOfAKindCardCategory;
    }

    public CardCategory getHighestRemainingCardCategory() {
        return highestRemainingCardCategory;
    }

    public CardCategory getLowestRemainingCardCategory() {
        return lowestRemainingCardCategory;
    }
}
