package main.java.headsUpResultCalculator.impl;

import main.java.common.model.Hand;
import main.java.common.model.HandCategory;
import main.java.common.model.HeadsUpResult;
import main.java.common.model.KickersComparisonResult;
import main.java.handCategoryIdentifier.interfaces.HandCategoryIdentifier;
import main.java.headsUpResultCalculator.interfaces.HeadsUpResultCalculator;
import main.java.kickersCalculator.exceptions.*;
import main.java.kickersCalculator.interfaces.*;
import main.java.kickersComparisonResultCalculator.interfaces.*;

public class HeadsUpResultCalculatorImpl implements HeadsUpResultCalculator{
    private final HandCategoryIdentifier handCategoryIdentifier;
    private final FlushKickersCalculator flushKickersCalculator;
    private final StraightKickersCalculator straightKickersCalculator;
    private final HighCardKickersCalculator highCardKickersCalculator;
    private final FourOfAKindKickersCalculator fourOfAKindKickersCalculator;
    private final FullHouseKickersCalculator fullHouseKickersCalculator;
    private final ThreeOfAKindKickersCalculator threeOfAKindKickersCalculator;
    private final TwoPairKickersCalculator twoPairKickersCalculator;
    private final OnePairKickersCalculator onePairKickersCalculator;
    private final FlushKickersComparisonResultCalculator flushKickersComparisonResultCalculator;
    private final StraightKickersComparisonResultCalculator straightKickersComparisonResultCalculator;
    private final FourOfAKindKickersComparisonResultCalculator fourOfAKindKickersComparisonResultCalculator;
    private final FullHouseKickersComparisonResultCalculator fullHouseKickersComparisonResultCalculator;
    private final ThreeOfAKindKickersComparisonResultCalculator threeOfAKindKickersComparisonResultCalculator;
    private final TwoPairKickersComparisonResultCalculator twoPairKickersComparisonResultCalculator;
    private final OnePairKickersComparisonResultCalculator onePairKickersComparisonResultCalculator;
    private final HighCardKickersComparisonResultCalculator highCardKickersComparisonResultCalculator;


    public HeadsUpResultCalculatorImpl(
            final HandCategoryIdentifier handCategoryIdentifier,
            final FlushKickersCalculator flushKickersCalculator,
            final StraightKickersCalculator straightKickersCalculator,
            final HighCardKickersCalculator highCardKickersCalculator,
            final FourOfAKindKickersCalculator fourOfAKindKickersCalculator,
            final FullHouseKickersCalculator fullHouseKickersCalculator,
            final ThreeOfAKindKickersCalculator threeOfAKindKickersCalculator,
            final TwoPairKickersCalculator twoPairKickersCalculator,
            final OnePairKickersCalculator onePairKickersCalculator,
            final FlushKickersComparisonResultCalculator flushKickersComparisonResultCalculator,
            final StraightKickersComparisonResultCalculator straightKickersComparisonResultCalculator,
            final FourOfAKindKickersComparisonResultCalculator fourOfAKindKickersComparisonResultCalculator,
            final FullHouseKickersComparisonResultCalculator fullHouseKickersComparisonResultCalculator,
            final ThreeOfAKindKickersComparisonResultCalculator threeOfAKindKickersComparisonResultCalculator,
            final TwoPairKickersComparisonResultCalculator twoPairKickersComparisonResultCalculator,
            final OnePairKickersComparisonResultCalculator onePairKickersComparisonResultCalculator,
            final HighCardKickersComparisonResultCalculator highCardKickersComparisonResultCalculator) {
        this.handCategoryIdentifier = handCategoryIdentifier;
        this.flushKickersCalculator = flushKickersCalculator;
        this.straightKickersCalculator = straightKickersCalculator;
        this.highCardKickersCalculator = highCardKickersCalculator;
        this.fourOfAKindKickersCalculator = fourOfAKindKickersCalculator;
        this.fullHouseKickersCalculator = fullHouseKickersCalculator;
        this.threeOfAKindKickersCalculator = threeOfAKindKickersCalculator;
        this.twoPairKickersCalculator = twoPairKickersCalculator;
        this.onePairKickersCalculator = onePairKickersCalculator;
        this.flushKickersComparisonResultCalculator = flushKickersComparisonResultCalculator;
        this.straightKickersComparisonResultCalculator = straightKickersComparisonResultCalculator;
        this.fourOfAKindKickersComparisonResultCalculator = fourOfAKindKickersComparisonResultCalculator;
        this.fullHouseKickersComparisonResultCalculator = fullHouseKickersComparisonResultCalculator;
        this.threeOfAKindKickersComparisonResultCalculator = threeOfAKindKickersComparisonResultCalculator;
        this.twoPairKickersComparisonResultCalculator = twoPairKickersComparisonResultCalculator;
        this.onePairKickersComparisonResultCalculator = onePairKickersComparisonResultCalculator;
        this.highCardKickersComparisonResultCalculator = highCardKickersComparisonResultCalculator;
    }

    @Override
    public HeadsUpResult calculateHeadsUpResult(
            final Hand dealerHand,
            final Hand bigBlindHand
    ) throws HandDoesNotContainFiveDistinctCardCategoriesException, HandDoesNotContainTwoOfAKindException, HandDoesNotContainThreeOfAKindException, HandDoesNotContainThreeDistinctCardCategoriesException, HandDoesNotContainFourDistinctCardCategoriesException {
        assert null != dealerHand;
        assert null != bigBlindHand;

        final HandCategory dealerHandCategory = handCategoryIdentifier.identifyHandCategory(dealerHand);
        final HandCategory bigBlindHandCategory = handCategoryIdentifier.identifyHandCategory(bigBlindHand);

        if (dealerHandCategory.getRankValue() > bigBlindHandCategory.getRankValue()) {
            return HeadsUpResult.DEALER_WINS;
        }

        if (bigBlindHandCategory.getRankValue() > dealerHandCategory.getRankValue()) {
            return HeadsUpResult.BIG_BLIND_WINS;
        }

        KickersComparisonResult kickersComparisonResult = null;
        if (dealerHandCategory.getRankValue() == bigBlindHandCategory.getRankValue()) {
            switch (dealerHandCategory) {
                case StraightFlush: {
                    kickersComparisonResult = straightKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            straightKickersCalculator.calculateKickers(dealerHand),
                            straightKickersCalculator.calculateKickers(bigBlindHand)
                    );
                    break;
                }

                case FourOfAKind: {
                    kickersComparisonResult = fourOfAKindKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            fourOfAKindKickersCalculator.calculateKickers(dealerHand),
                            fourOfAKindKickersCalculator.calculateKickers(bigBlindHand)
                    );
                    break;
                }

                case FullHouse: {
                    kickersComparisonResult = fullHouseKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            fullHouseKickersCalculator.calculateKickers(dealerHand),
                            fullHouseKickersCalculator.calculateKickers(bigBlindHand)
                    );
                    break;
                }

                case Flush: {
                    kickersComparisonResult = flushKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            flushKickersCalculator.calculateKickers(dealerHand),
                            flushKickersCalculator.calculateKickers(bigBlindHand)
                    );
                    break;
                }

                case Straight: {
                    kickersComparisonResult = straightKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            straightKickersCalculator.calculateKickers(dealerHand),
                            straightKickersCalculator.calculateKickers(bigBlindHand)
                    );
                    break;
                }

                case ThreeOfAKind: {
                    kickersComparisonResult = threeOfAKindKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            threeOfAKindKickersCalculator.calculateKickers(dealerHand),
                            threeOfAKindKickersCalculator.calculateKickers(bigBlindHand)
                    );
                    break;
                }

                case TwoPair: {
                    kickersComparisonResult = twoPairKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            twoPairKickersCalculator.calculateKickers(dealerHand),
                            twoPairKickersCalculator.calculateKickers(bigBlindHand)
                    );
                    break;
                }

                case OnePair: {
                    kickersComparisonResult = onePairKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            onePairKickersCalculator.calculateKickers(dealerHand),
                            onePairKickersCalculator.calculateKickers(bigBlindHand)
                    );
                    break;
                }

                case HighCard: {
                    kickersComparisonResult = highCardKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            highCardKickersCalculator.calculateKickers(dealerHand),
                            highCardKickersCalculator.calculateKickers(bigBlindHand)
                    );
                    break;
                }

                default: {
                    throw new RuntimeException("unexpected");
                }
            }
        }

        switch (kickersComparisonResult) {
            case FIRST: {
                return HeadsUpResult.DEALER_WINS;
            }

            case SECOND: {
                return HeadsUpResult.BIG_BLIND_WINS;
            }

            case TIE: {
                return HeadsUpResult.TIE;
            }

            default: {
                throw new RuntimeException("unexpected");he
            }
        }
    }
}
