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

    // getters and setters
    public String getRank() {
        return rank;
    }
    public String getSuit() {
        return suit;
    }
    public int getPointValue() {
        return pointValue;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }
    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    // other methods

}
