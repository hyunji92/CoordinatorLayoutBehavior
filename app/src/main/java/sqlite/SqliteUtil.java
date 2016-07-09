package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hyunji on 16. 7. 6..
 */
public class SqliteUtil implements AutoCloseable{


    private Connection c;


    public SqliteUtil() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:jelly" + new Date().getTime() + ".sqlite");
        } catch (Exception e ) {
            e.printStackTrace();
        }
        this.c = c;
    }


    public void createTable() {
        try (Statement stmt = c.createStatement()){
            String sql =  "CREATE TABLE jelly_model " +
                    "(ID INTEGER PRIMARY KEY autoincrement," +
                    " NAME         CHAR(50)    NOT NULL, " +
                    " TASTE        CHAR(50)     NOT NULL, " +
                    " date_added     datetime)";

            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertRow() {
        try(Statement stmt = c.createStatement()){
            String sql = "INSERT INTO jelly_model (NAME,TASTE,date_added) " +
                    "VALUES ('jelly', 'sweet!!!!', datetime())," +
                    " ('kuke', 'too sweet !!!!',datetime());";
            int updatetedRows = stmt.executeUpdate(sql);

            System.out.println(updatetedRows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JellyModel selectRow() {
        return selectRow("SELECT * FROM jelly_model LIMIT 1;" );
    }


    public JellyModel selectRow(String query) {
        try(Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query)){
            JellyModel jm = new JellyModel();
            while ( rs.next() ) {
                jm.setId(rs.getInt("id"));
                jm.setName(rs.getString("name"));
                jm.setTaste(rs.getString("taste"));
                jm.setDateAdded(rs.getString("date_added"));
                System.out.println(jm);

                return jm;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<JellyModel> selectRows() {
        try(Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM jelly_model" )){

            List<JellyModel> jmList = new ArrayList<>();
            while ( rs.next() ) {
                JellyModel jm = new JellyModel();
                jm.setId(rs.getInt("id"));
                jm.setName(rs.getString("name"));
                jm.setTaste(rs.getString("taste"));
                jm.setDateAdded(rs.getString("date_added"));
                jmList.add(jm);
            }
            System.out.println(jmList);
            return jmList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() throws SQLException {
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRow() {
        try (Statement s = c.createStatement();){
            String sql = "UPDATE jelly_model set taste = 'so sweet!!' where ID=1;";

            s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteRow() {
        try(Statement s = c.createStatement();) {
            String sql = "DELETE FROM jelly_model;";
            s.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
