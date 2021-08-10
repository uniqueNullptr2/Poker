package unique.nullptr.poker;

import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;

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

    /***
     *
     * @return The value of the highest card of this hand
     */
    public CardValue highest() {
        //TODO implement
        return null;
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
        HandType type1 = determineType();
        HandType type2 = o.determineType();
        if (type1 == type2) {
            return highest().compareTo(o.highest());
        } else {
            return type1.compareTo(type2);
        }
    }

}
