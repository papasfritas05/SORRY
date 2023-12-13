public class Board {
    private int[] positions; // Array to store positions of pieces
    private int[] safeSpots; // Array to store safe spots

    public Board(int numPlayers) {
        positions = new int[numPlayers];
        // Initialize positions for each player
        for (int i = 0; i < numPlayers; i++) {
            positions[i] = 0; // Starting position for each player
        }

        // Define safe spots where pieces can't be sent back to start
        safeSpots = new int[]{5, 12, 18, 25}; // Define the safe spots
    }

    public int movePlayer(int playerId, int steps) {
        int currentPosition = positions[playerId];
        int newPosition = currentPosition + steps;

        // Check for collisions or moves beyond the board size
        if (newPosition >= 28) {
            // Handle reaching the end or going around the board
            newPosition -= 28; // Wrap around the board
        }
        if (newPosition == 5 || newPosition == 12 || newPosition == 18 || newPosition == 25) {
            // Handle collisions with pieces
            int pieceId = (newPosition - 1) / 4; // Determine which piece is colliding
            int piecePosition = positions[pieceId];
            if (piecePosition == newPosition) {
                // Handle collision with piece
                System.out.println("Player " + (playerId + 1) + " collides with piece " +
                                   (pieceId + 1) + " at position " + piecePosition);
                return piecePosition; // Return the position
                // Handle collision with piece
            }
        }
        // Check for safe spots
        if (isSafeSpot(newPosition)) {
            // Player reached a safe spot, don't move back to start
            positions[playerId] = newPosition;
            return newPosition;
        }

        // If not a safe spot, move the player back to start
        positions[playerId] = 0; // Move player back to start
        return 0; // Return start position
    }
    public int WINNING_POSITION = 28;

    private boolean isSafeSpot(int position) {
        for (int spot : safeSpots) {
            if (position == spot) {
                return true;
            }
        }
        return false;
    }

    // Other methods to check for collisions, get player positions, etc.
}

