package Controller;

import db.DbConnection;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerCrudController {
    public static List<String> getCustomerIds() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM customer");
        ResultSet rst  = stm.executeQuery();
        List<String> ids = new ArrayList<>();
        while (rst.next()){
            ids.add(
                    rst.getString(1)
            );
        }
        return ids;
    }
    public static Customer getCustomer(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM customer WHERE CID=?");
        stm.setObject(1, id);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );

        } else {
            return null;
        }

    }
}
