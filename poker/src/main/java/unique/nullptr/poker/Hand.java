package unique.nullptr.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;
    private HandType handType = null;
    private CardValue[] highCards = null;

    public Hand(List<Card> cards) {
        // clone list cause java has no move semantics
        // and rearranging the list outside this class
        // would lead to chaos
        this.cards = new ArrayList<>(cards);
        Collections.sort(this.cards);
    }

    /***
     * Determine the winning hand
     * @param hand1
     * @param hand2
     * @return returns the winning hand or the first one in case of a tie
     */
    public static Hand pickWinner(Hand hand1, Hand hand2) {
        if (hand1.compareTo(hand2) < 0) {
            return hand2;
        } else {
            return hand1;
        }
    }

    
    public CardValue[] getHighCards() {
        if (highCards == null)
            determineHand();
        return highCards;
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
        CardSuit lastSuit = cards.get(0).getSuit();
        boolean isFlush = true;
        boolean isStraight = true;
        int[] counter = new int[13];

        Card card;
        for (int i = 0 ; i < cards.size(); i++) {
            card = cards.get(i);

            if (lastSuit != card.getSuit())
                isFlush = false;

            if (i > 0 && cards.get(i-1).compareTo(card) != -1)
                isStraight = false;

            counter[card.getVal().ordinal()]++;

        }

        CardValue[] tmp = {cards.get(4).getVal(), cards.get(3).getVal(), cards.get(2).getVal(), cards.get(1).getVal(), cards.get(0).getVal()};
        highCards = tmp;
        if (isStraight && isFlush) {
            handType = HandType.StraightFlush;
            highCards = tmp;
        } else if (isStraight) {
            handType = HandType.Straight;
            highCards = tmp;
        } else if (isFlush) {
            handType = HandType.Flush;
            highCards = tmp;
        } else {
            List<int[]> counts = new ArrayList<>();
            for (int i = 0; i < counter.length; i++) {
                if (counter[i] > 0) {
                    int[] t = {i, counter[i]};
                    counts.add(t);
                }
            }

            counts.sort(new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2) {
                    // order desc by cardCound and cardValue
                    int t = o2[1] - o1[1];
                    if (t == 0) {
                        return o2[0] - o1[0];
                    } else {
                        return t;
                    }
                }
            });

            tmp = new CardValue[counts.size()];
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = CardValue.values()[counts.get(i)[0]];
            }
            if (counts.get(0)[1] == 4) {
                handType = HandType.Fours;
                highCards = tmp;
            } else if (counts.get(0)[1] == 3 && counts.get(1)[1] == 2) {
                handType = HandType.FullHouse;
                highCards = tmp;
            } else if (counts.get(0)[1] == 3) {
                handType = HandType.Threes;
                highCards = tmp;
            } else if (counts.get(0)[1] == 2 && counts.get(1)[1] == 2) {
                handType = HandType.TwoPair;
                highCards = tmp;
            } else if (counts.get(0)[1] == 2) {
                handType = HandType.Pair;
                highCards = tmp;
            } else {
                handType = HandType.HighCard;
                highCards = tmp;
            }
        }

    }

    @Override
    public int compareTo(Hand o) {
        HandType type1 = getHandType();
        HandType type2 = o.getHandType();
        if (type1 == type2) {
            CardValue[] v1 = getHighCards();
            CardValue[] v2 = o.getHighCards();
            for (int i = 0; i < v1.length; i++) {
                if (v1[i] != v2[i])
                    return v1[i].compareTo(v2[i]);
            }
            return 0;
        } else {
            return type1.compareTo(type2);
        }
    }

    @Override
    public String toString() {
        return String.format("Hand: %s, Hightst Card: %s", getHandType().name(), getHighCards()[0].name());
    }
}
