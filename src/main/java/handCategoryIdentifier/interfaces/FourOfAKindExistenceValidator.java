package main.java.handCategoryIdentifier.interfaces;

import main.java.common.model.Hand;
import main.java.common.utils.interfaces.CardCategoryCountMapper;

public interface FourOfAKindExistenceValidator {
    boolean validateExistence(final Hand hand, final CardCategoryCountMapper cardCategoryCountMapper);
}
