package unique.nullptr.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;
    private HandType handType = null;
    private CardValue highCard = null;

    public Hand(List<Card> cards) {
        Collections.sort(cards);
        this.cards = cards;
    }

    /***
     * Determine the winning hand
     * @param hand1
     * @param hand2
     * @return returns the winning hand or the first one in case of a tie
     */
    public static Hand pickWinner(Hand hand1, Hand hand2) {
        //TODO implement
        return hand1;
    }


    public CardValue getHighCard() {
        if (highCard == null)
            determineHand();
        return highCard;
    }

    public HandType getHandType() {
        if (handType == null)
            determineHand();
        return handType;
    }

    /***
     *
     * Sets HighCard and Handtype internally
     */
    private void determineHand() {
    }

    /***
     *
     * @return The type of hand (e.g Highest Card, Pair, etc...)
     */
    public HandType determineType() {
        //TODO implement
        return HandType.HighCard;
    }

    @Override
    public int compareTo(Hand o) {
        HandType type1 = getHandType();
        HandType type2 = o.getHandType();
        if (type1 == type2) {
            return getHighCard().compareTo(o.getHighCard());
        } else {
            return type1.compareTo(type2);
        }
    }

}
