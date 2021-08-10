package unique.nullptr.poker;

import java.util.List;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    
}
