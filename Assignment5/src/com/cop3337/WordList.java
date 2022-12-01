public class WordList{
  // Design linked list class
  private Word head;
  private int size;

  public void add(Word insertWord){
    if(this.head == null){

      size++;

      this.head = insertWord;

    } else {

      Word last = head;

      while(last.next != null){

        size++;

        last = last.next;
      }

      last.next = insertWord;
    }
  }

  public void printList(){
    Word current = this.head;

    while(current != null){
      System.out.println(current.toString());
      current = current.next;
    }
  }
}
