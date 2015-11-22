package main.java.kickersCalculator.interfaces;

import main.java.common.model.FourOfAKindKickers;
import main.java.common.model.Hand;

public interface FourOfAKindKickersCalculator {
    FourOfAKindKickers calculateKickers(final Hand hand, final CardCategoryCountMapper cardCategoryCountMapper);
}
