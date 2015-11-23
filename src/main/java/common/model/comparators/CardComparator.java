package main.java.common.model.comparators;

import main.java.common.model.Card;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(final Card o1, final Card o2) {
        final int difference = o1.getCategory().getValue() - o2.getCategory().getValue();
        if (difference > 0 || 0 == difference) {
            return 1;
        } else if (difference < 0) {
            return -1;
        } else {
            throw new RuntimeException("unexpected");
        }
    }
}
