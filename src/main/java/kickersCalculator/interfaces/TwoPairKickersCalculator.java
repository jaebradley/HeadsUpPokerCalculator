package main.java.kickersCalculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.TwoPairKickers;
import main.java.kickersCalculator.exceptions.HandDoesNotContainThreeDistinctCardCategoriesException;
import main.java.kickersCalculator.exceptions.HandDoesNotContainTwoOfAKindException;

public interface TwoPairKickersCalculator {
    TwoPairKickers calculateKickers(
            final Hand hand,
            final SortedCardCategoryMapper sortedCardCategoryMapper
    ) throws HandDoesNotContainThreeDistinctCardCategoriesException,
            HandDoesNotContainTwoOfAKindException;
}
