package main.java.kickersReturner.impl;

import main.java.common.model.Hand;
import main.java.common.model.StraightKickers;
import main.java.kickersReturner.interfaces.StraightKickersReturner;

public class StraightKickersReturnerImpl implements StraightKickersReturner {
    @Override
    public StraightKickers returnKickers(final Hand hand) {
        return new StraightKickers(hand.getSortedCardsInAscendingCategoryOrder().last().getCategory());
    }
}
