package main.java.common.utils.interfaces;

import main.java.common.model.CardCategory;
import main.java.common.model.Hand;

import java.util.HashMap;

public interface CardCategoryCountMapper {
    HashMap<CardCategory, Integer> returnCardCategoryCountMap(final Hand hand);
}
