package main.java.handCategoryIdentifier.interfaces;

import main.java.common.model.Hand;
import main.java.common.utils.interfaces.SortedCardCategoryReturner;

public interface StraightExistenceValidator {
    boolean validateExistence(final Hand hand, final SortedCardCategoryReturner sortedCardCategoryReturner);
}
