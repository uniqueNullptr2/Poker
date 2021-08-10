package unique.nullptr.poker;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Card[] cards1 = {
            new Card(CardSuit.Clubs, CardValue.Queen),
            new Card(CardSuit.Clubs, CardValue.Ace),
            new Card(CardSuit.Clubs, CardValue.Ten),
            new Card(CardSuit.Clubs, CardValue.Four),
            new Card(CardSuit.Clubs, CardValue.Two)
        };

        Hand hand1 = new Hand(Arrays.asList(cards1));

        Card[] cards2 = {
            new Card(CardSuit.Hearts, CardValue.Two),
            new Card(CardSuit.Diamonds, CardValue.Two),
            new Card(CardSuit.Spades, CardValue.Two),
            new Card(CardSuit.Hearts, CardValue.Ace),
            new Card(CardSuit.Diamonds, CardValue.Ace)
        };

        Hand hand2 = new Hand(Arrays.asList(cards2));

        System.out.printf("Hand1%n%s%n%n", hand1);
        System.out.printf("Hand2%n%s%n%n", hand2);

        Hand winner = Hand.pickWinner(hand1, hand2);
        if (winner == hand1) {
            System.out.println("Hand1 Wins");
        } else {
            System.out.println("Hand2 Wins");
        }
    }
}
