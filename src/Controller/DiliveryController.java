package Controller;

import com.jfoenix.controls.JFXTextField;
import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import model.DiliveryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiliveryController {
    public TextField txtDsID;
    public JFXTextField txtDs;
    public JFXTextField txtDsname;

    public void btnsearch(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM dilevary WHERE DSID=?");
        preparedStatement.setObject(1,txtDsID.getText());
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
          txtDs.setText(resultSet.getString(1));
            txtDsname.setText(resultSet.getString(2));



        }
        }


    public void btnsave(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        DiliveryService diliveryService= new DiliveryService(txtDs.getText(),txtDsname.getText());
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO dilevary " + "VALUE (?,?)");
        preparedStatement.setObject(1,diliveryService.getDSID());
        preparedStatement.setObject(2,diliveryService.getDSNAME());

        int save=preparedStatement.executeUpdate();
        if (save>0){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved ", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try again", ButtonType.OK).show();
        }

    }

    public void btnclear(ActionEvent actionEvent) {
    }

    public void btndelete(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM dilevary WHERE DSID=?");
        preparedStatement.setObject(1,txtDs.getText());
        int delete= preparedStatement.executeUpdate();
        if (delete>0){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try again",ButtonType.OK).show();
        }


    }

    public void btnupdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("UPDATE dilevary SET  "+"DSNAME=?  WHERE  DSID=?");
        preparedStatement.setObject(1,txtDsname.getText());
        preparedStatement.setObject(2,txtDs.getText());


        int update= preparedStatement.executeUpdate();
        if (update>0){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try agian",ButtonType.OK).show();
        }
    }
}
