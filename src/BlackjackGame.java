import java.util.Scanner;
public class BlackjackGame {
    public static void main (String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        Scanner scanner = new Scanner(System.in);
        String playerStatus = "playing";
        String dealerStatus = "playing";
        clearScreen();
        System.out.println("Welcome to Blackjack!\n");

        // deal two cards to player hand
        playerHand.addCard(deck.draw());
        playerHand.addCard(deck.draw());
        // deal two cards to dealer hand (one hidden)
        dealerHand.addCard(deck.draw());
        dealerHand.addCard(new Card("Hidden", "?", 0));

        // show hands
        System.out.println("Dealer's Hand:");
        System.out.println(dealerHand);

        System.out.println("Player's Hand:");
        System.out.println(playerHand);

        // player turn
        if (playerHand.getPointTotal() < 21) {
            System.out.println("Would you like to (h)it or (s)tand?");
            String choice = scanner.nextLine();
            while (choice.equals("h")) {
                playerHand.addCard(deck.draw());
                clearScreen();
                System.out.println("Dealer's Hand:");
                System.out.println(dealerHand);
                System.out.println("Player's Hand:");
                System.out.println(playerHand);
                if (playerHand.getPointTotal() > 21) {
                    System.out.println("You have busted! Dealer's turn.");
                    playerStatus = "busted";

                    // dealer turn
                    break;
                }
                System.out.println("Would you like to (h)it or (s)tand?");
                choice = scanner.nextLine();
            }
        }
        else {
            System.out.println("Blackjack! Dealer's turn.");
            playerStatus = "blackjack";

            // dealer turn
        }

    }

    // methods
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
