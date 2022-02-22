package com.myapp.repository;

import java.sql.*;

import com.myapp.dao.UserDAO;
import com.myapp.model.User;
import com.myapp.utility.DbConnect;

public class UserRepository implements UserDAO {
	DbConnect db;
	Connection con=null;

	public UserRepository() {
	
	}

	public boolean authenticate(String email, String password) {
		boolean result = false;
		System.out.println("auth method called");
		Connection con = DbConnect.getConnection();
		String query = "select * from UserInfo where email='" + email + "' and emppassword='" + password + "'";

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next())
				result = true;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = false;
			e.printStackTrace();

		}
		return result;
	}
	@Override
	public User getByEmail(String email) {
		User user = new User();
		String query = "select * from UserInfo where email=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.first()) {
				return null;
			} else {
				user.setEmployeeId(rs.getInt(1));
				user.setEmployeeName(rs.getString(2));

				user.setEmail(rs.getString(3));
				user.setEmpPassword(rs.getString(4));
				user.setDeptname(rs.getString(2));

				user.setRole_type(rs.getString(5));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean add(User user) {
		Connection con=null;
		try {
		  con = DbConnect.getConnection();
			System.out.println("add called from userepo");
			//db = new DbConnect();
			//con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement(
					"INSERT INTO userinfo (employeeid, employeename,email,emppassword,role_type,deptname)"
							+ " values (?, ?, ?,?,?,?)");
			stmt.setInt(1, user.getEmployeeId());
			stmt.setString(2, user.getEmployeeName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getEmpPassword());
			stmt.setString(5, user.getRole_type());
			stmt.setString(6, user.getDeptname());
			stmt.executeUpdate();
			con.close();
			System.out.println("record added");
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			
		}
		
		return false;	
	}

	@Override
	public boolean delete(int empid) {
		try {
			Connection con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement("DELETE FROM userinfo WHERE empid=?");
			stmt.setInt(1, empid);
			stmt.executeUpdate();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;

	}

	@Override
	public boolean update(User user) {
		boolean res1 = false;
		try {		
			PreparedStatement stmt = con.prepareStatement(
					"UPDATE userinfo SET employeename=?, emppassword=?,role_type=?," + "deptname=?" + " WHERE email=?");
			System.out.println(user.getEmployeeName()+ user.getEmpPassword() + user.getRole_type());
			stmt.setString(1,user.getEmployeeName());
			stmt.setString(2, user.getEmpPassword());
			stmt.setString(3, user.getRole_type());
			stmt.setString(4, user.getDeptname());
			stmt.setString(5, user.getEmail());
			int res = stmt.executeUpdate();
			System.out.println(stmt);
			System.out.println("res="+res);
			if (res>0)
				res1 = true;
			return res1;
		} catch (SQLException e) {
			res1 = false;
			System.out.println(e);
			return res1;
		}
		
	}

	
}
