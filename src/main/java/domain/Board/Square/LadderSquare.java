package domain.Board.Square;

public class LadderSquare extends SpecialSquare {

  public LadderSquare(int squareNumber, Square gotoSquare) {
    super(squareNumber, gotoSquare);
    if (squareNumber >= gotoSquare.getSquareNumber())
      throw new IllegalArgumentException("LadderSquare must have a higher squareNumber than gotoSquare");
  }
}
