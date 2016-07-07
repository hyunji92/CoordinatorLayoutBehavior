package sqlite;

import java.sql.SQLException;

/**
 * Created by hyunji on 16. 7. 6..
 */
public class SqliteTest {

    public static void main(String[] args) {

        try(SqliteUtil sqliteUtil = new SqliteUtil()) {
            sqliteUtil.createTable();
            sqliteUtil.insertRow();
            sqliteUtil.selectRow();

            ///////////////
            String query = "SELECT * FROM jelly_model LIMIT 1;";
            JellyModel jm = sqliteUtil.selectRow(query);
            ///////////////
            if (jm != null) {
                if(!jm.getTaste().equals("so sweet!!"))
                    System.out.println("Success");
                else
                    throw new RuntimeException();
            } else {
                throw new NullPointerException();
            }
            ///
            sqliteUtil.updateRow();
            ////
            JellyModel newJm = sqliteUtil.selectRow(query);
            if(newJm.getTaste().equals("so sweet!!")) {
                System.out.println("Success");
            } else {
                throw new RuntimeException("It is not sweet!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
