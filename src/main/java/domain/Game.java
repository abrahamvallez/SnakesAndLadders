package domain;

import java.util.List;

import domain.Board.SnakesAndLaddersBoard;
import domain.Board.Square.SpecialSquare;
import domain.Board.Square.Square;

public class Game {
  private SnakesAndLaddersBoard board;
  private List<Player> players;
  private Player winner = null;
  private Dice dice;
  public static final int MIN_PLAYERS = 2;

  public Game(SnakesAndLaddersBoard board, List<Player> players, Dice dice) {
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
    Square square = this.board.getSquare(newPosition);

    if (isSpecialSquare(square)) {
      SpecialSquare specialSquare = (SpecialSquare) square;
      newPosition = player.moveTo(specialSquare.getGotoSquare().getSquareNumber());
    }

    player.moveTo(newPosition);

    if (isWinPosition(newPosition)) {
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

  private boolean isWinPosition(int newPosition) {
    return this.board.isOnEnd(newPosition);
  }

  private boolean isSpecialSquare(Square square) {
    return square instanceof SpecialSquare;
  }
}
