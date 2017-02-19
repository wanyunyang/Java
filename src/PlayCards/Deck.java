package PlayCards;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
    private List<Card> cardList;

    //Constructor to create a new deck of cards
    public Deck() {
        cardList = new ArrayList<>();
        for (Card.Suits suit: Card.Suits.values()) {
            for (Card.Ranks rank: Card.Ranks.values()) {
                cardList.add(new Card(suit, rank));
            }
        }
        //Shuffle the cards to make them always different when generate a new deck
        shuffle();
    }

    //Shuffle cards
    public void shuffle() {
        Collections.shuffle(this.cardList);
    }

    //Deal cards
    //Throw exception, if no cards on the deck, i.e. the deck is empty
    public Card dealCard(){
        if (numberOfLeftCards() == 0) {
            throw new IllegalStateException("No card is left on the deck! Can't deal cards anymore!");
        }
        Card dealtCard = cardList.get(cardList.size() - 1);
        cardList.remove(cardList.size() - 1);
        return dealtCard;
    }

    //Track the number of cards left on the deck
    public int numberOfLeftCards(){
        return cardList.size();
    }

    //Get the copy of the cardList to avoid external change to the cardList object
    public List<Card> getDeckOfCards() {
        List<Card> cardListCopy = new ArrayList<>();
        for (Card card : cardList) {
            cardListCopy.add(new Card(card));
        }
        return cardListCopy;
    }

    //Reset the deck
    public Deck reset(){
        return new Deck();
    }
}
