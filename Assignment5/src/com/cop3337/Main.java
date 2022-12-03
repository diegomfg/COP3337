import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) {
    // Show menu
    // Option 1: Insert word (Word Object can have different meanings, insert to stack
    // Option 2: List words and meanings
    // Add third option for archiving old words
    // Keep old words in a separate list

    String menu = "1) Show all words\n" +
    "2) Insert new word\n" + 
    "3) Insert new meaning to word\n" + 
    "4) Deprecate word";

    UI window = new UI();
    Dictionary dictionary = new Dictionary();

    String option = window.getInput(menu, InputTypes.OPTION_MENU);
    int intOption = Integer.parseInt(option);

while(intOption != 5){
  
    switch(intOption){
      case 1:
        window.display(dictionary.printList());
      break;

      case 2:

        String word = window.getInput(null, InputTypes.NEW_WORD);
        String meaning = window.getInput(null, InputTypes.NEW_MEANING);

        while(word.isEmpty() || meaning.isEmpty()){
          window.showError("Word or meaning cannot be empty");
          word = window.getInput(null, InputTypes.NEW_WORD);
          meaning = window.getInput(null, InputTypes.NEW_WORD);
        }
        dictionary.addNewWord(new Word(word, new WordMeaning(meaning)));
      break;

      case 3:
        String meaning2 = window.getInput(null,InputTypes.NEW_MEANING);
      break;

      case 4:
        window.display("Deprecating message");
      break;

      default:
        window.display("Wrong option");
      break;
    }
    intOption = Integer.parseInt(window.getInput(menu,InputTypes.OPTION_MENU));
  }

  }
}