package jdbc_study.git.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import jdbc_study.git.jdbc.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	
	int insertDepartment(Department department) throws SQLException;
	
}
