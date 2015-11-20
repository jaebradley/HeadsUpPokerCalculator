package main.java.kickersReturner.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.StraightKickers;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;

public interface StraightKickersReturner {
    StraightKickers returnKickers(final Hand hand, final SortedCardCategoryReturner sortedCardCategoryReturner);
}
