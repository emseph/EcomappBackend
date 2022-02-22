package com.myapp.model;
import java.util.HashMap;

import com.myapp.validator.*;

public class User extends Validator{
	private int employeeId;
	private String employeeName;
	private String email;
	private String empPassword;	
	private String deptname;
	private String role_type;	
	public User() {		
		errorMessage=new HashMap<String,String>();
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getRole_type() {
		return role_type;
	}
	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}
	
	public User(int employeeId, String employeeName, String email, String empPassword, String deptname,
			String role_type) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.empPassword = empPassword;
		this.deptname = deptname;
		this.role_type = role_type;
	}
	public HashMap<String, String> validate()
    {
        String message;
        String field;
        String emptyField="Field cannot be empty";
        Validator validator=new Validator();
        if(!(validator.validateEmail(this.getEmail())))
        {
            message="Email invalid";
            field="email";
            errorMessage.put(field,message);
        }
        if(this.getEmail().isEmpty())
        {
            message="Field can't be empty";
            field="email";
            errorMessage.put(field,emptyField);
        }        
        if(this.getEmpPassword().isEmpty())
        {
            message="Field can't be empty";
            field="password";
            errorMessage.put(field,emptyField);
        }
                
        return errorMessage;
    }
	

}
