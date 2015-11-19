package main.java.kickersReturner.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.StraightKickers;
import main.java.common.utils.interfaces.SortedCardsReturner;

public interface StraightKickersReturner {
    StraightKickers returnKickers(final Hand hand, final SortedCardsReturner sortedCardsReturner);
}
