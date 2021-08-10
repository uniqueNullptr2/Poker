package unique.nullptr.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;
    private HandType handType = null;
    private CardValue highCard = null;

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

        if (isStraight && isFlush) {
            handType = HandType.StraightFlush;
            highCard = this.cards.get(this.cards.size()-1).getVal();
        } else if (isStraight) {
            handType = HandType.Straight;
            highCard = this.cards.get(this.cards.size()-1).getVal();
        } else if (isFlush) {
            handType = HandType.Flush;
            highCard = this.cards.get(this.cards.size()-1).getVal();
        } else {
            List<int[]> counts = new ArrayList<>();
            for (int i = 0; i < counter.length; i++) {
                if (counter[i] > 0) {
                    int[] tmp = {i, counter[i]};
                    counts.add(tmp);
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

            if (counts.get(0)[1] == 4) {
                handType = HandType.Fours;
                highCard = CardValue.values()[counts.get(0)[0]];
            } else if (counts.get(0)[1] == 3 && counts.get(1)[1] == 2) {
                handType = HandType.FullHouse;
                highCard = CardValue.values()[counts.get(0)[0]];
            } else if (counts.get(0)[1] == 3) {
                handType = HandType.Threes;
                highCard = CardValue.values()[counts.get(0)[0]];
            } else if (counts.get(0)[1] == 2 && counts.get(1)[1] == 2) {
                handType = HandType.TwoPair;
                highCard = CardValue.values()[counts.get(0)[0]];
            } else if (counts.get(0)[1] == 2) {
                handType = HandType.Pair;
                highCard = CardValue.values()[counts.get(0)[0]];
            } else {
                handType = HandType.HighCard;
                highCard = CardValue.values()[counts.get(0)[0]];
            }
        }

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
