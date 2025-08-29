public interface Game {
    void start();
    void playTurn();
    boolean isGameOver();
    Player getWinner();  
}
