import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class BoardTest {
  @Test
  public void shouldReturnTrueIfPlayerIsOnEnd() {
    Board board = new Board(10);
    assertTrue(board.isOnEnd(10));
  }
  
  @Test
  public void shouldReturnFalseIfPlayerIsNotOnEnd() {
    Board board = new Board(10);
    assertFalse(board.isOnEnd(9));
  }
  
}
