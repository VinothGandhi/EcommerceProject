package com.ecommerceshoe.testmain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.ecommerceshoe.dao.ConnectionUtil;
import com.ecommerceshoe.dao.UserDao;
import com.ecommerceshoe.model.Users;

public class OverAllMain {

	public static void main(String[] args) {
		
		
	//	UserDao userdao =new UserDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("\n1.Createaccount\n2.login\nEnter your Choice");
		int choice=Integer.parseInt(sc.nextLine());
		Users user=null;
		switch(choice) {
		case 1:
		System.out.println("enter the Username details");
		String  Name=sc.nextLine();
		System.out.println("enter the Password");
		String password=sc.nextLine();
		System.out.println("enter the Mobileno");
        long mobileNo=Long.parseLong(sc.nextLine());
        System.out.println("enter Email id");
        String  email=sc.nextLine();
        System.out.println("enter the Address");
        String Address=sc.nextLine();
        user =new Users( Name,password,mobileNo,email,Address);
        UserDao.inserUser(user);
		
		case 2:
			 user=new Users();
			System.out.println("Enter the email");
		    String email_id=sc.nextLine();
		    System.out.println("Enter the password");
		    password =sc.nextLine();
			UserDao currentUser=new UserDao();
			user=currentUser.validateUser(email_id,password);
			if(currentUser!=null)
			{
			System.out.println("Welcome "+user.getName());
			
		}  
		break;
			
		default:
		{
			System.out.println("invalid number");
		}
		
		}
	
}
}