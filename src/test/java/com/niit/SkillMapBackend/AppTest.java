package com.niit.SkillMapBackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;


import com.niit.backend.config.ApplicationContext;
import com.niit.backend.dao.EmployeeDAO;
import com.niit.backend.daoimpl.EmployeeDAOImpl;
import com.niit.backend.model.Employee;

import junit.framework.TestCase;



/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=ApplicationContext.class)


public class AppTest extends TestCase
{
	 @Autowired
	 private EmployeeDAO empdao;
   
	@Before
	public void setUp()
	{
		//empdao=new EmployeeDAOImpl();
	}
	@After
	public void tearDawn()
	{
		//empdao=null;
	}
	
  
   @Test
	public void testCreateUser() {
        //EmployeeDAO empdao=new EmployeeDAOImpl();
		Employee employee=new Employee();
		employee.setEmpId(19);
		employee.setAddress("surat");
		employee.setEmpEmail("neha2@niit.com");
		employee.setEmpName("neha");
		employee.setEmpQualification("MCA");
		employee.setMobileNumber("98675434");
		employee.setEmpPassword("12345");
		employee.setRole("Manager");
		//empdao.insertEmployee(employee);
		//assertNotNull("Creating of user failed.",empdao.getEmployeeById("E12"));
		assertEquals(true, empdao.insertEmployee(employee));
		
		
		
	}

/*@Ignore
	@Test
	public void testUpdateEmployee() {
		//EmployeeDAO empdao=new EmployeeDAOImpl();
		//Employee employee=new Employee();
		empdao.getEmployeeById("E11");
		employee.setCity("surat");
		empdao.updateEmployee(employee);
		assertEquals("password2",empdao.getEmployeeById("E11").getPassword());
	
	}
	@Ignore
	@Test
	public void testGetListOfEmployee() {
		//EmployeeDAO empdao=new EmployeeDAOImpl();
		
		List<Employee> emplist=empdao.listAllEmployees();
		//assertNotNull("Retrieval of users failed.", emplist.size());
		assertEquals(7, emplist.size());
	}
   @Ignore
	@Test
	public void testDelete()
	{
		Employee empId=empdao.getEmployeeById("E10");
		String id=empId.getEmpId();
		//empdao.deleteEmployee(id);
		//assertNotNull("Retrieval of user failed.", employee);
		assertEquals(true, empdao.deleteEmployee(id));
	}

	@Test
	public void testDeleteNotNull()
	{
		Employee empId=empdao.getEmployeeById("E12");
		String id=empId.getEmpId();
		//empdao.deleteEmployee(id);
		assertNotNull("Retrieval of user failed.", empdao.deleteEmployee(id));
		
	}
	@Ignore
	@Test
	public void testGetUser() {
		//Employee employee=new Employee();
		EmployeeDAO empdao=new EmployeeDAOImpl();
		employee=empdao.getEmployeeById("E08");
	
		assertNotNull("Retrieval of user failed.", employee);
	}
*/
	
}
