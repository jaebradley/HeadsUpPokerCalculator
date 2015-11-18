package main.java.common.model;

public enum HandCategory {
    HighCard(1),
    OnePair(2),
    TwoPair(3),
    ThreeOfAKind(4),
    Straight(5),
    Flush(6),
    FullHouse(7),
    FourOfAKind(8),
    StraightFlush(9);

    private final int rankValue;

    HandCategory(final int rankValue) {
        this.rankValue = rankValue;
    }

    public int getRankValue() {
        return rankValue;
    }
}
