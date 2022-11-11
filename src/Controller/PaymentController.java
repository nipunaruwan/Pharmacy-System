package Controller;

import View.Tm.CustomerTm;
import View.Tm.ItemTm;
import View.Tm.PaymentTm;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentController {
    public JFXTextField txtpayment;
    public JFXTextField txtbank;
    public JFXTextField txtPname;
    public JFXTextField txtaccountno;
    public JFXComboBox cmdCusId;
    public TextField txtpaymentId;
    public TableColumn colpaymentid;
    public TableColumn colcusid;
    public TableColumn colpname;
    public TableColumn colbank;
    public TableColumn colaccountno;
    public TableView<PaymentTm> tblpayment;

    public void initialize(){
        loadCustomerIds();
       colpaymentid.setCellValueFactory(new PropertyValueFactory<>("PID"));
        colcusid.setCellValueFactory(new PropertyValueFactory<>("CID"));
        colpname.setCellValueFactory(new PropertyValueFactory<>("Productname"));
        colbank.setCellValueFactory(new PropertyValueFactory<>("Bank"));
       colaccountno.setCellValueFactory(new PropertyValueFactory<>("accountno"));

        loadAllPayment();

       tblpayment .getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtpaymentId.setText(newValue.getPID());
           cmdCusId.setValue(newValue.getCID());
           txtPname.setText(newValue.getProductname());
           txtbank.setText(newValue.getBank());
           txtaccountno.setText(newValue.getAccountno());


        });

    }

    private void loadAllPayment() {
        ArrayList<Payment> payments = new ArrayList<>();
        ObservableList<PaymentTm> objects = FXCollections.observableArrayList();

        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM payment");
            ResultSet rst = preparedStatement.executeQuery();

            while (rst.next()) {
               payments.add(new Payment(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5))

                );
            }
            for (Payment payment : payments) {
                objects.add(new PaymentTm(payment.getPID(), payment.getCID(), payment.getProductname(), payment.getBank(),payment.getAccountno()));
            }
            tblpayment.setItems(objects);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void btnadd(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Payment payment = new Payment(txtpayment.getText(), (String) cmdCusId.getValue(),txtPname.getText(),txtbank.getText(),txtaccountno.getText());
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO payment" + " VALUES(?,?,?,?,?)");
        preparedStatement.setObject(1,payment.getPID());
        preparedStatement.setObject(2,payment.getCID());
        preparedStatement.setObject(3,payment.getProductname());
        preparedStatement.setObject(4,payment.getBank());
        preparedStatement.setObject(5,payment.getAccountno());
        int save = preparedStatement.executeUpdate();
        if (save > 0) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try again", ButtonType.OK).show();
        }
    }

    public void btnupdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Payment payment = new Payment(txtpayment.getText(), (String) cmdCusId.getValue(),txtPname.getText(),txtbank.getText(),txtaccountno.getText());
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE payment SET " + "CID=?,Productname=?,Bank=?,accountno=? WHERE PID=?");

        preparedStatement.setObject(1,payment.getCID());
        preparedStatement.setObject(2,payment.getProductname());
        preparedStatement.setObject(3,payment.getBank());
        preparedStatement.setObject(4,payment.getAccountno());
        preparedStatement.setObject(5,payment.getPID());

        int update=preparedStatement.executeUpdate();
        if (update>0){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated",ButtonType.OK).show();
        }else{
            new Alert(Alert.AlertType.WARNING,"try again",ButtonType.OK).show();
        }

    }

    public void btnDelecte(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM payment WHERE PID=?");
        preparedStatement.setObject(1, txtpaymentId.getText());
        int delete = preparedStatement.executeUpdate();
        if (delete > 0) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try again", ButtonType.OK).show();
        }
    }

    public void btnClear(ActionEvent actionEvent) {
    }

    public void btnsearch(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM payment WHERE PID=?");
preparedStatement.setObject(1,txtpaymentId.getText());
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
          txtpayment.setText(resultSet.getString(1));
            cmdCusId.setValue(resultSet.getString(2));
            txtPname.setText(resultSet.getString(3));
            txtbank.setText(resultSet.getString(4));
            txtaccountno.setText(resultSet.getString(5));


        }

    }
    private void loadCustomerIds() {
        try {
            cmdCusId.setItems(FXCollections.observableArrayList(CustomerCrudController.getCustomerIds()));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
