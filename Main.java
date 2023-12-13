public class Main {
    public static void main(String[] args) {
        int numPlayers = 2; // Set the number of players
        GameController game = new GameController(numPlayers);

        // Run the game loop until the game is over
        while (game.isGameOver() == false) {
            game.playTurn();
            // Add any additional logic or UI updates here if needed
        }
    }
}

