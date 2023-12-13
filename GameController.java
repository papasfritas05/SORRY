import java.util.Random;

public class GameController {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;
    private boolean gameOver;
    private Random dice;
    private int newPosition;

    public GameController(int numPlayers) {
        board = new Board(numPlayers);
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player(i + 1); // Player IDs start from 1
        }
        currentPlayerIndex = 0; // Start with the first player
        gameOver = false;
        dice = new Random();
    }
    public void displayPlayerPositions() {
        for (int i = 0; i < players.length; i++) {
            int position = Player.getCurrentPosition(i);
            System.out.println("Player " + (i + 1) + " is at position " + position);
        }
    }


    public void playTurn() {
        if (!gameOver) {
            Player currentPlayer = players[currentPlayerIndex];
            int diceRoll = rollDice();
            int newPosition = board.movePlayer(currentPlayer.getId() - 1, diceRoll);

            // Update player's position
            currentPlayer.setCurrentPosition(newPosition);

            // Check for win condition (e.g., reaching a certain position)
        /*       if (newPosition == Board.WINNING_POSITION) {
                gameOver = true;
                System.out.println("Player " + currentPlayer.getId() + " wins!");
            } 
            */

           isGameOver();

            // Move to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        } else {
            System.out.println("Game over!");
        }
    }
    public boolean isGameOver(){
            if (newPosition == 48) {
                gameOver = true;
                System.out.println("Player " + currentPlayerIndex.getId() + " wins!");
            }
        
    }
    

    private int rollDice() {
        return dice.nextInt(6) + 1; // Simulate a six-sided dice roll
    }

    // Other methods for managing game flow, handling UI interactions, etc.
}

