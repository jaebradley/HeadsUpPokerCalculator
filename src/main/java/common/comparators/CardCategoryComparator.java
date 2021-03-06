package main.java.common.comparators;

import main.java.common.model.CardCategory;

import java.util.Comparator;

public class CardCategoryComparator implements Comparator<CardCategory> {
    @Override
    public int compare(final CardCategory o1, final CardCategory o2) {
        final int difference = o1.getRankValue() - o2.getRankValue();
        if (difference > 0) {
            return 1;
        }

        if (difference < 0) {
            return -1;
        }

        if (0 == difference) {
            return 0;
        }

        throw new RuntimeException("unexpected");
    }
}
