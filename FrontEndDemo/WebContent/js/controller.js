/**
 * 
 */
app.controller('PersonController',function(PersonService,$scope){
$scope.persons=PersonService.getAllPersons().then(function(response){
$scope.persons=response.data;
})

$scope.save=function(){
	PersonService.savePerson($scope.person).then(function(response){
		console.log(response.data)
		console.log(response.status)
	})
}

$scope.update=function(){
	PersonService.updatePerson($scope.person).then(function(response){
		console.log(response.data)
		console.log(response.status)
	})
}
})