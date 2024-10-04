public class Node {
  char letter;
  Node dot;
  Node dash;

  public Node(char letter) {
    this.letter = letter;
    this.dot = null;
    this.dash = null;
  }
}