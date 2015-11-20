package main.java.common.model;

public class StraightKickers {
    private final CardCategory highestCardCategory;

    public StraightKickers(final CardCategory highestCardCategory) {
        this.highestCardCategory = highestCardCategory;
    }

    public CardCategory getHighestCardCategory() {
        return highestCardCategory;
    }
}
