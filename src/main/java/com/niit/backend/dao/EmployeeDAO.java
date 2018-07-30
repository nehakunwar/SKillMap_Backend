package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.Employee;

public interface EmployeeDAO {
	public boolean insertEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	
	public boolean updateEmployee(Employee employee);
	public Employee getEmployeeById(int eId);
	public boolean deleteEmployee(int eId);
	public boolean approveEmployee(int eId);
	public List<Employee> listApprovedEmployees();
	public List<Employee> listNotApprovedEmployees();
	public Employee searchEmployeesByName(String name);
}
