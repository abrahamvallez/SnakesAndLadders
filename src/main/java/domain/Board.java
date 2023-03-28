package domain;

public class Board {
  private int size;
  
  public Board(int size) {
    this.size = size;
  }

  public boolean isOnEnd(int position) {
    return position >= this.size;
  }
}
