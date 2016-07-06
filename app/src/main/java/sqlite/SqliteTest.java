package sqlite;

import java.sql.Connection;

/**
 * Created by hyunji on 16. 7. 6..
 */
public class SqliteTest {

    public static void main(String[] args) {
        Connection c = null;
        try {
             c = SqliteUtil.connectDB();
            if (c == null)
                throw new NullPointerException();

            ///////////////
            String query = "SELECT * FROM tbl_jelly_master LIMIT 1;";
            JellyModel jm = SqliteUtil.get(c, query);
            ///////////////
            if (jm != null) {
                System.out.println("Success");
            } else {
                throw new NullPointerException();
            }
        } catch (Exception e ) {
            e.printStackTrace();
        } finally {
            if(c != null)
                try {
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
}
