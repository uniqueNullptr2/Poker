package unique.nullptr.poker;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void cardOrder()
    {
        Card king = new Card(CardSuit.Clubs, CardValue.King);
        Card three = new Card(CardSuit.Hearts, CardValue.Three);
        Card[] cards = {king, three};
        Arrays.sort(cards);
        assertTrue(cards[0] == three);
        assertTrue(cards[1] == king);
    }

    @Test
    public void highCard() {
        Card three = new Card(CardSuit.Clubs, CardValue.Three);
        Card four = new Card(CardSuit.Hearts, CardValue.Four);
        Card six = new Card(CardSuit.Diamonds, CardValue.Six);
        Card seven = new Card(CardSuit.Spades, CardValue.Seven);
        Card eight = new Card(CardSuit.Hearts, CardValue.Eight);
        Card[] cardArr = {four, eight, seven, six, three};
        Hand hand = new Hand(Arrays.asList(cardArr));
        assertEquals(hand.getHandType(), HandType.HighCard);
        assertEquals(hand.getHighCards()[0], CardValue.Eight);
    }

    @Test
    public void pair() {
        Card three1 = new Card(CardSuit.Clubs, CardValue.Three);
        Card three2 = new Card(CardSuit.Hearts, CardValue.Three);
        Card six = new Card(CardSuit.Diamonds, CardValue.Six);
        Card seven = new Card(CardSuit.Spades, CardValue.Seven);
        Card eight = new Card(CardSuit.Hearts, CardValue.Eight);
        Card[] cardArr = {three2, eight, seven, six, three1};
        Hand hand = new Hand(Arrays.asList(cardArr));
        assertEquals(hand.getHandType(), HandType.Pair);
        assertEquals(hand.getHighCards()[0], CardValue.Three);
    }

    @Test
    public void twoPair() {
        Card three1 = new Card(CardSuit.Clubs, CardValue.Three);
        Card three2 = new Card(CardSuit.Hearts, CardValue.Three);
        Card six1 = new Card(CardSuit.Diamonds, CardValue.Six);
        Card six2 = new Card(CardSuit.Spades, CardValue.Six);
        Card eight = new Card(CardSuit.Hearts, CardValue.Eight);
        Card[] cardArr = {three2, eight, six2, six1, three1};
        Hand hand = new Hand(Arrays.asList(cardArr));
        assertEquals(hand.getHandType(), HandType.TwoPair);
        assertEquals(hand.getHighCards()[0], CardValue.Six);
    }

    @Test
    public void threes() {
        Card three1 = new Card(CardSuit.Clubs, CardValue.Three);
        Card three2 = new Card(CardSuit.Hearts, CardValue.Three);
        Card three3 = new Card(CardSuit.Diamonds, CardValue.Three);
        Card seven = new Card(CardSuit.Spades, CardValue.Seven);
        Card eight = new Card(CardSuit.Hearts, CardValue.Eight);
        Card[] cardArr = {three2, eight, seven, three3, three1};
        Hand hand = new Hand(Arrays.asList(cardArr));
        assertEquals(hand.getHandType(), HandType.Threes);
        assertEquals(hand.getHighCards()[0], CardValue.Three);
    }

    @Test
    public void straight() {
        Card three = new Card(CardSuit.Clubs, CardValue.Three);
        Card four = new Card(CardSuit.Hearts, CardValue.Four);
        Card six = new Card(CardSuit.Diamonds, CardValue.Six);
        Card seven = new Card(CardSuit.Spades, CardValue.Seven);
        Card five = new Card(CardSuit.Hearts, CardValue.Five);
        Card[] cardArr = {four, five, seven, six, three};
        Hand hand = new Hand(Arrays.asList(cardArr));
        assertEquals(hand.getHandType(), HandType.Straight);
        assertEquals(hand.getHighCards()[0], CardValue.Seven);
    }

    @Test
    public void flush() {
        Card three = new Card(CardSuit.Clubs, CardValue.Three);
        Card four = new Card(CardSuit.Clubs, CardValue.Four);
        Card six = new Card(CardSuit.Clubs, CardValue.Six);
        Card seven = new Card(CardSuit.Clubs, CardValue.Seven);
        Card eight = new Card(CardSuit.Clubs, CardValue.Eight);
        Card[] cardArr = {four, eight, seven, six, three};
        Hand hand = new Hand(Arrays.asList(cardArr));
        assertEquals(hand.getHandType(), HandType.Flush);
        assertEquals(hand.getHighCards()[0], CardValue.Eight);
    }

    @Test
    public void fullHouse() {
        Card three1 = new Card(CardSuit.Clubs, CardValue.Three);
        Card three2 = new Card(CardSuit.Hearts, CardValue.Three);
        Card six1 = new Card(CardSuit.Diamonds, CardValue.Six);
        Card six2 = new Card(CardSuit.Spades, CardValue.Six);
        Card six3 = new Card(CardSuit.Hearts, CardValue.Six);
        Card[] cardArr = {three2, six3, six2, six1, three1};
        Hand hand = new Hand(Arrays.asList(cardArr));
        assertEquals(hand.getHandType(), HandType.FullHouse);
        assertEquals(hand.getHighCards()[0], CardValue.Six);
    }

    @Test
    public void fours() {
        Card three1 = new Card(CardSuit.Clubs, CardValue.Three);
        Card six4 = new Card(CardSuit.Clubs, CardValue.Six);
        Card six1 = new Card(CardSuit.Diamonds, CardValue.Six);
        Card six2 = new Card(CardSuit.Spades, CardValue.Six);
        Card six3 = new Card(CardSuit.Hearts, CardValue.Six);
        Card[] cardArr = {six4, six3, six2, six1, three1};
        Hand hand = new Hand(Arrays.asList(cardArr));
        assertEquals(hand.getHandType(), HandType.Fours);
        assertEquals(hand.getHighCards()[0], CardValue.Six);
    }

    @Test
    public void straightFlush() {
        Card three = new Card(CardSuit.Clubs, CardValue.Three);
        Card four = new Card(CardSuit.Clubs, CardValue.Four);
        Card six = new Card(CardSuit.Clubs, CardValue.Six);
        Card seven = new Card(CardSuit.Clubs, CardValue.Seven);
        Card five = new Card(CardSuit.Clubs, CardValue.Five);
        Card[] cardArr = {four, five, seven, six, three};
        Hand hand = new Hand(Arrays.asList(cardArr));
        assertEquals(hand.getHandType(), HandType.StraightFlush);
        assertEquals(hand.getHighCards()[0], CardValue.Seven);
    }

    @Test
    public void compareSame() {
        Card three = new Card(CardSuit.Clubs, CardValue.Three);
        Card four = new Card(CardSuit.Clubs, CardValue.Four);
        Card six = new Card(CardSuit.Clubs, CardValue.Six);
        Card seven = new Card(CardSuit.Clubs, CardValue.Seven);
        Card five = new Card(CardSuit.Clubs, CardValue.Five);
        Card[] cardArr = {four, five, seven, six, three};
        // I know this isn't technically possible in game but suit doesnt matter much here
        Hand hand1 = new Hand(Arrays.asList(cardArr));
        Hand hand2 = new Hand(Arrays.asList(cardArr));
        assertEquals(hand1, Hand.pickWinner(hand1, hand2));
    }

    @Test
    public void compareSameType() {
        Card three = new Card(CardSuit.Clubs, CardValue.Three);
        Card four = new Card(CardSuit.Clubs, CardValue.Four);
        Card six = new Card(CardSuit.Clubs, CardValue.Six);
        Card seven = new Card(CardSuit.Clubs, CardValue.Seven);
        Card five = new Card(CardSuit.Clubs, CardValue.Five);
        Card eight = new Card(CardSuit.Clubs, CardValue.Eight);
        Card[] cardArr1 = {four, five, seven, six, three};
        Card[] cardArr2 = {four, five, seven, six, eight};
        Hand hand1 = new Hand(Arrays.asList(cardArr1));
        Hand hand2 = new Hand(Arrays.asList(cardArr2));
        assertEquals(hand2, Hand.pickWinner(hand1, hand2));
    }

    @Test
    public void compareDifferent() {
        Card three = new Card(CardSuit.Clubs, CardValue.Three);
        Card four = new Card(CardSuit.Clubs, CardValue.Four);
        Card six = new Card(CardSuit.Clubs, CardValue.Six);
        Card seven = new Card(CardSuit.Clubs, CardValue.Seven);
        Card five = new Card(CardSuit.Clubs, CardValue.Five);
        Card eight = new Card(CardSuit.Hearts, CardValue.Eight);
        Card[] cardArr1 = {four, five, seven, six, three};
        Card[] cardArr2 = {four, five, seven, six, eight};
        Hand hand1 = new Hand(Arrays.asList(cardArr1));
        Hand hand2 = new Hand(Arrays.asList(cardArr2));
        assertEquals(hand1, Hand.pickWinner(hand1, hand2));
    }

    @Test
public void comparePairsWithSamePairValue() {
    Card clubs3 = new Card(CardSuit.Clubs, CardValue.Three);
    Card hearts3 = new Card(CardSuit.Hearts, CardValue.Three);
    Card spades3 = new Card(CardSuit.Spades, CardValue.Three);
    Card diamonds3 = new Card(CardSuit.Diamonds, CardValue.Three);
    Card clubs6 = new Card(CardSuit.Clubs, CardValue.Six);
    Card clubs7 = new Card(CardSuit.Clubs, CardValue.Seven);
    Card clubs8 = new Card(CardSuit.Clubs, CardValue.Eight);
    Card hearts7 = new Card(CardSuit.Hearts, CardValue.Seven);
    Card hearts8 = new Card(CardSuit.Hearts, CardValue.Eight);
    Card hearts9 = new Card(CardSuit.Hearts, CardValue.Nine);
    Hand hand1 = new Hand(Arrays.asList(clubs3, hearts3, clubs6, clubs7, clubs8));
    Hand hand2 = new Hand(Arrays.asList(spades3, diamonds3, hearts7, hearts8, hearts9));
    assertEquals(hand2, Hand.pickWinner(hand1, hand2));
}

}
