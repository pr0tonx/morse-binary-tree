public class Main {

  public static void main(String[] args) {
    MorseCodeTree morseTree = new MorseCodeTree();

    System.out.println(morseTree.decodePhrase(".-.. . .- .-. -. .. -. --."));

    morseTree.printTree();
  }
}