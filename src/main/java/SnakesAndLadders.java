class SnakesAndLadders {
    public static void main(String[] args) {
      Player[] players = new Player[2];
      Dice dice = new Dice();
      Board board = new Board(100);

      players[0] = new Player();
      players[1] = new Player();
      System.out.println("Start Game");

      Game game = new Game(board, players, dice);
      game.start();
    }
}