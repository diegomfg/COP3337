public class Dictionary {
  private WordList wordList;
  private WordList deprecateWordList;

  public Dictionary(){
    this.wordList = new WordList();
    this.deprecateWordList = new WordList();
    // Open JOptionpane to show menu
  }

  public WordList getWords(){
    return this.wordList;
  }

  public WordList getDeprecateWordList(){
    return this.deprecateWordList;
  }
}
