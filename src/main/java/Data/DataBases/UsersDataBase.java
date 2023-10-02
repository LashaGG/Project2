package Data.DataBases;

import Data.DataBases.Connection.JdbcManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersDataBase extends JdbcManager {

    public UsersDataBase() {
        super("src/main/resources/db/userProperties.txt");
    }

    public int insertUser(String firstName, String lastName, String phone
            , String email, String dateOfBirth, String password) throws SQLException {

        String query = "INSERT INTO Users(firstName,lastName,phone,email,dateOfBirth,password) VALUES (?, ?, ?, ?,?,?)";

        PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.setString(3, phone);
        pstmt.setString(4, email);
        pstmt.setString(5, dateOfBirth);
        pstmt.setString(6, password);

        return pstmt.executeUpdate();
    }


}
