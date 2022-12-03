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
    Word current = head;
    while (current != null) {
      if (current.getWord().equals(word)) {
        current.addMeaning(new WordMeaning(meaning));
      }
      current = current.next;
    }
  }

  public void deprecate(String word) {
    Word current = head;
    Word next = current.next;
    while (current != null) {
      if (current.getWord().equalsIgnoreCase(word)) {
        current = next;
      }
      current = current.next;
    }
  }
}
