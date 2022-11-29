public class Main {
  public static void main(String[] args) {
    // Show menu
    // Option 1: Insert word (Word Object can have different meanings, insert to
    // stack)
    // Option 2: List words and meanings
    // Add third option for archiving old words
    // Keep old words in a separate list

    Dictionary dictionary = new Dictionary();

    Word w = new Word("Apple", new WordMeaning("One of the most famous fruits"));
    w.addMeaning(new WordMeaning("Test meaning"));
    w.addMeaning(new WordMeaning("Test 2 meaning"));

    Word b = new Word("Cat", new WordMeaning("Animal"));
    b.addMeaning(new WordMeaning("Test 222"));
    b.addMeaning(new WordMeaning("LSlslsls"));

    dictionary.addNewWord();
  }
}