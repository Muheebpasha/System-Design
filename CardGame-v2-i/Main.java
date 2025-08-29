class Main {
    public static void main(String[] args) {
        Game cardGame = new CardGame(4); // Example with 4 players
        GameLoop gameLoop = new GameLoop(cardGame);
        gameLoop.start();
    }
}
