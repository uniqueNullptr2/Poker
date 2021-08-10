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
        Card[] cards = {three, king};
        Arrays.sort(cards);
        assertTrue(cards[0] == king);
        assertTrue(cards[1] == three);
    }
}
