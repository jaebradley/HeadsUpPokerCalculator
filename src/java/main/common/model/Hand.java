package java.main.common.model;

public class Hand {
    private final Card firstCard;
    private final Card secondCard;
    private final Card thirdCard;
    private final Card fourthCard;
    private final Card fifthCard;

    public Hand(final Card firstCard, final Card secondCard, final Card thirdCard, final Card fourthCard, final Card fifthCard) {

        // assert that no cards are identical
        assert firstCard.getCategory() != secondCard.getCategory() && firstCard.getSuit() != secondCard.getSuit();
        assert firstCard.getCategory() != thirdCard.getCategory() && firstCard.getSuit() != thirdCard.getSuit();
        assert firstCard.getCategory() != fourthCard.getCategory() && firstCard.getSuit() != fourthCard.getSuit();
        assert firstCard.getCategory() != fifthCard.getCategory() && firstCard.getSuit() != fifthCard.getSuit();
        assert secondCard.getCategory() != thirdCard.getCategory() && secondCard.getSuit() != thirdCard.getSuit();
        assert secondCard.getCategory() != fourthCard.getCategory() && secondCard.getSuit() != fourthCard.getSuit();
        assert secondCard.getCategory() != fifthCard.getCategory() && secondCard.getSuit() != fifthCard.getSuit();
        assert thirdCard.getCategory() != fourthCard.getCategory() && thirdCard.getSuit() != fourthCard.getSuit();
        assert thirdCard.getCategory() != fifthCard.getCategory() && thirdCard.getSuit() != fifthCard.getSuit();
        assert fourthCard.getCategory() != fifthCard.getCategory() && fourthCard.getSuit() != fifthCard.getSuit();

        this.firstCard = firstCard;
        this.secondCard = secondCard;
        this.thirdCard = thirdCard;
        this.fourthCard = fourthCard;
        this.fifthCard = fifthCard;
    }

    public Card getFirstCard() {
        return firstCard;
    }

    public Card getSecondCard() {
        return secondCard;
    }

    public Card getThirdCard() {
        return thirdCard;
    }

    public Card getFourthCard() {
        return fourthCard;
    }

    public Card getFifthCard() {
        return fifthCard;
    }

    public Card[] getCards() {
        return new Card[] {
                firstCard,
                secondCard,
                thirdCard,
                fourthCard,
                fifthCard
        };
    }
}
