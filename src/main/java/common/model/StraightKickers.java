package main.java.common.model;

public class StraightKickers extends Kickers {
    private final CardCategory highestCardCategory;

    public StraightKickers(final CardCategory highestCardCategory) {
        this.highestCardCategory = highestCardCategory;
    }

    public CardCategory getHighestCardCategory() {
        return highestCardCategory;
    }
}
