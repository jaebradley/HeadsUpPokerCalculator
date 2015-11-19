package main.java.handCategoryIdentifier.impl;

import main.java.common.model.Hand;
import main.java.handCategoryIdentifier.interfaces.FlushExistenceValidator;

public class HandCategoryIdentifierImplTest {
    private final FlushExistenceValidator flushExistenceValidator = new FlushExistenceValidator() {
        @Override
        public boolean validateExistence(final Hand hand) {
            return false;
        }
    };
}