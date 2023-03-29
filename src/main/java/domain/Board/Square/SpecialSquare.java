package domain.Board.Square;

public abstract class SpecialSquare extends Square {
  private Square gotoSquare;

  public SpecialSquare(int squareNumber, Square gotoSquare) {
    super(squareNumber);
    this.gotoSquare = gotoSquare;
  }

  public Square getGotoSquare() {
    return this.gotoSquare;
  }
}
