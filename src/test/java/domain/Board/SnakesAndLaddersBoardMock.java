package domain.Board;

import domain.Board.Square.LadderSquare;
import domain.Board.Square.SnakeSquare;

public class SnakesAndLaddersBoardMock extends SnakesAndLaddersBoard {
  public SnakesAndLaddersBoardMock() {
    super();
  } 

  @Override
  protected void loadSnakesSquares() {
    this.squares.set(9, new SnakeSquare(10, this.getSquare(5)));
  }

  @Override
  protected void loadLaddersSquares() {
    this.squares.set(4, new LadderSquare(5, this.getSquare(15)));
  }
}
