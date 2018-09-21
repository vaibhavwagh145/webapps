package com.persistent.service;

import java.util.List;

import com.persistent.dao.EmployeeDAO;
import com.persistent.dao.EmployeeDAOImpl;
import com.persistent.bean.Employee;
import com.persistent.dao.EmployeeDAO;
import com.persistent.dao.EmployeeDAOImpl;



public class EmployeeService {

	public int addEmployee(String emp_id, String name, String email, String phoneNumber, String password) {
		// TODO Auto-generated method stub
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();

		return employeeDAO.saveEmployeeDetails(emp_id, name, email, phoneNumber, password);
	}
	
	public List<Employee> getEmployeeDetails(String userName) {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		return employeeDAO.getEmployeeDetails(userName);
	}
	
}
