/**
 * 
 */
app.factory("UserService",function($http){
	var userService={}
	userService.registerUser=function(user){
		return $http.post("http://localhost:8080/BackEndProjectTwo/registration",user)
	}
	return userService;
})