package com.persistent.dao;

import java.util.List;

import com.persistent.bean.Employee;

public interface EmployeeDAO {

	public int saveEmployeeDetails(String emp_id, String name, String email, String phoneNumber, String password);
	
	public List<Employee> getEmployeeDetails(String userName);

//	public int deleteEmployeeDetails(int empId);

//	public Employee editEmployeeDetails(int empId);

//	public int updateEmployeeDetails(int empId, String name, String email, int phoneNumber, String password);
}
