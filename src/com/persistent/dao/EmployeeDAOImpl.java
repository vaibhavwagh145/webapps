/**
 * 
 */
package com.persistent.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.persistent.bean.Employee;
import com.persistent.bean.Employee;
import com.persistent.dao.DBConnection;

/**
 * @author vaibhav
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.project.dao.ProjectDAO#getProjectList()
	 */

	@Override
	public int saveEmployeeDetails(String emp_id, String name, String email, String phoneNumber, String password) {
		Connection con;
         
		String insertTableSQL = "INSERT INTO employees" + "(name, email, phone_number, password, emp_id) VALUES" + "(?,?,?,?,?)";

		try {
			con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement pst = (PreparedStatement) con.prepareStatement(insertTableSQL);
				pst.setString(1, name);
				pst.setString(2, email);
				pst.setString(3, phoneNumber);
				pst.setString(4, password);
				pst.setString(5, emp_id);
				pst.executeUpdate();

				System.out.println("Employee registered...");
			}
			con.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return 0;
	}

	
	@Override
	public List<Employee> getEmployeeDetails(String inputEmpID) {
		// TODO Auto-generated method stub
		Employee employee;
		Connection con;
		List<Employee> employees = new ArrayList<>();
		try {
			con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement pst = (PreparedStatement) con.prepareStatement("select * from employees where emp_id = ?");
				pst.setString(1, inputEmpID);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					employee = new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
					employees.add(employee);
				}
			}
			con.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return employees;
	}

}
