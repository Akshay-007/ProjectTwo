/**
 * 
 */
app.controller("PersonController",function(PersonService, $scope, $location){
	$scope.persons=PersonService.getAllPersons().then(function(response){
		console.log(response.status)
		$scope.persons=response.data;
	},function(response){
		console.log(response.status)} )
		
		$scope.save=function(){
		PersonService.savePerson($scope.person).then(function(response){
			console.log(response.status)
			console.log(response.data)
			$location.path('/getallpersons')
		},function(response){
			console.log(response.status) 
		})
			
		
	}
	
	$scope.delete=function(id){
		PersonService.deletePerson(id).then(function(response){
			console.log(response.status)
			$location.path('/getallpersons')
		},function(response){
			console.log(response.status)
		})
	}
})
