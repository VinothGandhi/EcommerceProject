package com.ecommerceshoe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ecommerceshoe.model.Users;

public class UserDao {
	
	public static void inserUser(Users user) {
		ConnectionUtil conUtil = new ConnectionUtil();
		String insertQuery = "insert into  users1(Name,password,mobile_no,email_id,Address) values(?,?,?,?,?)";
		Connection con = conUtil.getDbconnection();
		PreparedStatement pstmt = null;
		try {

			pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setLong(3, user.getMobileNo());
			pstmt.setString(4,user.getEmail());
			pstmt.setString(5, user.getAddress());
			int i=pstmt.executeUpdate();
			System.out.println(i+"Value Inserted Successfully");

		} catch (SQLException e) {
			//catch the exception and get that message
			e.printStackTrace();
			System.out.println("Value not Setted in the query");
		}
	}
		public static Users validateUser(String email ,String password)
		{
			String validateQuery="select * from users1 where email_id ='"+email+"'";
			Connection con=ConnectionUtil.getDbconnection();
			Users user=null;
			try {
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(validateQuery);
				if(rs.next())
				{
			//System.out.println(rs.getString(2)+"  "+rs.getLong(3));
				user=new Users(email,password,rs.getString(2));
				}


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Statement error");
			}

			return user;
	



	}
}

	