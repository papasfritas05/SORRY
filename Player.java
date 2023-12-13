public class Player {
    private int id;
    private int currentPosition;

    public Player(int id) {
        this.id = id;
        this.currentPosition = 0; // Starting position
    }

    public int getId() {
        return id;
    }

    public static int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int newPosition) {
        this.currentPosition = newPosition;
    }

    // Other methods related to player actions, if needed
}

