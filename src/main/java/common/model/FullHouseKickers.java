package main.java.common.model;

public class FullHouseKickers {
    private final CardCategory threeOfAKindCardCategory;
    private final CardCategory twoOfAKindCardCategory;

    public FullHouseKickers(final CardCategory threeOfAKindCardCategory, final CardCategory twoOfAKindCardCategory) {
        this.threeOfAKindCardCategory = threeOfAKindCardCategory;
        this.twoOfAKindCardCategory = twoOfAKindCardCategory;
    }

    public CardCategory getThreeOfAKindCardCategory() {
        return threeOfAKindCardCategory;
    }

    public CardCategory getTwoOfAKindCardCategory() {
        return twoOfAKindCardCategory;
    }
}
