package main.java.common.model;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(final Card o1, final Card o2) {
        final int difference = o1.getCategory().getValue() - o2.getCategory().getValue();
        if (difference > 0) {
            return 1;
        } else if (difference < 0) {
            return -1;
        } else if (0 == difference) {
            return  0;
        } else {
            throw new RuntimeException("unexpected");
        }
    }
}
