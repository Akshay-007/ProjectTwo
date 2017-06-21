package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niit.dao.PersonDao;
import com.niit.model.Person;

@Controller
public class PersonController {
	@Autowired
	PersonDao personDao;
	@RequestMapping(value="/getallpersons",method=RequestMethod.GET)
	public @ResponseBody List<Person> getAllPersons()
	{
		List<Person> persons=personDao.getAllPersons();
		return persons;
	}
	
	@RequestMapping(value="/saveperson",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void savePerson(@RequestBody Person person)
	{
		personDao.savePerson(person);
	}
	
	@RequestMapping(value="/updateperson",method=RequestMethod.PUT)
	public ResponseEntity<Void> updatePerson(@RequestBody Person person){
		int id=person.getId();
		Person personAvailable=personDao.getPersonById(id);
		if(personAvailable==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		else
			personDao.updatePerson(person);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}	
	
	@RequestMapping(value="/deleteperson/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deletePerson(@PathVariable int id) 
	{
		personDao.deletePerson(id); 
	}
	
	@RequestMapping(value="/getpersonbyid/{id}",method=RequestMethod.GET)
	public ResponseEntity<Person> getPersonById(@PathVariable int id){
		Person person=personDao.getPersonById(id);
		if(person==null)
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Person>(person,HttpStatus.OK);
	}
	

}
