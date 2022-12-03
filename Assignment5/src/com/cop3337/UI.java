
import javax.swing.JOptionPane;

public class UI {

    public UI() {

    }

    public void display(String message) {

        JOptionPane.showMessageDialog(null, message);

    }

    public String getInput(String message, InputTypes types) {

        String result;

        switch (types) {
            case NEW_WORD:
                result = JOptionPane.showInputDialog(null, "Please enter the new word");
                break;

            case NEW_MEANING:
                result = JOptionPane.showInputDialog(null, "Please enter the word meaning");
                break;

            case OPTION_MENU:
                result = JOptionPane.showInputDialog(null, message);
            break;
            default:
                JOptionPane.showMessageDialog(null, "Error, wrong input type");
                result = "";
            break;
        }

        return result;
    }

    public void showError(String errorMessage){
        JOptionPane.showMessageDialog(null, errorMessage, "Invalid input", 3);
    }
}