package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    private final String SERVER = "127.0.0.1";
    private final String PORT = "3306";
    private final String DATABASE = "northwind";

    private final String USER = "root";
    private final String PASSWORD = "Vietnam@123";

    public Connection getConnection() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url =
                    "jdbc:mysql://" + SERVER + ":" + PORT + "/" + DATABASE
                    + "?useSSL=false"
                    + "&serverTimezone=Asia/Ho_Chi_Minh"
                    + "&allowPublicKeyRetrieval=true";

            conn = DriverManager.getConnection(
                    url,
                    USER,
                    PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args) {
        DBContext db = new DBContext();

        if (db.getConnection() != null) {
            System.out.println("Kết nối MySQL thành công!");
        } else {
            System.out.println("Kết nối MySQL thất bại!");
        }
    }
}