# Blackjack

A console-based Blackjack game built in Java. Play against the dealer following standard Blackjack rules with a persistent scoreboard across multiple rounds.

## ✨ Features

- Full 52-card deck with shuffling
- Player vs Dealer gameplay
- Standard Blackjack rules (hit, stand, bust)
- Automatic dealer AI (stands on 17 or higher)
- Persistent win/loss scoreboard
- Multiple rounds support
- Clear console output between turns
- Input validation and user-friendly prompts
- Hidden dealer card mechanic

## 🎮 How to Play

1. You and the dealer each start with two cards
2. Your cards are visible, dealer shows only one card (one is hidden)
3. Choose to "hit" (draw a card) or "stand" (end your turn)
4. Try to get as close to 21 as possible without going over
5. Dealer automatically plays after you stand (must hit on 16 or below, stands on 17+)
6. Closest to 21 without busting wins!
7. Play multiple rounds and track your score against the dealer

## 📋 Prerequisites

- Java 17 or higher

## 🚀 Installation & Running

Clone the repository:
```bash
git clone https://github.com/Andy916/black-jack.git
cd black-jack
```

Compile the source files:
```bash
javac -d bin src/*.java
```

Run the game:
```bash
java -cp bin BlackjackGame
```

## 💻 Example Gameplay

```
----------------------------
Dealer's Hand: 
7 of Hearts (7 points)
Hidden of ? (0 points)
Total Points: 7

Player's Hand: 
King of Spades (10 points)
5 of Diamonds (5 points)
Total Points: 15
----------------------------

Would you like to hit or stand?
('h' to hit, any other key to stand, then press Enter)
```

## 📁 Project Structure

```
black-jack/
├── src/
│   ├── BlackjackGame.java    # Main game logic and user interface
│   ├── Card.java              # Card representation (rank, suit, point value)
│   ├── Deck.java              # 52-card deck with shuffle and draw methods
│   └── Hand.java              # Hand management for player and dealer
└── bin/                       # Compiled classes
```

## 🛠️ Technical Implementation

- Object-oriented design with separate classes for game components
- Efficient deck shuffling using Collections.shuffle()
- Dynamic point calculation with proper card value handling
- Clean separation of concerns between game logic and card management
- StringBuilder for efficient string concatenation in hand display
- Scanner-based user input with validation
- Console clearing for smooth gameplay experience

## 🎯 Game Rules

- Number cards (2-10) are worth their face value
- Face cards (Jack, Queen, King) are worth 10 points
- Aces are worth 11 points
- Player can hit as many times as desired until bust or stand
- Dealer must hit on 16 or below, must stand on 17 or above
- Going over 21 results in a bust (automatic loss)
- If both bust, it's a tie
- Scoreboard persists across multiple rounds

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
