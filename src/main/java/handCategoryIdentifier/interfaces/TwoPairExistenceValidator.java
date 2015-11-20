package main.java.handCategoryIdentifier.interfaces;

import main.java.common.model.Hand;
import main.java.common.utils.interfaces.CardCategoryCountMapper;
import main.java.common.utils.interfaces.CardCategoryPairCounter;

public interface TwoPairExistenceValidator {
    boolean validateExistence(final Hand hand, final CardCategoryPairCounter cardCategoryPairCounter, final CardCategoryCountMapper cardCategoryCountMapper);
}
