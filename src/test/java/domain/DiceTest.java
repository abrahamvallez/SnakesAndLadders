package domain;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DiceTest {
  @Test
  public void shouldReturnRandomNumberBetween1And6() {
    Dice dice = new Dice();
    int result = dice.roll();
    assertTrue(result >= 1 && result <= 6);
  }
}
