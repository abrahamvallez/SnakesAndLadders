import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PlayerTest {
  @Test
  public void shouldSetPositionTo0() {
    Player player = new Player();
    assertEquals(0, player.getPosition());
  }

  @Test
  public void shouldMovePlayerToNewPosition() {
    Player player = new Player();
    player.moveTo(3);
    assertEquals(3, player.getPosition());
  }
  
}
