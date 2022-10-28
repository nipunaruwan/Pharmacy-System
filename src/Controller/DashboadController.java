package Controller;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;



public class DashboadController {

    public AnchorPane Home;
    public ImageView imgadmin;
    public AnchorPane root;

    public void btnHome(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/Home.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btnDoctor(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/Doctor.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btnDilivary(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/Dilivery.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btnItem(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/Item.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btnOrder(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/OrderDetails.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btnpayment(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/Payment.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btnCustomer(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/Customer.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
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

   /* public void btnadmin(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/Admin.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }*/

    public void playMouseEnterAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();

            switch (icon.getId()) {
                case "imgadmin":

            }

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    public void playMouseExitAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();



        }
    }

    public void navigate(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "imgadmin":
                   // root = FXMLLoader.load(getClass().getResource("/View/Admin.fxml"));
                    URL resource = getClass().getResource("../View/Admin.fxml");
                    assert resource != null;
                    Parent load = FXMLLoader.load(resource);
                    Home.getChildren().clear();
                    Home.getChildren().add(load);
                    break;


            }
            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setTitle("Manage Item Form | Supermarket System v0.1.0");
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
        }

    }
