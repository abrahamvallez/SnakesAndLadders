package ui;
import java.util.List;

import domain.Player;
import domain.Board.SnakesAndLaddersBoard;
import domain.Board.Square.Square;
import ui.Colour.Colour;

public class PromptPrinter {

  public void printWelcomeMessage() {
    System.out.println(Colour.GREEN+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println();
    System.out.println("----------------------GAME OF LADDERS AND SNAKES-----------------------");
    System.out.println("_________The ladders will be shown by # and the snakkers by g__________"+ Colour.ANSI_RESET);
  }

  public void printHowManyPlayers() {
    System.out.println();
    System.out.println(Colour.YELLOW+"          ---¿How many players are you going to play?---"+ Colour.ANSI_RESET);
    System.out.println();
  }

  public void printError(String errorMessage) {
    System.out.println(Colour.RED+errorMessage+ Colour.ANSI_RESET);
  }

  public void printWinner(Player winner) {
    System.out.println("There is a winner!: ");
    System.out.println();
  }

  public void printBoardWithPlayers(SnakesAndLaddersBoard board, List<Player> players) {
  }
}
