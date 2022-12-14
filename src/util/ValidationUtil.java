package util;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.TextField;

import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class ValidationUtil {
    public static Object validate(LinkedHashMap<TextField, Pattern> map, JFXButton btn) {
       btn.setDisable(true);
        for (TextField textFieldKey : map.keySet()) {
            Pattern patternValue = map.get(textFieldKey);
            if (!patternValue.matcher(textFieldKey.getText()).matches()) {
                if (!textFieldKey.getText().isEmpty()) {
                    // textFieldKey.getParent().setStyle("-fx-border-color: red");
                    textFieldKey.setStyle("-fx-text-fill: #ff0000");
                }
                return textFieldKey;
            }
            //textFieldKey.getParent().setStyle("-fx-border-color: green");
            textFieldKey.setStyle("-fx-text-fill: green");
        }
        btn.setDisable(false);
        return true;
    }
}
