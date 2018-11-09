package jdbc_study.git.jdbc;

import java.util.List;

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

}
