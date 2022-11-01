package Controller;

import com.jfoenix.controls.JFXTextField;
import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemController {
    public TextField txtcode1;
    public JFXTextField txtdiscription;
    public JFXTextField txtpname;
    public JFXTextField txtqty;
    public JFXTextField txtprice;
    public JFXTextField txtcode;

    public void btnsave(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Item item = new Item((txtcode.getText()),txtpname.getText(),txtdiscription.getText(),Integer.parseInt(txtqty.getText()),Double.parseDouble(txtprice.getText()));
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO Item " + "VALUE (?,?,?,?,?)");
        preparedStatement.setObject(1,item.getPCODE());
        preparedStatement.setObject(2,item.getNAME());
        preparedStatement.setObject(3,item.getDISCRIPTION());
        preparedStatement.setObject(4,item.getQTY());
        preparedStatement.setObject(5,item.getPRICE());

        int save=preparedStatement.executeUpdate();
        if (save>0){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved ", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try again", ButtonType.OK).show();
        }

    }

    public void btnupdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE item SET " + "NAME=?,DISCRIPTION=?, QTY=?,PRICE=? WHERE  PCODE=?");
        preparedStatement.setObject(1,txtpname.getText());
        preparedStatement.setObject(2,txtdiscription.getText());
        preparedStatement.setObject(3,txtqty.getText());
        preparedStatement.setObject(4,txtprice.getText());
        preparedStatement.setObject(5,txtcode.getText());

        int update= preparedStatement.executeUpdate();
        if (update>0){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try agian",ButtonType.OK).show();
        }

    }

    public void btndelete(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM item WHERE PCODE=?");
        preparedStatement.setObject(1,txtcode.getText());
        int delete= preparedStatement.executeUpdate();
        if (delete>0){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try again",ButtonType.OK).show();
        }

    }

    public void btnclear(ActionEvent actionEvent) {
    }

    public void btnsearch(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM item WHERE PCODE=?");
        preparedStatement.setObject(1,txtcode1.getText());

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            txtcode.setText(resultSet.getString(1));
            txtpname.setText(resultSet.getString(2));
            txtdiscription.setText(resultSet.getString(3));
            txtqty.setText(resultSet.getString(4));
            txtprice.setText(resultSet.getString(5));

        }
    }
    }

