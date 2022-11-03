package Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentController {
    public JFXTextField txtpayment;
    public JFXTextField txtbank;
    public JFXTextField txtPname;
    public JFXTextField txtaccountno;
    public JFXComboBox cmdCusId;
    public TextField txtpaymentId;

    public void btnadd(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Payment payment = new Payment(txtpayment.getText(), (String) cmdCusId.getValue(),txtPname.getText(),txtbank.getText(),txtaccountno.getText());
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO payment" + "VALUES(?,?,?,?,?)");
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

    public void btnupdate(ActionEvent actionEvent) {
    }

    public void btnDelecte(ActionEvent actionEvent) {
    }

    public void btnClear(ActionEvent actionEvent) {
    }

    public void btnsearch(ActionEvent actionEvent) {
    }
}
