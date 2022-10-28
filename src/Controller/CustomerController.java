package Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import java.sql.SQLException;

public class CustomerController {
    public JFXTextField txtcname;
    public JFXTextField txtcaddress;
    public JFXComboBox cmbDId;
    public JFXTextField txtCustD;

    public void initialize(){
        loadDoctorIds();
    }

    private void loadDoctorIds() {
        try {
            cmbDId.setItems(FXCollections.observableArrayList(DoctorController.getDoctorIds()));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnsave(ActionEvent actionEvent) {
    }

    public void btnupdate(ActionEvent actionEvent) {
    }

    public void btndelecte(ActionEvent actionEvent) {
    }

    public void btnclear(ActionEvent actionEvent) {
    }

    public void btnsearch(ActionEvent actionEvent) {
    }
}
