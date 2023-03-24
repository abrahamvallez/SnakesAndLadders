import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameTest {
  private Game game;
  private Player[] players;
  private Dice dice;

  @BeforeEach
  public void setUp() {
    Board board = new Board(100);
    this.players = new Player[2];
    this.players[0] = new Player();
    this.players[1] = new Player();
    this.dice = Mockito.mock(Dice.class);
    this.game = new Game(board, this.players, this.dice);
  }

  @Test
  public void shouldPlaceTokensOnBoardInPosition1WhenStartGame() {
    this.game.start();
    assertEquals(1, this.players[0].getPosition());
  }

  @Test
  public void shouldMovePlayerToNewPositionWhenMovePlayer() {
    Mockito.when(this.dice.roll()).thenReturn(3);
    this.game.start();
    this.game.movePlayer(this.players[0]);

    assertEquals(4, this.players[0].getPosition());
  }

  @Test
  public void shouldMovePlayerToNewPositionWhenMovePlayerTwice() {
    Mockito.when(this.dice.roll()).thenReturn(3, 4);
    this.game.start();
    this.game.movePlayer(this.players[0]);
    this.game.movePlayer(this.players[0]);

    assertEquals(8, this.players[0].getPosition());
  }

  @Test
  public void shouldFinishGameWithWinnerWhenPlayerIsIn100() {
    Mockito.when(this.dice.roll()).thenReturn(96, 3);
    this.game.start();
    this.game.movePlayer(this.players[0]);
    this.game.movePlayer(this.players[0]);
    
    assertEquals(this.players[0], game.hasWinner());
  }

  @Test
  public void shouldFinishGameWithWinnerWhenPlayerIsOver100() {
    Mockito.when(this.dice.roll()).thenReturn(96, 4);
    this.game.start();
    this.game.movePlayer(this.players[0]);
    this.game.movePlayer(this.players[0]);

    assertEquals(this.players[0], game.hasWinner());
  }
}
