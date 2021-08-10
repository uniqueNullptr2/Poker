package unique.nullptr.poker;

public class Card implements Comparable<Card> {
    private CardSuit suit;
    private CardValue val;

    public Card(CardSuit suit, CardValue val) {
        this.suit = suit;
        this.val = val;
    }

    @Override
    public int compareTo(Card o) {
        return o.val.compareTo(val);
    }

}
