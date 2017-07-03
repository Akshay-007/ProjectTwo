package com.niit.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.UsersDao;
import com.niit.model.Users;
import com.niit.model.Error;

@RestController
public class UserController {
@Autowired
private UsersDao usersDao; 
@RequestMapping(value="/registration",method=RequestMethod.POST)
public ResponseEntity<?> registration(@RequestBody Users users)
{
	try{
	users.setEnabled(true); 
	List<Users> userList=usersDao.getAllUsers();
	for(Users u:userList)
	{
		if(u.getUsername().equals(users.getUsername()))
		{
			Error error=new Error(2,"Username already exists");
			return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	users.setOnline(false);
	usersDao.registration(users); 
	return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	catch(Exception e)
	{
		com.niit.model.Error error=new Error(1,"Cannot register User");
		return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@RequestMapping(value="/login",method =RequestMethod.POST) 
public ResponseEntity<?> login(@RequestBody Users users,HttpSession session)
{
	Users validUser=usersDao.login(users); 
	if(validUser==null)
	{
		Error error=new Error(3,"Username or Password is incorrect");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	}
	else
	{
		validUser.setOnline(true);
		usersDao.updateUser(validUser);
		session.setAttribute("user", validUser);
		return new ResponseEntity<Users>(validUser,HttpStatus.OK);
	}
}

@RequestMapping(value="/logout",method=RequestMethod.GET)
public ResponseEntity<?> logout(HttpSession session)
{
	Users user=(Users) session.getAttribute("user");
	if(user==null)
	{
		Error error=new Error(4,"Unauthorized user");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	}
	user.setOnline(false);
	usersDao.updateUser(user);
	session.removeAttribute("user");
	session.invalidate();
	return new ResponseEntity<Void>(HttpStatus.OK);
}
}
