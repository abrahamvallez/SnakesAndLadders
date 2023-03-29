package domain.Board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

import domain.Board.Square.LadderSquare;
import domain.Board.Square.Square;

public class LadderSquareTest {

  @Test
  public void shouldLaunchExceptionIfSquareNumberIsHigherThanGoToSquare() {
    Square goToSquare = new Square(5);
    assertThrowsExactly(IllegalArgumentException.class, () -> new LadderSquare(15, goToSquare));
  }

  @Test
  public void shouldGetGoToSquare() {
    Square goToSquare = new Square(5);
    LadderSquare square = new LadderSquare(1, goToSquare);
    assertEquals(goToSquare, square.getGotoSquare());
  }
}
