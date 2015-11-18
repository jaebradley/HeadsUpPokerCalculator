package java.main.handCategoryCalculator.interfaces;

import java.main.common.model.Hand;
import java.main.common.model.HandCategory;

public interface HandCategoryIdentifier {
    HandCategory identifyHandCategory(final Hand hand);
}
