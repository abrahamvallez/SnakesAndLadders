public class Player {
  private int position;

  Player() {
    this.position = 0;
  }

  public int moveTo(int position) {
    this.position = position;
    return this.position;
  }

  public int getPosition() {
    return this.position;
  }
}
