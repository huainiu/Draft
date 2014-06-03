package JavaCookbook;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Michael.Shreiber on 2/17/14.
 */
public class JDBCDemo {

    private String jdbcURL = "jdbc:mysql://qa2uri1:3306/reports";
    private String sqlUsername = "root";
    public String sqlPassword;

    public Connection getConnection() {
        Connection connection = null;
        try {
            //TODO: understand why we need the below line
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(jdbcURL, sqlUsername, sqlPassword);
        } catch (Exception ex) {
            System.out.println(("Failed to create connection; " + ex));
        }
        return connection;
    }


    public String getValueFromDB(Connection connection, String statement) throws SQLException {
        String value = "";

        connection = getConnection();
        PreparedStatement st = connection.prepareStatement(statement);
        ResultSet setFiles = st.executeQuery();
        if (setFiles.next()) {
            value = setFiles.getString(1);
        }

        return value;
    }

    public static void main(String[] args) throws SQLException {
        JDBCDemo demo = new JDBCDemo();
        demo.sqlPassword = "*****";
        Connection con = demo.getConnection();
        String statement = "SELECT build FROM dailyreports WHERE date = '20140217' AND profile = 'news'";
        String value = demo.getValueFromDB(con, statement);
        System.out.println(value);

    }
}
