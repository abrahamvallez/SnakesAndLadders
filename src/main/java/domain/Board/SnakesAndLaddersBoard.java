package domain.Board;

import java.util.ArrayList;
import java.util.List;

import domain.Board.Square.LadderSquare;
import domain.Board.Square.SnakeSquare;
import domain.Board.Square.Square;

public class SnakesAndLaddersBoard {
  private int size;
  protected List<Square> squares = new ArrayList<Square>(); 
  
  public SnakesAndLaddersBoard() {
    this.size = 100;
    this.loadSquares();
    this.loadLaddersSquares();
    this.loadSnakesSquares();
  }

  public int getSize() {
    return this.size;
  }

  public Square getSquare(int position) {
    if (position > this.size)
      return this.squares.get(this.size - 1);
    return this.squares.get(position - 1);
  }

  public boolean isOnEnd(int position) {
    return position >= this.size;
  }

  private void loadSquares() {
    for (int i = 1; i <= this.getSize(); i++) {
      this.squares.add(new Square(i));
    }
  }
  
  //Load snakes at square 16, 46, 49, 62, 64, 74, 89, 92, 95, 99
  protected void loadSnakesSquares() {
    this.squares.set(15, new SnakeSquare(16, this.squares.get(5)));
    this.squares.set(45, new SnakeSquare(46, this.squares.get(25)));
    this.squares.set(48, new SnakeSquare(49, this.squares.get(11)));
    this.squares.set(61, new SnakeSquare(62, this.squares.get(19)));
    this.squares.set(63, new SnakeSquare(64, this.squares.get(60)));
    this.squares.set(73, new SnakeSquare(74, this.squares.get(53)));
    this.squares.set(88, new SnakeSquare(89, this.squares.get(68)));
    this.squares.set(91, new SnakeSquare(92, this.squares.get(88)));
    this.squares.set(94, new SnakeSquare(95, this.squares.get(75)));
    this.squares.set(98, new SnakeSquare(99, this.squares.get(78)));
  }

  //load ladders at square 1, 4, 9, 21, 28, 51, 71, 80
  protected void loadLaddersSquares() {
    this.squares.set(0, new LadderSquare(1, this.squares.get(38)));
    this.squares.set(3, new LadderSquare(4, this.squares.get(14)));
    this.squares.set(8, new LadderSquare(9, this.squares.get(31)));
    this.squares.set(20, new LadderSquare(21, this.squares.get(42)));
    this.squares.set(27, new LadderSquare(28, this.squares.get(84)));
    this.squares.set(50, new LadderSquare(51, this.squares.get(67)));
    this.squares.set(70, new LadderSquare(71, this.squares.get(91)));
    this.squares.set(79, new LadderSquare(80, this.squares.get(99)));
  }
}
