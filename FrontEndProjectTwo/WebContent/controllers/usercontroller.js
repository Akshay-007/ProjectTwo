/**
 * 
 */
app.controller("UserController",function(UserService,$location,$scope,$rootScope,$cookieStore){
	
	
	$scope.register=function(){
		UserService.registerUser($scope.user).then(function(response){
			$scope.message="Registered successfully. Please Log in."
				$location.path('/login')
		},function(response){
			$scope.error=response.data
			$location.path('/registration')
		}) 
	}
	
	$scope.login=function(){
		UserService.loginUser($scope.user).then(function(response){
			$rootScope.currentUser=response.data
			$cookieStore.put("currentUser",response.data)
			$location.path('/home')
		},function(response){
			$scope.error=response.data
			$location.path('/login')
		})
	}
})