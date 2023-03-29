package domain.Board.Square;

public class SnakeSquare extends SpecialSquare {
    public SnakeSquare(int squareNumber, Square gotoSquare) {
      super(squareNumber, gotoSquare);
      if (squareNumber <= gotoSquare.getSquareNumber())
        throw new IllegalArgumentException("SnakeSquare must have a lower squareNumber than gotoSquare");
    }
}
