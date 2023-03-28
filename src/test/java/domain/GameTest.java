package domain;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import domain.Board.SnakesAndLaddersBoard;
import domain.Board.SnakesAndLaddersBoardMock;

public class GameTest {
  private Game game;
  private List<Player> players;
  private Dice dice;

  @BeforeEach
  public void setUp() {
    SnakesAndLaddersBoard board = new SnakesAndLaddersBoardMock();
    this.players = new ArrayList<Player>();
    this.players.add(new Player());
    this.players.add(new Player());
    this.dice = Mockito.mock(Dice.class);
    this.game = new Game(board, this.players, this.dice);
  }

  @Test
  public void shouldPlaceTokensOnBoardInPosition1WhenStartGame() {
    this.game.start();
    assertEquals(1, this.players.get(0).getPosition());
  }

  @Test
  public void shouldMovePlayerToNewPositionWhenMovePlayer() {
    Mockito.when(this.dice.roll()).thenReturn(2);
    this.game.start();
    this.game.movePlayer(this.players.get(0));

    assertEquals(3, this.players.get(0).getPosition());
  }

  @Test
  public void shouldMovePlayerToNewPositionWhenMovePlayerTwice() {
    Mockito.when(this.dice.roll()).thenReturn(1, 2);
    this.game.start();
    this.game.movePlayer(this.players.get(0));
    this.game.movePlayer(this.players.get(0));

    assertEquals(4, this.players.get(0).getPosition());
  }

  @Test
  public void shouldMovePlayerToCorrectPositionWhenIsInLadderSquare() {
    Mockito.when(this.dice.roll()).thenReturn(4);
    this.game.start();
    this.game.movePlayer(this.players.get(0));

    assertEquals(15, this.players.get(0).getPosition());
  } 

  @Test
  public void shouldMovePlayerToCorrectPositionWhenIsInSnakeSquare() {
    Mockito.when(this.dice.roll()).thenReturn(5, 4);
    this.game.start();
    this.game.movePlayer(this.players.get(0));
    this.game.movePlayer(this.players.get(0));


    assertEquals(5, this.players.get(0).getPosition());
  }

  @Test
  public void shouldFinishGameWithWinnerWhenPlayerIsIn100() {
    Mockito.when(this.dice.roll()).thenReturn(96, 3);
    this.game.start();
    this.game.movePlayer(this.players.get(0));
    this.game.movePlayer(this.players.get(0));
    
    assertEquals(this.players.get(0), game.hasWinner());
  }

  @Test
  public void shouldFinishGameWithWinnerWhenPlayerIsOver100() {
    Mockito.when(this.dice.roll()).thenReturn(96, 4);
    this.game.start();
    this.game.movePlayer(this.players.get(0));
    this.game.movePlayer(this.players.get(0));

    assertEquals(this.players.get(0), game.hasWinner());
  }

  @Test
  public void shouldNotFinishGameWithWinnerWhenPlayerIsUnder100() {
    Mockito.when(this.dice.roll()).thenReturn(96, 2);
    this.game.start();
    this.game.movePlayer(this.players.get(0));
    this.game.movePlayer(this.players.get(0));

    assertEquals(null, game.hasWinner());
  }

  @Test
  public void shouldReturnPlayersPlaying() {
    assertEquals(this.players, this.game.getPlayers());
  }
}
