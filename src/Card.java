public class Card {
    // fields
    private String rank;
    private String suit;
    private int pointValue;
    
    // constructor
    public Card(String rank, String suit, int pointValue) {
        this.rank = rank;
        this.suit = suit;
        this.pointValue = pointValue;
    }

    // methods
    public String getRank() {
        return rank;
    }
    public String getSuit() {
        return suit;
    }
    public int getPointValue() {
        return pointValue;
    }
    public String toString() {
        return rank + " of " + suit + " (" + pointValue + " points)";
    }
}
