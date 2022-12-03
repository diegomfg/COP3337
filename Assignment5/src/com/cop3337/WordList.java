import javax.swing.JOptionPane;

public class WordList {
  // Design linked list class
  private Word head;
  private int size;

  public void add(Word insertWord) {
    if (this.head == null) {

      size++;

      this.head = insertWord;

    } else {

      Word last = head;

      while (last.next != null) {

        size++;

        last = last.next;
      }

      last.next = insertWord;
    }
  }

  // Prints all the elements by traversing the nodes
  public void printList() {
    Word current = this.head;

    while (current != null) {
      System.out.println(current.toString());
      current = current.next;
    }
  }

  // Returns the size of the list
  public int getSize() {
    return size;
  }

  // Returns the String representation of all the words in the list
  public String getWordListString() {
    StringBuilder stringResult = new StringBuilder();
    Word current = this.head;
    while (current != null) {
      stringResult.append(current.toString());
      current = current.next;
    }

    return stringResult.toString();
  }

  // Loops through the Word nodes and adds a new WordMeaning to the Word object
  public void addNewMeaningTo(String word, String meaning) {
    Word current2 = head;
    while (current2 != null) {
      if (current2.getWord().equals(word)) {
        current2.addMeaning(new WordMeaning(meaning));
      }
      current2 = current2.next;
    }
  }

  public Word deprecate(String word) {
    Word temp = this.head;
    while (temp != null) {
      if (temp.getWord().equalsIgnoreCase(word)) {
        return temp;
      }
      temp = this.head.next;
    }
    return temp;
  }
}
