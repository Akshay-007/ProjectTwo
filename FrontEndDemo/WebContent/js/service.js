/**
 * 
 */
app.factory('PersonService',function($http){
var personService={};

personService.getAllPersons=function(){
return $http.get("http://localhost:8080/backenddemo/getallpersons")
}	

personService.savePerson=function(person){
	return $http.post("http://localhost:8080/backenddemo/saveperson",person)
}

personService.updatePerson=function(person){
	return $http.put("http://localhost:8080/backenddemo/updateperson",person)
}
return personService; 
})