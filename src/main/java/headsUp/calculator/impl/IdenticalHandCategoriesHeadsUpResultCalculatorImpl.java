package main.java.headsUp.calculator.impl;

import main.java.common.model.Hand;
import main.java.common.model.HandCategory;
import main.java.common.model.HeadsUpResult;
import main.java.common.model.KickersComparisonResult;
import main.java.hand.category.identifier.interfaces.HandCategoryIdentifier;
import main.java.headsUp.calculator.exceptions.UnableToCompareKickersException;
import main.java.headsUp.calculator.interfaces.IdenticalHandCategoriesHeadsUpResultCalculator;
import main.java.kickers.calculator.exceptions.*;
import main.java.kickers.calculator.interfaces.*;
import main.java.kickers.comparator.interfaces.*;

public class IdenticalHandCategoriesHeadsUpResultCalculatorImpl implements IdenticalHandCategoriesHeadsUpResultCalculator {
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

    public IdenticalHandCategoriesHeadsUpResultCalculatorImpl(
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
    public HeadsUpResult calculateHeadsUpResultForHandsWithIdenticalCategories(
            final Hand dealerHand,
            final Hand bigBlindHand
    ) throws UnableToCompareKickersException {
        assert null != dealerHand;
        assert null != bigBlindHand;

        final HandCategory dealerHandCategory = handCategoryIdentifier.identifyHandCategory(dealerHand);
        final HandCategory bigBlindHandCategory = handCategoryIdentifier.identifyHandCategory(bigBlindHand);
        assert dealerHandCategory.getRankValue() == bigBlindHandCategory.getRankValue();

        KickersComparisonResult kickersComparisonResult;
        switch (dealerHandCategory) {
            case StraightFlush: {
                try {
                    kickersComparisonResult = straightKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            straightKickersCalculator.calculateKickers(dealerHand),
                            straightKickersCalculator.calculateKickers(bigBlindHand)
                    );
                } catch (HandDoesNotContainFiveDistinctCardCategoriesException e) {
                    throw new UnableToCompareKickersException("unable to compare kickers for dealer hand: " + dealerHand + " and big blind hand " + bigBlindHand);
                }
                break;
            }

            case FourOfAKind: {
                try {
                    kickersComparisonResult = fourOfAKindKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            fourOfAKindKickersCalculator.calculateKickers(dealerHand),
                            fourOfAKindKickersCalculator.calculateKickers(bigBlindHand)
                    );
                } catch (HandDoesNotContainFourOfAKindException | HandDoesNotContainTwoDistinctCardCategoriesException | HandDoesNotContainOneOfAKindException e) {
                    throw new UnableToCompareKickersException("unable to compare kickers for dealer hand: " + dealerHand + " and big blind hand " + bigBlindHand);
                }
                break;
            }

            case FullHouse: {
                try {
                    kickersComparisonResult = fullHouseKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            fullHouseKickersCalculator.calculateKickers(dealerHand),
                            fullHouseKickersCalculator.calculateKickers(bigBlindHand)
                    );
                } catch (HandDoesNotContainThreeOfAKindException | HandDoesNotContainTwoOfAKindException e) {
                    throw new UnableToCompareKickersException("unable to compare kickers for dealer hand: " + dealerHand + " and big blind hand " + bigBlindHand);
                }
                break;
            }

            case Flush: {
                try {
                    kickersComparisonResult = flushKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            flushKickersCalculator.calculateKickers(dealerHand),
                            flushKickersCalculator.calculateKickers(bigBlindHand)
                    );
                } catch (HandDoesNotContainFiveDistinctCardCategoriesException e) {
                    throw new UnableToCompareKickersException("unable to compare kickers for dealer hand: " + dealerHand + " and big blind hand " + bigBlindHand);
                }
                break;
            }

            case Straight: {
                try {
                    kickersComparisonResult = straightKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            straightKickersCalculator.calculateKickers(dealerHand),
                            straightKickersCalculator.calculateKickers(bigBlindHand)
                    );
                } catch (HandDoesNotContainFiveDistinctCardCategoriesException e) {
                    throw new UnableToCompareKickersException("unable to compare kickers for dealer hand: " + dealerHand + " and big blind hand " + bigBlindHand);
                }
                break;
            }

            case ThreeOfAKind: {
                try {
                    kickersComparisonResult = threeOfAKindKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            threeOfAKindKickersCalculator.calculateKickers(dealerHand),
                            threeOfAKindKickersCalculator.calculateKickers(bigBlindHand)
                    );
                } catch (HandDoesNotContainThreeOfAKindException | HandDoesNotContainThreeDistinctCardCategoriesException e) {
                    throw new UnableToCompareKickersException("unable to compare kickers for dealer hand: " + dealerHand + " and big blind hand " + bigBlindHand);
                }
                break;
            }

            case TwoPair: {
                try {
                    kickersComparisonResult = twoPairKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            twoPairKickersCalculator.calculateKickers(dealerHand),
                            twoPairKickersCalculator.calculateKickers(bigBlindHand)
                    );
                } catch (HandDoesNotContainThreeDistinctCardCategoriesException | HandDoesNotContainTwoOfAKindException e) {
                    throw new UnableToCompareKickersException("unable to compare kickers for dealer hand: " + dealerHand + " and big blind hand " + bigBlindHand);
                }
                break;
            }

            case OnePair: {
                try {
                    kickersComparisonResult = onePairKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            onePairKickersCalculator.calculateKickers(dealerHand),
                            onePairKickersCalculator.calculateKickers(bigBlindHand)
                    );
                } catch (HandDoesNotContainFourDistinctCardCategoriesException | HandDoesNotContainTwoOfAKindException e) {
                    throw new UnableToCompareKickersException("unable to compare kickers for dealer hand: " + dealerHand + " and big blind hand " + bigBlindHand);
                }
                break;
            }

            case HighCard: {
                try {
                    kickersComparisonResult = highCardKickersComparisonResultCalculator.calculateKickersComparisonResult(
                            highCardKickersCalculator.calculateKickers(dealerHand),
                            highCardKickersCalculator.calculateKickers(bigBlindHand)
                    );
                } catch (HandDoesNotContainFiveDistinctCardCategoriesException e) {
                    throw new UnableToCompareKickersException("unable to compare kickers for dealer hand: " + dealerHand + " and big blind hand " + bigBlindHand);
                }
                break;
            }

            default: {
                throw new RuntimeException("unexpected");
            }
        }

        switch (kickersComparisonResult) {
            case DEALER_WINS: {
                return HeadsUpResult.DEALER_WINS;
            }

            case BIG_BLIND_WINS: {
                return HeadsUpResult.BIG_BLIND_WINS;
            }

            case TIE: {
                return HeadsUpResult.TIE;
            }

            default: {
                throw new RuntimeException("unexpected");
            }
        }
    }
}
