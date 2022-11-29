public class Dictionary {
  private WordList wordList;
  private WordList deprecateWordList;
  private UI window;

  public Dictionary() {
    this.wordList = new WordList();
    this.deprecateWordList = new WordList();
    this.window = new UI();
    // Open JOptionpane to show menu
  }

  public WordList getWords() {
    return this.wordList;
  }

  public WordList getDeprecateWordList() {
    return this.deprecateWordList;
  }

  public void addNewWord() {
    String word = window.getInput(InputTypes.NEW_MEANING);
    // If empty?
    String meaning = window.getInput(InputTypes.NEW_MEANING);
    // If empty?
    Word newword = new Word(word, new WordMeaning(meaning));
    window.display(newword.toString());
    // Add the object to the wordlist
  }

  public void deprecateWord(String word) {
    // Should this be the logic?
    // deprecateWordList.insert(wordList.get(word));
  }
}
