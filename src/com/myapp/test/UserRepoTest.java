package com.myapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.myapp.model.User;
import com.myapp.repository.UserRepository;

class UserRepoTest {
	//UserRepository userrepository;

	@Test
	public void addUserTest() {
		UserRepository	userrepository = new UserRepository();
		//test data
		User user = new User();
		user.setEmployeeId(18777);
		user.setEmployeeName("Riya");
		user.setDeptname("CEB");
		user.setEmail("riya@gmail.com");
		user.setRole_type("Trainer");
		user.setEmpPassword("password@123");
		assertEquals("Failed to add the user!", true, userrepository.add(user));
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	/*		
	@Test
	void testDBConnection() {
		String url= "jdbc:oracle:thin:localhost:1521:xe" ;
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			System.out.println("We are connected tothe db");
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT department_id,department_name FROM hr.departments");
			while (rs.next()) {
				String dept_id = rs.getString("department_id");
				String dept_name = rs.getString("department_name");
				System.out.println(dept_id + " " + dept_name);
				}			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	// failed-negative test case

	@Test
	public void testFailAuthUserFail() {
		assertEquals("Failed to validate the user!", true,
				userrepository.authenticate("chhaya.nikam@gmail.com", "password"));
	}

	// positive test case
	@Ignore
	@Test
	public void testAuthUser() {
		assertEquals("Failed to validate the user!", true,
				userrepository.authenticate("chhaya.nikam@nt.com", "password"));
	}

	

	// negative test case
	@Ignore
	@Test
	public void addUserTestFail() {
		User user = new User();
		user.setEmployeeId(18776);
		user.setEmployeeName("Riya");
		user.setDeptname("CEB");
		user.setEmail("riya@gmail.com.com");
		user.setRole_type("Trainer");
		user.setEmpPassword("password@123");
		assertEquals("Failed to add the user!", true, userrepository.add(user));
	}
	@Ignore
	@Test
	public void updateUserTest() {		
		User euser=new User();		
		euser.setEmployeeName("Riyanew");
		euser.setDeptname("CEBnew");
		euser.setEmail("riya@gmail.com.com");
		euser.setRole_type("Trainer1");
		euser.setEmpPassword("password1@123");
		assertEquals("Failed to update the user!", true, userrepository.update(euser));
	}

*/
}
