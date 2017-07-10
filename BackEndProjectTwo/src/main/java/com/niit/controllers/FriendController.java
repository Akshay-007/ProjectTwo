package com.niit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.FriendDao;
import com.niit.model.Users;

@RestController
public class FriendController {
	@Autowired
	private FriendDao friendDao;

	@RequestMapping(value="/friendsuggestions",method=RequestMethod.POST)
	public ResponseEntity<?> getSuggestedUsers(@RequestBody Users user)
	{
		List<Users> suggestedUsers=friendDao.listOfSuggestedUsers(user.getUsername());
		
		return new ResponseEntity<List<Users>>(suggestedUsers,HttpStatus.OK);
		
	}
}
