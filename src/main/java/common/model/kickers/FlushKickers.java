package main.java.common.model.kickers;

import main.java.common.model.CardCategory;

public class FlushKickers {
    private final CardCategory highestCardCategory;
    private final CardCategory secondHighestCardCategory;
    private final CardCategory thirdHighestCardCategory;
    private final CardCategory fourthHighestCardCategory;
    private final CardCategory fifthHighestCardCategory;

    public FlushKickers(
            final CardCategory highestCardCategory,
            final CardCategory secondHighestCardCategory,
            final CardCategory thirdHighestCardCategory,
            final CardCategory fourthHighestCardCategory,
            final CardCategory fifthHighestCardCategory
    ) {
        this.highestCardCategory = highestCardCategory;
        this.secondHighestCardCategory = secondHighestCardCategory;
        this.thirdHighestCardCategory = thirdHighestCardCategory;
        this.fourthHighestCardCategory = fourthHighestCardCategory;
        this.fifthHighestCardCategory = fifthHighestCardCategory;
    }

    public CardCategory getHighestCardCategory() {
        return highestCardCategory;
    }

    public CardCategory getSecondHighestCardCategory() {
        return secondHighestCardCategory;
    }

    public CardCategory getThirdHighestCardCategory() {
        return thirdHighestCardCategory;
    }

    public CardCategory getFourthHighestCardCategory() {
        return fourthHighestCardCategory;
    }

    public CardCategory getFifthHighestCardCategory() {
        return fifthHighestCardCategory;
    }
}
