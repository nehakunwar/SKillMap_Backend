package com.niit.backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.dao.EmployeeDAO;
import com.niit.backend.model.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean insertEmployee(Employee employee) 
	{
		System.out.println("in insert method");
		
		sessionFactory.getCurrentSession().save(employee);
		return true;
	}

	public List<Employee> getAllEmployees() {
	
		return sessionFactory.getCurrentSession().createQuery("from Employee ").list();
	}

	public boolean updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return true;
	}

	public Employee getEmployeeById(int eId) {
		Employee employee=(Employee)sessionFactory.getCurrentSession().createQuery("from Employee where empId=" + eId).uniqueResult();
		return employee;
	}

	public boolean deleteEmployee(int eId) {
		sessionFactory.getCurrentSession().delete(getEmployeeById(eId));
		return true;
	}

	public boolean approveEmployee(int eId) {
		sessionFactory.getCurrentSession().createQuery("from Employee set status=true where empId=" + eId);
		return true;
	}

	public List<Employee> listApprovedEmployees() {
		List<Employee> employee=sessionFactory.getCurrentSession().createQuery("from Employee where status=true").list();
		return employee;
	}

	public List<Employee> listNotApprovedEmployees() {
		List<Employee> employee=sessionFactory.getCurrentSession().createQuery("from Employee where status=false").list();
		return employee;
	}

	public Employee searchEmployeesByName(String name) {
		Employee employee=(Employee)sessionFactory.getCurrentSession().createQuery("from Employee where empName like '"+name+"%'").list();
		return employee;
	}
	

}
