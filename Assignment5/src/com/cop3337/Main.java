import javax.swing.JOptionPane;

/**
 * @author Diego Matheus, Alejandro Espinal
 *         Java COP3337 Assignment #5
 *         LinkedList Implementation
 */
public class Main {
  public static void main(String[] args) {

    // Join the Menu options to show them in one JOptionPane
    String menu = "1) Show all words\n" +
        "2) Insert new word\n" +
        "3) Insert new meaning to word\n" +
        "4) Deprecate word\n" +
        "5) Exit";

    // Creates the test entities
    /**
     * Handles the JOptionPane methods
     */
    UI window = new UI();
    /**
     * Holds the wordslist
     */
    Dictionary dictionary = new Dictionary();

    // Show menu and get option from user
    String option = window.getInput(menu, InputTypes.OPTION_MENU);
    int intOption = Integer.parseInt(option);

    while (intOption != 5) {
      switch (intOption) {
        case 1:
          window.display(dictionary.printList());
          break;

        case 2:

          String word = window.getInput(null, InputTypes.NEW_WORD);
          String meaning = window.getInput(null, InputTypes.NEW_MEANING);

          while (word == null || meaning == null) {
            window.showError("Word or meaning cannot be empty");
            word = window.getInput(null, InputTypes.NEW_WORD);
            meaning = window.getInput(null, InputTypes.NEW_WORD);
          }
          dictionary.addNewWord(new Word(word, new WordMeaning(meaning)));
          break;

        case 3:
          String meaning2 = window.getInput(null, InputTypes.NEW_MEANING);

          String word2 = window.getInput(
              dictionary.printList() + "\n\tType the word which you want to add the meaning to",
              InputTypes.ADD_MEANING);

          while (meaning2.isEmpty() || meaning2.isBlank() || word2.isEmpty() || word2.isBlank()) {

            word2 = window.getInput(
                dictionary.printList() + "\n\tType the word which you want to add the meaning to",
                InputTypes.ADD_MEANING);

          }
          dictionary.addNewMeaningTo(word2, meaning2);
          break;

        case 4:
          String deprecatedWord = window.getInput(dictionary.printList() + "\nType the word to deprecate",
              InputTypes.DEPRECATE);

          while (deprecatedWord == null) {
            deprecatedWord = window.getInput(dictionary.printList() + "\nType the word to deprecate",
                InputTypes.DEPRECATE);
          }

          dictionary.deprecateWord(deprecatedWord);
          break;

        default:
          window.display("Wrong option");
          break;
      }
      intOption = Integer.parseInt(window.getInput(menu, InputTypes.OPTION_MENU));
    }

  }
}