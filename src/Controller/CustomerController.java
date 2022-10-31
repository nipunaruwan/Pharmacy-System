package Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerController {
    public JFXTextField txtcname;
    public JFXTextField txtcaddress;
    public JFXComboBox cmbDId;
    public JFXTextField txtCustD;
    public TextField txtCustID;

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

    public void btnsave(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Customer customer= new Customer(txtCustD.getText(),txtcname.getText(),txtcaddress.getText(), (String) cmbDId.getValue());
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer " + "VALUES(?,?,?,?)");
        preparedStatement.setObject(1,customer.getCID());
        preparedStatement.setObject(2,customer.getName());
        preparedStatement.setObject(3,customer.getAddress());
        preparedStatement.setObject(4,customer.getDID());

        int save = preparedStatement.executeUpdate();
        if (save > 0) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try again", ButtonType.OK).show();
        }

    }

    public void btnupdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Customer customer =new Customer(txtCustD.getText(),txtcname.getText(),txtcaddress.getText(), (String) cmbDId.getValue());
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement("UPDATE customer SET "+"Name=?,address=?,DID=?  WHERE CID=?");
        preparedStatement.setObject(1,customer.getName());
        preparedStatement.setObject(2,customer.getAddress());
        preparedStatement.setObject(3,customer.getDID());
        preparedStatement.setObject(4,customer.getCID());

        int update=preparedStatement.executeUpdate();
        if (update>0){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated",ButtonType.OK).show();
        }else{
            new Alert(Alert.AlertType.WARNING,"try again",ButtonType.OK).show();;
        }
    }

    public void btndelecte(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM customer WHERE CID=?");
        preparedStatement.setObject(1,txtCustD.getText());
        int delete= preparedStatement.executeUpdate();
        if (delete>0){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try again",ButtonType.OK).show();
        }
    }

    public void btnclear(ActionEvent actionEvent) {
        txtCustD.clear();
        txtcname.clear();
        txtcaddress.clear();
        cmbDId.getItems().clear();
    }

    public void btnsearch(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE CID=?");
        preparedStatement.setObject(1,txtCustID.getText());

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            txtCustD.setText(resultSet.getString(1));
            txtcname.setText(resultSet.getString(2));
            txtcaddress.setText(resultSet.getString(3));
            cmbDId.setValue(resultSet.getString(4));

        }
    }
}
