package main.java.kickersCalculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.HighCardKickers;
import main.java.kickersCalculator.exceptions.HandDoesNotContainFiveDistinctCardCategoriesException;

public interface HighCardKickersCalculator {
    HighCardKickers calculateKickers(
            final Hand hand,
            final SortedCardCategoryReturner sortedCardCategoryReturner
    ) throws HandDoesNotContainFiveDistinctCardCategoriesException;
}
