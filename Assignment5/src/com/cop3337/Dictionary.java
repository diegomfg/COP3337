public class Dictionary {
  private WordList wordList;
  private WordList deprecateWordList;

  public Dictionary() {
    this.wordList = new WordList();
    this.deprecateWordList = new WordList();
  }

  public WordList getWords() {
    return this.wordList;
  }

  public WordList getDeprecateWordList() {
    return this.deprecateWordList;
  }

  public void addNewWord(Word newWord) {
    // Add the object to the wordlist
    this.wordList.add(newWord);
  }

  public void deprecateWord(String word) {
    deprecateWordList.deprecate(word);
  }

  public String printList() {
    return this.wordList.getWordListString();
  }

  public void addNewMeaningTo(String word, String meaning) {
    this.wordList.addNewMeaningTo(word, meaning);
  }
}
