package domain.Board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

import domain.Board.Square.SnakeSquare;
import domain.Board.Square.Square;

public class SnakeSquareTest {

  @Test
  public void shouldLaunchExceptionIfSquareNumberIsLowerThanGoToSquare() {
    Square goToSquare = new Square(5);
    assertThrowsExactly(IllegalArgumentException.class, () -> new SnakeSquare(1, goToSquare));
  }
  
  @Test
  public void shouldGetGoToSquare() {
    Square goToSquare = new Square(5);
    SnakeSquare square = new SnakeSquare(10, goToSquare);
    assertEquals(goToSquare, square.getGotoSquare());
  }  
}
