package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbActions extends CommonOps {

@Step("Get credentials from database")
    public static List<String> getCredentials(String sqlQuery)  {
    List<String>credentials=new ArrayList<>();
    try {
        rs=stmt.executeQuery(sqlQuery);
        if (rs.next()) {
            credentials.add(rs.getString("user_name"));
            credentials.add(rs.getString("password"));
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error while fetching credentials from the database", e);
    }
    return credentials;
}
}
