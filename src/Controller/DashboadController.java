package Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;



public class DashboadController {

    public AnchorPane Home;

    public void btnHome(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/Home.fxml");
        assert resource != null;
        Parent load= FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btnDoctor(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/Doctor.fxml");
        assert resource != null;
        Parent load= FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btnDilivary(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/Dilivery.fxml");
        assert resource != null;
        Parent load= FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btnItem(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/Item.fxml");
        assert resource != null;
        Parent load= FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btnOrder(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/OrderDetails.fxml");
        assert resource != null;
        Parent load= FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btnpayment(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/Payment.fxml");
        assert resource != null;
        Parent load= FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btnCustomer(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/Customer.fxml");
        assert resource != null;
        Parent load= FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btnlogout(ActionEvent actionEvent) {
        ButtonType buttonType = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonType1 = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Did you exit the system?", buttonType, buttonType1);
        alert.setTitle("Confirmation");
        Optional<ButtonType> close = alert.showAndWait();
        if (close.orElse(buttonType1) == buttonType) {
            Platform.exit();
            System.exit(0);
        }
    }

    public void btnadmin(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/Admin.fxml");
        assert resource != null;
        Parent load= FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }
}
