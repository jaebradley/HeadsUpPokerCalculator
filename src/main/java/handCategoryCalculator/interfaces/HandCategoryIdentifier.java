package main.java.handCategoryCalculator.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.HandCategory;

public interface HandCategoryIdentifier {
    HandCategory identifyHandCategory(final Hand hand);
}
