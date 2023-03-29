package domain.Board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import domain.Board.Square.Square;

public class SquareTest {
  @Test
  public void shouldGetSquareNumber() {
    Square square = new Square(5);
    assertEquals(5, square.getSquareNumber());
  }
}