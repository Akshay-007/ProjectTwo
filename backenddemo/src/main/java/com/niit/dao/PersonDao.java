package com.niit.dao;

import java.util.List;

import com.niit.model.Person;

public interface PersonDao {
	

	List<Person> getAllPersons();
	void savePerson(Person person);
	void deletePerson(int id);
	void updatePerson(Person person);
	Person getPersonById(int id); 

}
