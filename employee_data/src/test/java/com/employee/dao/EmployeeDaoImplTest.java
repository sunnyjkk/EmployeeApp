/**
 * 
 */
package com.employee.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.entity.Employee;

/**
 * @author Oluwatobi
 *
 */


@Sql(scripts= {"classpath:/db/create-table.sql", "classpath:/db/insert-employees.sql"})
@ContextConfiguration("classpath:data-context.xml")
@RunWith(SpringRunner.class)
public class EmployeeDaoImplTest {
	
	
	@Autowired
	private Environment env;
	
	@Autowired
	private EmployeeDao employeeDaoImpl;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void saveEmployeeToDBTest() {
		
		Employee newEmployee = new Employee();
		Date employeeDate = Date.valueOf("2000-07-24");
		
		newEmployee.setFirstName("Mary");
		newEmployee.setLastName("Black");
		newEmployee.setEmail("mary@mail.com");
		newEmployee.setPhoneNumber("070585746755");
		newEmployee.setDateOfBirth(employeeDate);
		
		assertThat(employeeDaoImpl).isNotNull();
		employeeDaoImpl.saveEmployee(newEmployee);
		
		int id = newEmployee.getEmployeeId();
		
		System.out.println("New Employee Id --> " + id);
		
		Employee existingEmployee = employeeDaoImpl.getById(id);
		assertThat(existingEmployee).isNotNull();
	
		
	}
	
	@Test
	public void getEmployeeByEmailTest() {
		
		assertThat(employeeDaoImpl).isNotNull();
		
		Employee savedEmployee = employeeDaoImpl.getByEmail("ray@mail.com");
		
		assertThat(savedEmployee).isNotNull();
		
		assertThat(savedEmployee.getEmployeeId()).isEqualTo(4);
		
		System.out.println(savedEmployee);
		
	}
	
	@Test
	public void getAllEmployeesTest() {
		
		assertThat(employeeDaoImpl).isNotNull();
		
		List<Employee> allEmployees = employeeDaoImpl.findAll();
		
		assertThat(allEmployees).isNotNull();
		
		assertThat(allEmployees).hasSize(5);
		
		allEmployees.forEach(System.out::println);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
