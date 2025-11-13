import java.util.ArrayList;
import java.util.Collections;
public class Deck {
    // fields
    private ArrayList<Card> cards;
    
    // constructor
    public Deck() {
        cards = new ArrayList<Card>();

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] pointValues = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

        for (String suit: suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(ranks[i], suit, pointValues[i]));
            }
        }
    }

    // methods
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(cards.size() - 1);
    }
}
