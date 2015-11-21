package main.java.kickersCalculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.OnePairKickers;
import main.java.common.utils.interfaces.SortedCardCategoryMapper;
import main.java.kickersCalculator.exceptions.HandDoesNotContainFourDistinctCardCategoriesException;
import main.java.kickersCalculator.exceptions.HandDoesNotContainTwoOfAKindException;

public interface OnePairKickersCalculator {
    OnePairKickers calculateKickers(
            final Hand hand,
            final SortedCardCategoryMapper sortedCardCategoryMapper
    ) throws HandDoesNotContainFourDistinctCardCategoriesException, HandDoesNotContainTwoOfAKindException;
}
