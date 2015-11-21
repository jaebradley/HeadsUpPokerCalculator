package main.java.kickersCalculator.interfaces;

import main.java.common.model.FlushKickers;
import main.java.common.model.Hand;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;
import main.java.kickersCalculator.exceptions.HandDoesNotContainFiveDistinctCardCategoriesException;

public interface FlushKickersCalculator {
    FlushKickers calculateKickers(
            final Hand hand,
            final SortedCardCategoryReturner sortedCardCategoryReturner
    ) throws HandDoesNotContainFiveDistinctCardCategoriesException;
}
