package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by hyunji on 16. 7. 6..
 */
public class SqliteUtil {
    public static JellyModel get(Connection c, String query) {
        Statement stmt = null;
        try {
            stmt = c.createStatement();
        } catch(Exception e) {

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return new JellyModel();
    }

    public static Connection connectDB() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:jelly.sqlite");

        } catch (Exception e ) {
            e.printStackTrace();

        }

        return c;
    }

}
