import java.util.ArrayList;
public class Hand {
    // fields
    private ArrayList<Card> cards;

    // constructor
    public Hand() {
        cards = new ArrayList<Card>();
    }

    // methods
    public void addCard(Card card) {
        cards.add(card);
    }

    public int getPointTotal() {
        int total = 0;
        for (Card card : cards) {
            total += card.getPointValue();
        }
        return total;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString()).append("\n");
        }
        return sb.toString() + 
               "Total Points: " + getPointTotal() + "\n";
    }
}
