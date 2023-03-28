
import domain.Dice;
import domain.Game;
import domain.Player;
import domain.Board.SnakesAndLaddersBoard;
import ui.PromptPrinter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class SnakesAndLadders {
  static PromptPrinter promptPrinter = new PromptPrinter();
  static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    PromptPrinter promptPrinter = new PromptPrinter();
    promptPrinter.printWelcomeMessage();
    int numPlayers = getPlayers();
    Game game = createGame(numPlayers);
    play(game);
    promptPrinter.printWinner(game.hasWinner());
    scanner.close();
  }

  private static void play(Game game) {
    game.start();
    List<Player>players;
    players = game.getPlayers();
    int turn = 0;
    while (game.hasWinner() != null) {
      game.movePlayer(players.get(turn));
      //TODO: print board
      turn = switchTurn(players, turn);
    }
  }

  private static int switchTurn(List<Player> players, int turn) {
    if(turn == players.size()-1){
      turn = 0;
    }else{
      turn++;
    }
    return turn;
  }

  static private Game createGame(int num) {
    List<Player> players = createPlayers(num);
    Dice dice = new Dice();
    SnakesAndLaddersBoard board = new SnakesAndLaddersBoard();

    return new Game(board, players, dice);  
  }

  static private List<Player> createPlayers(int numPlayers){
    List<Player> players = new ArrayList<Player>();
    for(int i = 0; i < numPlayers; i++)
      players.add(new Player());
    return players;
  }

  static private int getPlayers(){
    promptPrinter.printHowManyPlayers();
    int numPlayers = 0;
    try {
      numPlayers = scanner.nextInt();
    } catch (InputMismatchException exception) {
      promptPrinter.printError("Introduce a number");
      scanner.nextLine();
      return getPlayers();
    }
    if( numPlayers < Game.MIN_PLAYERS){
      promptPrinter.printError("The game must have at least 2 players");
      return getPlayers();
    }
    return numPlayers;
  }
}