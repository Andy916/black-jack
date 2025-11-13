public class BlackjackGame {
    public static void main (String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        clearScreen();
        System.out.println("Welcome to Blackjack!\n");

        // deal two cards to player hand
        playerHand.addCard(deck.draw());
        playerHand.addCard(deck.draw());
        // deal two cards to dealer hand
        dealerHand.addCard(deck.draw());
        dealerHand.addCard(deck.draw());

        // show hands
        System.out.println("Dealer's Hand:");
        System.out.println(dealerHand);

        System.out.println("Player's Hand:");
        System.out.println(playerHand);
        
    }

    // methods
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
