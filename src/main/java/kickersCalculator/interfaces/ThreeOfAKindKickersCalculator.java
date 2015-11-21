package main.java.kickersCalculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.ThreeOfAKindKickers;
import main.java.common.utils.interfaces.SortedCardCategoryCountMapper;
import main.java.kickersCalculator.exceptions.HandDoesNotContainThreeDifferentCardCategoriesException;
import main.java.kickersCalculator.exceptions.HandDoesNotContainThreeOfAKindException;

public interface ThreeOfAKindKickersCalculator {
    ThreeOfAKindKickers calculateKickers(
            final Hand hand,
            final SortedCardCategoryCountMapper sortedCardCategoryCountMapper
    ) throws HandDoesNotContainThreeOfAKindException,
            HandDoesNotContainThreeDifferentCardCategoriesException;
}
