package jdbc_study.git.jdbc.dao;

import java.util.List;

import jdbc_study.git.jdbc.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	
}
