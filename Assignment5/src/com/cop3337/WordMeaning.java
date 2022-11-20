public class WordMeaning {
  private String meaning;
  public WordMeaning(String meaning){
    this.meaning = meaning;
  }
  public String setMeaning(String meaning){
    this.meaning = meaning;
    return this.meaning;
  }

  public String toString(){
    return this.meaning;
  }
}
