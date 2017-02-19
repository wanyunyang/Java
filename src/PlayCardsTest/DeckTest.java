package PlayCardsTest;


import PlayCards.Deck;
import org.junit.Assert;
import org.junit.Test;
import PlayCards.Card;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertFalse;


public class DeckTest {
    @Test
    public void testDeckHas52Cards() {
        Deck deck = new Deck();
        Assert.assertEquals(52, deck.numberOfLeftCards());
    }

    @Test
    public void testDeckHasExactOneCardForEachSuitAndRankComb() {
        Deck deck = new Deck();
        HashMap<Card.Suits, HashMap<Card.Ranks, Integer>> cardMap = new HashMap<>();
        for (Card.Suits suit: Card.Suits.values()) {
            HashMap<Card.Ranks, Integer> subMap = new HashMap<>();
            for (Card.Ranks rank: Card.Ranks.values()) {
                subMap.put(rank, 0);
            }
            cardMap.put(suit, subMap);
        }

        for (Card card : deck.getDeckOfCards()) {
            HashMap<Card.Ranks, Integer> subMap = cardMap.get(card.getSuit());
            subMap.put(card.getRank(), subMap.get(card.getRank()) + 1);
        }

        for (Card.Suits suit: Card.Suits.values()) {
            HashMap<Card.Ranks, Integer> subMap = cardMap.get(suit);
            for (Card.Ranks rank: Card.Ranks.values()) {
                Assert.assertEquals((Integer) 1, subMap.get(rank));
            }
        }

    }

    @Test
    public void testDeckNotContainDealtCards() {
        Deck deck = new Deck();
        Card dealtCard = deck.dealCard();
        List<Card> remainCards = deck.getDeckOfCards();
        boolean containDealtCard = remainCards.contains(dealtCard);
        assertFalse(containDealtCard);
    }

    @Test
    public void testNumberOfLeftCardsAfterOneDeal() {
        Deck deck = new Deck();
        deck.dealCard();
        Assert.assertEquals(51, deck.numberOfLeftCards());
    }

    @Test(expected = IllegalStateException.class)
    public void testDealCardThrowIllegalStateException(){
        Deck deck = new Deck();
        for (int dealNum = 52; dealNum > 0; dealNum --) {
            deck.dealCard();
        }

        deck.dealCard();
    }

    @Test
    public void testGetDeckOfCards_GetTheCopyOfCardsAndTheOriginalCardListNotChanged() {
        Deck deck = new Deck();
        List<Card> returnCardList = deck.getDeckOfCards();
        returnCardList.remove(2);
        Assert.assertEquals(52, deck.numberOfLeftCards());
    }

}
