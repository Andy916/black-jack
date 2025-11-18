import java.util.Scanner;
public class BlackjackGame {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerWins = 0;
        int dealerWins = 0;
        while (true) {
            Deck deck = new Deck();
            deck.shuffle();
            Hand playerHand = new Hand();
            Hand dealerHand = new Hand();
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
                System.out.println("Would you like to hit or stand?\n('h' to hit, any other key to stand, then press Enter)");
                String choice = scanner.nextLine();
                System.out.println();
                while (choice.equals("h")) {
                    playerHand.addCard(deck.draw());
                    clearScreen();
                    System.out.println("Player hits.\n");
                    printGame(dealerHand, playerHand);
                    if (playerHand.getPointTotal() > 21) {
                        System.out.println("You have busted! Dealer's turn.\n");
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        dealerTurn(deck, dealerHand, playerHand, scanner);
                        break;
                    }
                    System.out.println("Would you like to hit or stand?\n(h to hit, any other key to stand, then press Enter)");
                    choice = scanner.nextLine();
                    System.out.println();
                }
                // if the loop ended because the player stood (or chose not to hit),
                // and the player hasn't busted, it's the dealer's turn now
                if (playerHand.getPointTotal() <= 21) {
                    clearScreen();
                    System.out.println("Player stands. Dealer's turn.\n");
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    dealerTurn(deck, dealerHand, playerHand, scanner);
                }
            }
            else {
                System.out.println("Blackjack! Dealer's turn.\n");
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
                dealerTurn(deck, dealerHand, playerHand, scanner);
            }
            
            System.out.println("Press Enter to see the results...");
            scanner.nextLine();

            // determine winner
            String winner = determineWinner(playerHand, dealerHand);
            if (winner.equals("player")) {
                playerWins++;
            } else if (winner.equals("dealer")) {
                dealerWins++;
            }
            System.out.println();
            System.out.println("Scoreboard: Player " + playerWins + " - Dealer " + dealerWins);
            System.out.println();

            // ask to play again
            System.out.println("Would you like to play again?\n(y for yes, any other key for no, then press Enter)");
            String playAgain = scanner.nextLine();
            if (!playAgain.equals("y")) {
                System.out.println("Thanks for playing!");
                break;
            }
            System.out.println("\n\n\n\n");
        }
        scanner.close();
    }

    // methods
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void dealerTurn(Deck deck, Hand dealerHand, Hand playerHand, Scanner scanner) {
        clearScreen();
        System.out.println("Dealer reveals hidden card.\n");
        // reveal dealer's hidden card
        dealerHand.revealHiddenCard(deck.draw());
        printGame(dealerHand, playerHand);
        System.out.println("Press Enter to continue...");
        scanner.nextLine();

        // dealer stands on 17 or higher
        while (dealerHand.getPointTotal() < 17) {
            clearScreen();
            System.out.println("Dealer hits.\n");
            dealerHand.addCard(deck.draw());
            printGame(dealerHand, playerHand);
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
        }

        // check if dealer busted or stands
        if (dealerHand.getPointTotal() > 21) {
            clearScreen();
            System.out.println("Dealer has busted!\n");
        }
        else {
            clearScreen();
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

    public static String determineWinner(Hand playerHand, Hand dealerHand) {
        int playerTotal = playerHand.getPointTotal();
        int dealerTotal = dealerHand.getPointTotal();

        clearScreen();
        System.out.println("Final Results:\n");
        printGame(dealerHand, playerHand);

        if (playerTotal > 21 && dealerTotal > 21) {
            System.out.println("Both busted! It's a tie!");
            return "tie";
        } else if (playerTotal > 21) {
            System.out.println("Dealer wins!");
            return "dealer";
        } else if (dealerTotal > 21) {
            System.out.println("Player wins!");
            return "player";
        } else if (playerTotal > dealerTotal) {
            System.out.println("Player wins!");
            return "player";
        } else if (dealerTotal > playerTotal) {
            System.out.println("Dealer wins!");
            return "dealer";
        } else {
            System.out.println("It's a tie!");
            return "tie";
        }
    }
}