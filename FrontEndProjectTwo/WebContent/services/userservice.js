/**
 * 
 */
app.factory("UserService",function($http){
	var userService={}
//	var config = {
//            headers : {
//                'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
//            }
//        }
	userService.registerUser=function(user){
		return $http.post("http://localhost:8080/BackEndProjectTwo/registration",user)
	}
	
	userService.loginUser=function(user){
		return $http.post("http://localhost:8080/BackEndProjectTwo/login",user)
	}
	
	userService.logoutUser=function(user){
		return $http.get("http://localhost:8080/BackEndProjectTwo/logout",user)
	}
	return userService;
})