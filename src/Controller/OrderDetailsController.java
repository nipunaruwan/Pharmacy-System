package Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.util.Duration;
import model.Customer;
import model.Item;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class OrderDetailsController {
    public Label lblTotal;
    public Label lblTime;
    public Label lblDate;
    public Label lblOrderId;
    public JFXComboBox cmbCustomerIds;
    public JFXTextField txtdId;
    public JFXTextField txtName;
    public JFXTextField txtCustomerAddress;
    public JFXComboBox cmdpcode;
    public JFXTextField txtdiscription;
    public JFXTextField txtpname;
    public JFXTextField txtqty;
    public JFXTextField txtprice;

    public void initialize() {
        initClock();
        setChart();
        loadCustomerIds();
        loaditemIds();

        cmdpcode.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           getitemDetails((Item) newValue);
        });

        cmbCustomerIds.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            getCustomerDetails((String) newValue);
        });
    }

    private void getCustomerDetails(String selectedCusId) {
        try {
            Customer c= CustomerCrudController.getCustomer(selectedCusId);
            if (c!=null) {
                txtdId.setText(c.getDID());
                txtName.setText(c.getName());
                txtCustomerAddress.setText(c.getAddress());
            }else{
                new Alert(Alert.AlertType.WARNING,"Empty Result").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void loadCustomerIds() {
        try {
            cmbCustomerIds.setItems(FXCollections.observableArrayList(CustomerCrudController.getCustomerIds()));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    private void getitemDetails(Item selectItemcode) {
        try {
            Item item= ItemCrudController.getitem(selectItemcode);
            if (item!=null) {
                txtName.setText(item.getNAME());
                txtdiscription.setText(item.getDISCRIPTION());
                txtqty.setText(String.valueOf(item.getQTY()));
               txtprice.setText(String.valueOf(item.getPRICE()));

            }else{
                new Alert(Alert.AlertType.WARNING,"Empty Result").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    private void loaditemIds() {
        try {
            cmdpcode.setItems(FXCollections.observableArrayList(ItemCrudController.getitem()));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setChart() {
    }

    private void initClock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            lblTime  .setText(LocalDateTime.now().format(formatter));


            SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            lblDate.setText(formatter2.format(date));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}
