package main.java.common.model;

public class EvaluatedHand {
    private final HandCategory category;
    private final CardCategory[] orderedKickers;

    public EvaluatedHand(final HandCategory category, final CardCategory[] orderedKickers) {
        assert orderedKickers.length < 6;
        assert orderedKickers.length > 0;

        this.category = category;
        this.orderedKickers = orderedKickers;
    }

    public HandCategory getCategory() {
        return category;
    }

    public CardCategory[] getOrderedKickers() {
        return orderedKickers;
    }
}
