package sqlite;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by hyunji on 16. 7. 7..
 */
public class SqliteUtilTest {
    @Test
    public void testCreateTable() {
        try(SqliteUtil sqliteUtil = new SqliteUtil()) {
            sqliteUtil.createTable();
            sqliteUtil.insertRow();
            JellyModel jm = sqliteUtil.selectRow();
            Assert.assertNotNull(jm);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }


    }
}
