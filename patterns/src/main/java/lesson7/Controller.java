package lesson7;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    TextField adressField;

    @FXML
    TextArea messageArea;

    @FXML
    Button sendButton;

    public void sendMessage() {
        if (!adressField.getText().isEmpty() && !messageArea.getText().isEmpty()) {
            Network.getInstance().sendMessage(adressField.getText(), messageArea.getText());
            adressField.clear();
            messageArea.clear();
        }
    }
}
