package jdbc_study.git.jdbc.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.MySQLConnection;

import jdbc_study.git.jdbc.MySQLjdbcUtil;
import jdbc_study.git.jdbc.dto.Department;


public class DepartmentDaoImpl implements DepartmentDao {
   Logger LOG = LogManager.getLogger();
   
   @Override
   public List<Department> selectDepartmentByAll()  {
      List<Department> list = new ArrayList<>();
      String sql = "select deptno, deptname, floor from department";
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
         conn= MySQLjdbcUtil.getConnection();
         pstmt = conn.prepareStatement(sql);
         LOG.debug(pstmt);
         rs = pstmt.executeQuery();
         while (rs.next()) {
			int deptNo = rs.getInt("deptno");
			String deptName = rs.getString("deptname");
			int floor = rs.getInt("floor");
			Department dept = new Department(deptNo,deptName,floor);
			list.add(dept);
			
		}
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
    	  try {
			rs.close();
			pstmt.close();
	    	conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  
      }
      return list;
   }

}