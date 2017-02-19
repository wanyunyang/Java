package PlayCards;


public class Card {
    public enum Suits {
        SPADES,
        HEARTS,
        DIAMONDS,
        CLUBS;
    }

    public enum Ranks {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE;
    }

    private Suits suit;
    private Ranks rank;

    //Regular constructor
    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    //Copy constructor
    public Card(Card otherCard) {
        this.suit = otherCard.suit;
        this.rank = otherCard.rank;
    }

    public Suits getSuit() {
        return this.suit;
    }

    public Ranks getRank() {
        return this.rank;
    }

}
