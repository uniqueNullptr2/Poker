package unique.nullptr.poker;

public class Card implements Comparable<Card> {
    private CardSuit suit;
    private CardValue val;

    public Card(CardSuit suit, CardValue val) {
        this.suit = suit;
        this.val = val;
    }

    public Card(Card card) {
        this.suit = card.suit;
        this.val = card.val;
    }

    @Override
    public int compareTo(Card o) {
        return val.compareTo(o.val);
    }

    public CardValue getVal() {
        return val;
    }

    public CardSuit getSuit() {
        return suit;
    }

}
