import java.util.Stack;

public class Word {
  private Stack<WordMeaning> meanings = new Stack<WordMeaning>();
  private String word;
  public Word(String word, WordMeaning meaning){
    this.word = word;
    this.meanings.push(meaning);
  }

  public String getWord(){
    return this.word;
  }

  public WordMeaning addMeaning(WordMeaning meaning){
    return this.meanings.push(meaning);
  }

  public Stack<WordMeaning> getMeanings(){
    return this.meanings;
  }

  public String toString(){
    
    return word + getMeaningsFormattedList(this.meanings);
  }


  private static String getMeaningsFormattedList(Stack<WordMeaning> meanings){
    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < meanings.size(); i++){
      sb.append(" - " + meanings.get(i) + "\n\t");
    }

    return sb.toString();
  }
}
