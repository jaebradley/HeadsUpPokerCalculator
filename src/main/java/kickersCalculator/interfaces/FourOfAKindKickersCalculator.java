package main.java.kickersCalculator.interfaces;

import main.java.common.model.FourOfAKindKickers;
import main.java.common.model.Hand;
import main.java.kickersCalculator.exceptions.HandDoesNotContainFourOfAKindException;
import main.java.kickersCalculator.exceptions.HandDoesNotContainOneOfAKindException;
import main.java.kickersCalculator.exceptions.HandDoesNotContainTwoDistinctCardCategoriesException;

public interface FourOfAKindKickersCalculator {
    FourOfAKindKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainFourOfAKindException,
            HandDoesNotContainTwoDistinctCardCategoriesException,
            HandDoesNotContainOneOfAKindException;
}
