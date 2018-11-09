package jdbc_study.git.jdbc;



import java.sql.Connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class MySQLjdbcUtilTest {
   static final Logger LOG = LogManager.getLogger();

   @Test
   public void test() {
      
      try {
         Connection conn = MySQLjdbcUtil.getConnection();
         LOG.debug(String.format("Connected to DataBase %s successfully.", conn.getCatalog()));
         Assert.assertNotNull(conn);
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

}