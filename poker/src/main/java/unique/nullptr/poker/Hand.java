package unique.nullptr.poker;

import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;

    public Hand(List<Card> cards) {
        Collections.sort(cards);
        this.cards = cards;
    }

    
}
