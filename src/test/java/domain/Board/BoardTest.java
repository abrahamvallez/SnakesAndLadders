package domain.Board;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import domain.Board.Square.Square;

public class BoardTest {
  @Test
  public void shouldReturnTrueIfPlayerIsOnEnd() {
    SnakesAndLaddersBoard board = new SnakesAndLaddersBoard();
    assertTrue(board.isOnEnd(100));
  }
  
  @Test
  public void shouldReturnFalseIfPlayerIsNotOnEnd() {
    SnakesAndLaddersBoard board = new SnakesAndLaddersBoard();
    assertFalse(board.isOnEnd(9));
  }

  @Test
  public void shouldGetSquare() {
    SnakesAndLaddersBoard board = new SnakesAndLaddersBoard();
    Square square = board.getSquare(5);
    assertEquals(5, square.getSquareNumber());
  }
  
}
