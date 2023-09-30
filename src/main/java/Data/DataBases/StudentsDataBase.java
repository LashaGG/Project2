package Data.DataBases;

import Data.DataBases.Connection.JdbcManager;

import java.sql.*;

public class StudentsDataBase extends JdbcManager {

    public StudentsDataBase() {
        super("src/main/resources/db/properties.txt");
    }


    public int insertStudent(int ID, String firstName, String lastName, String phone) throws SQLException {

        String query = "INSERT INTO Students(id, firstName, lastName, phone) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        pstmt.setInt(1, ID);
        pstmt.setString(2, firstName);
        pstmt.setString(3, lastName);
        pstmt.setString(4, phone);

        return pstmt.executeUpdate();
    }

    public int nextID() throws SQLException {
        ResultSet last = executeQuery("SELECT TOP 1 * FROM Students ORDER BY id DESC;");
        return last.next() ? last.getInt("id") + 1 : 1000;
    }

}
