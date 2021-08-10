package unique.nullptr.poker;

import static org.junit.Assert.assertTrue;

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
    public void highestCard() {
        Card three = new Card(CardSuit.Clubs, CardValue.Three);
        Card six = new Card(CardSuit.Clubs, CardValue.Six);
        Card ten = new Card(CardSuit.Clubs, CardValue.Ten);
        Card nine = new Card(CardSuit.Clubs, CardValue.Nine);
        Card queen = new Card(CardSuit.Clubs, CardValue.Queen);
        Card ace = new Card(CardSuit.Clubs, CardValue.Ace);
        Card[] cards1 = {three, six, ten,queen, nine};
        Card[] cards2 = {queen, ace, three, ten, nine};
        Card[] cards3 = {three, six, ten, nine, queen};
        Hand hand1 = new Hand(Arrays.asList(cards1));
        Hand hand2 = new Hand(Arrays.asList(cards2));
        Hand hand3 = new Hand(Arrays.asList(cards3));
        assertTrue(hand1.highest() == CardValue.Queen);
        assertTrue(hand2.highest() == CardValue.Ace);
        assertTrue(hand3.highest() == CardValue.Queen);
    }

    @Test
    public void handTypes() {
        Card threeC = new Card(CardSuit.Clubs, CardValue.Three);
        Card threeH = new Card(CardSuit.Hearts, CardValue.Three);
        Card threeD = new Card(CardSuit.Diamonds, CardValue.Three);
        Card threeS = new Card(CardSuit.Spades, CardValue.Three);
        Card twoH = new Card(CardSuit.Hearts, CardValue.Two);
        Card fourD = new Card(CardSuit.Diamonds, CardValue.Four);
        Card fourH = new Card(CardSuit.Hearts, CardValue.Four);
        Card fiveC = new Card(CardSuit.Clubs, CardValue.Five);
        Card fiveH = new Card(CardSuit.Hearts, CardValue.Five);
        Card sixD = new Card(CardSuit.Diamonds, CardValue.Six);
        Card sixH = new Card(CardSuit.Hearts, CardValue.Six);
        Card sevenH = new Card(CardSuit.Hearts, CardValue.Seven);
        Card tenC = new Card(CardSuit.Clubs, CardValue.Ten);
        Card nineS = new Card(CardSuit.Spades, CardValue.Nine);
        Card queenC = new Card(CardSuit.Clubs, CardValue.Queen);
        Card aceC = new Card(CardSuit.Clubs, CardValue.Ace);

        Card[] highestArr = {threeC, sixD, tenC, queenC, nineS};
        Card[] pairArr = {queenC, aceC, threeC, threeH, nineS};
        Card[] twoPairArr = {threeC, threeH, tenC, fourD, fourH};
        Card[] threesArr = {threeC, threeH, threeD, nineS, queenC};
        Card[] straightArr = {threeD, fiveC, sixD, fourD, twoH};
        Card[] flushArr = {fourH, twoH, sixH, threeH, sevenH};
        Card[] fullHouseArr = {threeH, fourD, threeD, threeC, fourH};
        Card[] foursArr = {threeD, twoH, threeH, threeC, threeS};
        Card[] straightFlushArr = {threeH, fiveH, twoH, fourH, sixH};

        Hand highest = new Hand(Arrays.asList(highestArr));
        Hand pair = new Hand(Arrays.asList(pairArr));
        Hand twoPair = new Hand(Arrays.asList(twoPairArr));
        Hand threes = new Hand(Arrays.asList(threesArr));
        Hand straight = new Hand(Arrays.asList(straightArr));
        Hand flush = new Hand(Arrays.asList(flushArr));
        Hand fullHouse = new Hand(Arrays.asList(fullHouseArr));
        Hand fours = new Hand(Arrays.asList(foursArr));
        Hand straightFlush = new Hand(Arrays.asList(straightFlushArr));

        assertTrue(highest.determineType() == HandType.HighCard);
        assertTrue(pair.determineType() == HandType.Pair);
        assertTrue(twoPair.determineType() == HandType.TwoPair);
        assertTrue(threes.determineType() == HandType.Threes);
        assertTrue(straight.determineType() == HandType.Straight);
        assertTrue(flush.determineType() == HandType.Flush);
        assertTrue(fullHouse.determineType() == HandType.FullHouse);
        assertTrue(fours.determineType() == HandType.Fours);
        assertTrue(straightFlush.determineType() == HandType.StraightFlush);
    }
}
