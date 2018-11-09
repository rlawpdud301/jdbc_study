package jdbc_study.git.jdbc;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import jdbc_study.git.jdbc.dao.DepartmentDao;
import jdbc_study.git.jdbc.dao.DepartmentDaoImpl;
import jdbc_study.git.jdbc.dto.Department;


public class DepartmentDaoTest {

	static DepartmentDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MySQLjdbcUtilTest.LOG.debug("setUpbeforeClass()");
		dao=new DepartmentDaoImpl();
		
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		MySQLjdbcUtilTest.LOG.debug("tearDownAfterClass()");
		dao=null;
	}

	@Test
	public void testSelectDepartmentByAll() {
		List<Department> list = dao.selectDepartmentByAll();
		for(Department dept : list) {
			MySQLjdbcUtilTest.LOG.debug(dept);
		}
		Assert.assertNotEquals(0, list.size());
	}
	
	@Test
	public void testInsertDepartment() {
		Department newDept = new Department(4,"자바개발부서",15);
		try {
			int res = dao.insertDepartment(newDept);
			Assert.assertEquals(1, res);
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
			if(e.getErrorCode()==1062) {
				JOptionPane.showMessageDialog(null, "이미존재하는부서");
			}
		}
	}

}
