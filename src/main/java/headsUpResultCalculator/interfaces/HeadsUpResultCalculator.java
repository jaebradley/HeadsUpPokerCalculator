package main.java.headsUpResultCalculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.HeadsUpResult;
import main.java.handCategoryIdentifier.interfaces.HandCategoryIdentifier;
import main.java.handCategoryIdentifier.models.HandCategoryExistenceValidators;
import main.java.kickersCalculator.models.KickerCalculators;

public interface HeadsUpResultCalculator {
    HeadsUpResult calculateHeadsUpResult(
            final Hand dealerHand,
            final Hand bigBlindHand,
            final KickerCalculators kickerCalculators,
            final HandCategoryExistenceValidators handCategoryExistenceValidators,
            final HandCategoryIdentifier handCategoryIdentifier
            );
}
