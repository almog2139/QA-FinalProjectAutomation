package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageDB extends CommonOps {

    /*
      Method Name:openConnection
      Method Description: method get dbURL,username,password  and connect to db
      Method Parameters:String
     */
    public static void openConnection(String dbURL, String username, String password) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(dbURL, username, password);
        stmt = con.createStatement();

    }

    /*
         Method Name:closeConnection
         Method Description: method close the  connect to db

    */
    public static void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
