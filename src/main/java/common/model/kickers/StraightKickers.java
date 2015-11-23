package main.java.common.model.kickers;

import main.java.common.model.CardCategory;

public class StraightKickers {
    private final CardCategory highestCardCategory;

    public StraightKickers(final CardCategory highestCardCategory) {
        this.highestCardCategory = highestCardCategory;
    }

    public CardCategory getHighestCardCategory() {
        return highestCardCategory;
    }
}
