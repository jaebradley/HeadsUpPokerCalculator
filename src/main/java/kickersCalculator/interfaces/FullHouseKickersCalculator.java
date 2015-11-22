package main.java.kickersCalculator.interfaces;

import main.java.common.model.FullHouseKickers;
import main.java.common.model.Hand;
import main.java.kickersCalculator.exceptions.HandDoesNotContainThreeOfAKindException;
import main.java.kickersCalculator.exceptions.HandDoesNotContainTwoOfAKindException;

public interface FullHouseKickersCalculator {
    FullHouseKickers calculateKickers(
            final Hand hand
    ) throws HandDoesNotContainThreeOfAKindException,
            HandDoesNotContainTwoOfAKindException;
}
