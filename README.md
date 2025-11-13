# Blackjack (In Development)

Simulates blackjack in the console using Java.

## Current Progress
- Implemented `Card` class with rank, suit, and point value fields, along with getters and a `toString()` method.
- Created `Deck` class with:
  - Full 52-card initialization using nested loops.
  - `shuffle()` method using `Collections.shuffle()` for efficient randomization.
- Verified deck creation and shuffling through test output.
- Implemented `draw()` method in `Deck` to deal cards.
- Built `Hand` class to manage player and dealer hands, including a `toString()` that leverages `Card`’s `toString()` for readable output.
- Initialized player and dealer starting hands.
- Integrated `clearScreen()` method for smoother console output between turns.
- Added `getPointTotal()` method in `Hand` to calculate the total value of cards.

## Next Steps
- Continue building game loop logic in the `BlackjackGame` class.
- Implement win/loss condition checks (player bust, dealer bust, blackjack).
- Improve output formatting for readability (hands + totals).

## Installation

```bash
git clone https://github.com/Andy916/black-jack.git
cd black-jack
javac -d bin src/*.java
java -cp bin BlackjackGame
```
