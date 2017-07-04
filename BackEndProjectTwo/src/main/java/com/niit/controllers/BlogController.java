package com.niit.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.BlogPostDao;
import com.niit.model.BlogPost;
import com.niit.model.Users;
import com.niit.model.Error;

@RestController
public class BlogController {
	@Autowired
	private BlogPostDao blogPostDao;

	@RequestMapping(value = "/saveblogpost", method = RequestMethod.POST)
	public ResponseEntity<?> saveBlog(@RequestBody BlogPost blogPost, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
			Error error = new Error(1, "Unauthorized");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		}
		try {
			blogPost.setPostedOn(new Date());
			blogPost.setCreatedBy(user);
			blogPostDao.saveBlogPost(blogPost);
			return new ResponseEntity<Void>(HttpStatus.OK);

		} catch (Exception e) {
			Error error = new Error(2, "Could not insert Blog details");
			return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/listofblogs/{approved}",method=RequestMethod.GET)
	public ResponseEntity<?> getAllBlogs(@PathVariable boolean approved, HttpSession session)
	{
		Users user=(Users) session.getAttribute("user");
		if(user==null)
		{
			Error error=new Error(3,"Unauthorized");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		List<BlogPost> blogs=blogPostDao.getallblogs(approved);
		return new ResponseEntity<List<BlogPost>>(blogs,HttpStatus.OK);
	}

}
