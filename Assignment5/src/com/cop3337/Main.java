public class Main {
  public static void main(String[] args) {
    // Show menu
    // Option 1: Insert word (Word Object can have different meanings, insert to stack
    // Option 2: List words and meanings
    // Add third option for archiving old words
    // Keep old words in a separate list
    UI window = new UI();
    Dictionary dictionary = new Dictionary();

    String word = window.getInput(InputTypes.NEW_WORD);
    String meaning = window.getInput(InputTypes.NEW_MEANING);

    // If empty
    if(word.isEmpty() || meaning.isEmpty()){
      window.showError("Word or meaning cannot be empty");
    }
    
    Word newword = new Word(word, new WordMeaning(meaning));

    dictionary.addNewWord(newword);
    dictionary.addNewWord(new Word("Katana", new WordMeaning("Sword")));
    dictionary.addNewWord(new Word("Knife", new WordMeaning("Sword Two")));

    dictionary.printList();

  }
}