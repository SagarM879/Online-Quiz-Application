package com.onlinequiz.business;

import com.onlinequiz.dao.UserDao;
import com.onlinequiz.model.User;

public class LoginApp {

	public static User authenticate(String username,String password)
	{
		User loginUser = new User(username,password);
		User authUser =UserDao.getUser(username);
		if(authUser==null)
		{
			System.out.println("got null in auth user");
			return null;
		}
		//boolean userflag = (authUser.getUserName()).equals(loginUser.getUserName());
		boolean passflag = (authUser.getPassword()).equals(loginUser.getPassword());
		//System.out.println("LoginApp auth user is "+authUser);
		//System.out.println("LoginApp login user is "+loginUser+" \n  "+passflag);
		if( !passflag)
		{
			UserDao.msg = "User Name or Password is Incorrect!";
		}
		else
		{
			System.out.println("authenitcation is successfull");
			return authUser;
		}
		System.out.println("auth failed");
		return null;
	}

}
