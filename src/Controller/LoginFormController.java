package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.ValidationUtil;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class LoginFormController {
    public JFXTextField txtUsername;
    public JFXPasswordField txtpassword;
    public AnchorPane root;
    public JFXButton btnLogin;
    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();

    Pattern titleRegEx = Pattern.compile("^[A-z]{1,5}$");
    Pattern postalCodeRegEx = Pattern.compile("^[0-9]{4,9}$");


    public void initialize() {

        storeValidate();
    }

    private void storeValidate() {
        map.put(txtUsername, titleRegEx);
        map.put(txtpassword, postalCodeRegEx);
    }

    public void btnLogin(ActionEvent actionEvent) throws IOException {
LoginFormManager();

    }

    private void LoginFormManager() throws IOException {
        String user = "admin";
        String password = "1234";
        if (txtUsername.getText().equals(user) && txtpassword.getText().equals(password)) {
            Stage window = (Stage) root.getScene().getWindow();
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/Dashboad.fxml"))));

        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Try Again").show();
        }
    }

    public void KeyRelease(KeyEvent keyEvent) {
        Object response = ValidationUtil.validate(map, btnLogin);

        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (response instanceof TextField) {
                TextField errorText = (TextField) response;
                errorText.requestFocus();
            } else if (response instanceof Boolean) {
                // new Alert(Alert.AlertType.INFORMATION, "Added").showAndWait();
            }
        }

    }
}
