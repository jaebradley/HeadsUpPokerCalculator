package main.java.kickersCalculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.ThreeOfAKindKickers;
import main.java.kickersCalculator.exceptions.HandDoesNotContainThreeDistinctCardCategoriesException;
import main.java.kickersCalculator.exceptions.HandDoesNotContainThreeOfAKindException;

public interface ThreeOfAKindKickersCalculator {
    ThreeOfAKindKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainThreeOfAKindException,
            HandDoesNotContainThreeDistinctCardCategoriesException;
}
