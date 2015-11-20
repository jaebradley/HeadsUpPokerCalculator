package main.java.handCategoryIdentifier.interfaces;

import main.java.common.model.Hand;
import main.java.common.utils.interfaces.DistinctSuitsReturner;

public interface FlushExistenceValidator {
    boolean validateExistence(final Hand hand, final DistinctSuitsReturner distinctSuitsReturner);
}
