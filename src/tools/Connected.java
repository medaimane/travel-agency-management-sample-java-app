package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connected {

    private static Connected db;
    public static Connection connection;
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String dbName = "agence";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String userName = "medaimane";
    private static final String password = "che@mysql";

    private Connected() {
        try {
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(url + dbName, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("" + e.getMessage());
        }
    }

    public static synchronized Connected getDB() {
        if (db == null) {
            db = new Connected();
        }
        return db;
    }

    public ResultSet query(String query) throws SQLException {
        Statement statement = Connected.connection.createStatement();
        return statement.executeQuery(query);
    }
}
