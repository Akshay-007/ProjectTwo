/**
 * 
 */
app.factory("PersonService",function($http){
	var personService={};
	
	personService.getAllPersons=function()
	{return $http.get("http://localhost:8080/backenddemo/getallpersons") }
	
	personService.savePerson=function(person)
	{
		return $http.post("http://localhost:8080/backenddemo/saveperson",person) 
	}
	
	personService.getPersonById=function(id)
	{
		return $http.get("http://localhost:8080/backenddemo/getpersonbyid/"+id) 
	}
	
	personService.updatePerson=function(person)
	{
		return $http.put("http://localhost:8080/backenddemo/updateperson",person)
	}
	
	personService.deletePerson=function(id)
	{
		return $http['delete']('http://localhost:8080/backenddemo/deleteperson/'+id) 
	}
	
	return personService; 
})