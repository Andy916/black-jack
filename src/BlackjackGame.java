import java.util.Scanner;
public class BlackjackGame {
    public static void main (String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        Scanner scanner = new Scanner(System.in);
        String playerStatus = "standing";
        String dealerStatus = "standing";
        clearScreen();
        System.out.println("Welcome to Blackjack!\n");

        // deal two cards to player hand
        playerHand.addCard(deck.draw());
        playerHand.addCard(deck.draw());
        // deal two cards to dealer hand (one hidden)
        dealerHand.addCard(deck.draw());
        dealerHand.addCard(new Card("Hidden", "?", 0));

        // show hands
        printGame(dealerHand, playerHand);

        // player turn (either they started with blackjack or didn't)
        if (playerHand.getPointTotal() < 21) {
            System.out.println("Would you like to (h)it or (s)tand?");
            String choice = scanner.nextLine();
            System.out.println();
            while (choice.equals("h")) {
                playerHand.addCard(deck.draw());
                clearScreen();
                printGame(dealerHand, playerHand);
                if (playerHand.getPointTotal() > 21) {
                    System.out.println("You have busted! Dealer's turn.\n");
                    playerStatus = "busted";

                    dealerTurn(deck, dealerHand, playerHand);
                    break;
                }
                System.out.println("Would you like to (h)it or (s)tand?");
                choice = scanner.nextLine();
                System.out.println();
            }
            // if the loop ended because the player stood (or chose not to hit),
            // and the player hasn't busted, it's the dealer's turn now
            if (!playerStatus.equals("busted") && playerHand.getPointTotal() <= 21) {
                System.out.println("Player stands. Dealer's turn.\n");
                dealerTurn(deck, dealerHand, playerHand);
            }
        }
        else {
            System.out.println("Blackjack! Dealer's turn.\n");
            playerStatus = "blackjack";
            dealerTurn(deck, dealerHand, playerHand);
        }

        // determine winner
        determineWinner(playerHand, dealerHand, playerStatus, dealerStatus);
        scanner.close();
    }

    // methods
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void dealerTurn(Deck deck, Hand dealerHand, Hand playerHand) {
        System.out.println("Dealer's Turn:\n");
        // reveal dealer's hidden card
        dealerHand.revealHiddenCard(deck.draw());
        printGame(dealerHand, playerHand);

        // dealer stands on 17 or higher
        while (dealerHand.getPointTotal() < 17) {
            System.out.println("Dealer hits.\n");
            dealerHand.addCard(deck.draw());
            printGame(dealerHand, playerHand);
        }

        // check if dealer busted or stands
        if (dealerHand.getPointTotal() > 21) {
            System.out.println("Dealer has busted!\n");
        }
        else {
            System.out.println("Dealer stands.\n");
        }
    }

    public static void printGame(Hand dealerHand, Hand playerHand) {
        System.out.println("----------------------------");
        System.out.println("Dealer's Hand: ");
        System.out.println(dealerHand);
        System.out.println();
        System.out.println("Player's Hand: ");
        System.out.println(playerHand);
        System.out.println("----------------------------\n");
    }

    public static void determineWinner(Hand playerHand, Hand dealerHand, String playerStatus, String dealerStatus) {
        int playerTotal = playerHand.getPointTotal();
        int dealerTotal = dealerHand.getPointTotal();

        System.out.println("Final Results:\n");
        printGame(dealerHand, playerHand);

        if (playerStatus.equals("busted")) {
            System.out.println("Dealer wins!");
        }
        else if (dealerTotal > 21) {
            System.out.println("Player wins!");
        }
        else if (playerTotal > dealerTotal) {
            System.out.println("Player wins!");
        }
        else if (dealerTotal > playerTotal) {
            System.out.println("Dealer wins!");
        }
        else {
            System.out.println("It's a tie!");
        }
        System.out.println();
    }
}
