package domain;

import java.util.List;

public class Game {
  private Board board;
  private List<Player> players;
  private Player winner = null;
  private Dice dice;
  public static final int MIN_PLAYERS = 2;

  public Game(Board board, List<Player> players, Dice dice) {
    this.board = board;
    if (players.size() < 2)
      throw new IllegalArgumentException("The game must have at least 2 players");
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

  public List<Player> getPlayers() {
    return this.players;
  }

  public Player hasWinner() {
    return this.winner;
  }
}
