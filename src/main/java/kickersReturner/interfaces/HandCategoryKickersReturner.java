package main.java.kickersReturner.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.Kickers;

public interface HandCategoryKickersReturner {
    Kickers returnKickers(final Hand hand);
}
