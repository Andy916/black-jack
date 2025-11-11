public class App {
    public static void main (String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        // print deck
        for (Card card : deck.getCards()) {
            System.out.println(card.getRank() + " of " + card.getSuit() + " (Point Value: " + card.getPointValue() + ")");
        }
    }
}