public class Game {
  private Board board;
  private Player[] players;
  private Player winner = null;
  private Dice dice;

  Game(Board board, Player[] players, Dice dice) {
    this.board = board;
    this.players = players;
    this.dice = dice;
  }

  public void start() {
    for (Player player : this.players) {
      player.moveTo(1);
    }
  }

  public int movePlayer(Player player) {
    int newPosition = player.getPosition() + this.dice.roll();
    player.moveTo(newPosition);
    if (this.board.isOnEnd(newPosition)) {
      this.winner = player;
    }
      
    return newPosition;
  }

  public Player hasWinner() {
    return this.winner;
  }
}
