/**
 * 
 */
app.controller("UserController",function(UserService,$location,$scope){
	$scope.register=function(){
		UserService.registerUser($scope.user).then(function(response){
			$scope.message="Registered successfully. Please Log in."
				$location.path('/login')
		},function(response){
			$scope.error=response.data
			$location.path('/registration')
		}) 
	}
})