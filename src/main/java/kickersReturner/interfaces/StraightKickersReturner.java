package main.java.kickersReturner.interfaces;

import main.java.common.model.Hand;
import main.java.common.model.StraightKickers;

public interface StraightKickersReturner extends HandCategoryKickersReturner {
    @Override
    StraightKickers returnKickers(final Hand hand);
}
