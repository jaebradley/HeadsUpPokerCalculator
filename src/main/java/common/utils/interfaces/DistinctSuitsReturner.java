package main.java.common.utils.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.Suit;

import java.util.HashSet;

public interface DistinctSuitsReturner {
    HashSet<Suit> returnDistinctSuits(final Hand hand);
}
