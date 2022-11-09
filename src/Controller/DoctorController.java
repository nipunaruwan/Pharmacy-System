package Controller;

import View.Tm.CustomerTm;
import View.Tm.DoctorTm;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import model.Doctor;

import javax.xml.transform.Result;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DoctorController implements Initializable {
    public JFXTextField txtDid;
    public JFXComboBox cmdEx;
    public JFXTextField Dname;
    public JFXTextField txtaddress;
    public TextField DID;
    public TableView<DoctorTm> tbldoctor;
    public TableColumn coldocid;
    public TableColumn coldocname;
    public TableColumn coldocaddress;
    public TableColumn cpldocex;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmdEx.getItems().addAll("1 year", "2 year", "3 year","4 year","5 year");

        coldocid.setCellValueFactory(new PropertyValueFactory<>("DID"));
        coldocname.setCellValueFactory(new PropertyValueFactory<>("Name"));
        coldocaddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        cpldocex.setCellValueFactory(new PropertyValueFactory<>("Experiennce"));
        loadAllDoctor();

       tbldoctor .getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           txtDid.setText(newValue.getDID());
            Dname.setText(newValue.getName());
           txtaddress.setText(newValue.getAddress());
            cmdEx.setValue(newValue.getExperiennce());

        });
    }

    private void loadAllDoctor() {
        ArrayList<Doctor> doctors = new ArrayList<>();
        ObservableList<DoctorTm> objects = FXCollections.observableArrayList();

        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM doctor");
            ResultSet rst = preparedStatement.executeQuery();

            while (rst.next()) {
                doctors.add(new Doctor(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4))

                );
            }
            for (Doctor doc : doctors) {
                objects.add(new DoctorTm(doc.getDID(), doc.getName(), doc.getAddress(), doc.getExperiennce()));
            }
            tbldoctor.setItems(objects);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getDoctorIds() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM doctor");
        ResultSet rst  = stm.executeQuery();
        List<String> ids = new ArrayList<>();
        while (rst.next()){
            ids.add(
                    rst.getString(1)
            );
        }
        return ids;
    }

    public void btnadd(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Doctor doctor = new Doctor(txtDid.getText(),Dname.getText(),txtaddress.getText(), (String) cmdEx.getValue());
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO doctor " + "VALUES(?,?,?,?)");
        preparedStatement.setObject(1,doctor.getDID());
        preparedStatement.setObject(2,doctor.getName());
        preparedStatement.setObject(3,doctor.getAddress());
        preparedStatement.setObject(4,doctor.getExperiennce());

        int save = preparedStatement.executeUpdate();
        if (save > 0) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try again", ButtonType.OK).show();
        }

    }

    public void btnupdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Doctor doctor = new Doctor(txtDid.getText(),Dname.getText(),txtaddress.getText(), (String) cmdEx.getValue());
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE doctor SET "+" Name=?,Address=?,Experiennce=? WHERE DID=?");
        preparedStatement.setObject(1,doctor.getName());
        preparedStatement.setObject(2,doctor.getAddress());
        preparedStatement.setObject(3,doctor.getExperiennce());
        preparedStatement.setObject(4,doctor.getDID());



        int update=preparedStatement.executeUpdate();
        if (update>0){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated",ButtonType.OK).show();
        }else{
            new Alert(Alert.AlertType.WARNING,"try again",ButtonType.OK).show();;
        }

    }

    public void btnclear(ActionEvent actionEvent) {
    }

    public void btndelete(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM doctor WHERE DID=?");
        preparedStatement.setObject(1,txtDid.getText());
        int delete= preparedStatement.executeUpdate();
        if (delete>0){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try again",ButtonType.OK).show();
        }


    }

    public void btnsearch(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM doctor WHERE DID=?");
        preparedStatement.setObject(1,DID.getText());

        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            txtDid.setText(resultSet.getString(1));
            Dname.setText(resultSet.getString(2));
            txtaddress.setText(resultSet.getString(3));
            cmdEx.setValue(resultSet.getString(4));

        }
    }
}
