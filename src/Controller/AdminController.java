package Controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AdminController {
    public ImageView imgBack;
    public AnchorPane root;

//    public void navigateToBack(MouseEvent mouseEvent) throws IOException {
//        URL resource = this.getClass().getResource("/View/Dashboad.fxml");
//        Parent root = FXMLLoader.load(resource);
//        Scene scene = new Scene(root);
//        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Supermarket System ");
//        primaryStage.centerOnScreen();
//        Platform.runLater(() -> primaryStage.sizeToScene());
//    }
}
