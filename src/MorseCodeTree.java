public class MorseCodeTree {
  private final Node root;

  public MorseCodeTree() {
    root = new Node(' ');
    buildTree();
  }

  private void buildTree() {
    insert(".", 'E'); insert("-", 'T');

    insert("..", 'I'); insert(".-", 'A');
    insert("-.", 'N'); insert("--", 'M');

    insert("---", 'O'); insert("...", 'S');
    insert("..-", 'U'); insert(".-.", 'R');
    insert(".--", 'W'); insert("-..", 'D');
    insert("-.-", 'K'); insert("--.", 'G');

    insert("....", 'H'); insert("...-", 'V');
    insert("..-.", 'F'); insert(".-..", 'L');
    insert(".--.", 'P'); insert(".---", 'J');
    insert("-...", 'B'); insert("-..-", 'X');
    insert("-.-.", 'C'); insert("--..", 'Z');
    insert("--.-", 'Q');
  }

  private void insert(String morseCode, char letter) {
    Node current = root;
    for (char c : morseCode.toCharArray()) {
      if (c == '.') {
        if (current.dot == null) current.dot = new Node(' ');
        current = current.dot;
      } else if (c == '-') {
        if (current.dash == null) {
          current.dash = new Node(' ');
        }
        current = current.dash;
      }
    }
    current.letter = letter;
  }

  public String decodePhrase(String morsePhrase) {
    String decodedPhrase = "";

    String[] morseSplitted = morsePhrase.split(" / ");

    for (String s : morseSplitted) {
      String decodedWord = this.decodeWord(s);

      decodedPhrase = decodedPhrase + " " + decodedWord;
    }

    return decodedPhrase;
  }

  public String decodeWord(String morseWord) {
    String decodedWord = "";

    String[] morseSplitted = morseWord.split(" ");

    for (String s : morseSplitted) {
      char decodedChar = this.decode(s);

      decodedWord = decodedWord + decodedChar;
    }

    return decodedWord;
  }

  private char decode(String morseCode) {
    Node current = root;
    for (char c : morseCode.toCharArray()) {
      if (c == '.') {
        current = current.dot;
      } else if (c == '-') {
        current = current.dash;
      }
      if (current == null) {
        return ' ';
      }
    }
    return current.letter;
  }

  public void printTree() {
    printTreeRecursively(root, "", true);
  }

  private void printTreeRecursively(Node node, String prefix, boolean isTail) {
    if (node != null) {
      System.out.println(prefix + (isTail ? "└── " : "├── ") + node.letter);
      String newPrefix = prefix + (isTail ? "    " : "│   ");
      printTreeRecursively(node.dot, newPrefix, node.dash == null);
      printTreeRecursively(node.dash, newPrefix, true);
    }
  }
}