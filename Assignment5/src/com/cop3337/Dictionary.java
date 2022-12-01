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
    // Should this be the logic?
    // deprecateWordList.insert(wordList.get(word));
  }

  public void printList(){
    this.wordList.printList();
  }
}
