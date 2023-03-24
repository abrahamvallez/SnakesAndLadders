public class Board {
  private int size;
  
  Board(int size) {
    this.size = size;
  }

  public boolean isOnEnd(int position) {
    return position >= this.size;
  }
}
