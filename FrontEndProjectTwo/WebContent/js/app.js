/**
 * 
 */
var app=angular.module("app",['ngRoute','ngCookies'])
app.config(function($routeProvider){
	$routeProvider
	.when('/registration',{
		templateUrl:'views/RegistrationForm.html',
		controller:'UserController'
	})
	.when('/login',{
		templateUrl:'views/Login.html',
		controller:'UserController'
	})
	.when('/savejob',{
		templateUrl:'views/JobForm.html',
		controller:'JobController'
	})
	.when('/getalljobs',{
		templateUrl:'views/JobTitles.html',
		controller:'JobController'
	})
	.when('/saveblogpost',{
		templateUrl:'views/BlogPostForm.html',
		controller:'BlogController' 
	})
	.otherwise('/',{
		templateUrl:'views/Home.html'
	})
})

app.run(function($location,$rootScope,UserService,$cookieStore){
	
	if($rootScope.currentUser==undefined)
		$rootScope.currentUser=$cookieStore.get("currentUser")
	
	$rootScope.logout=function(){
		UserService.logoutUser().then(function(response){
			$rootScope.message="Logged out successfully"
				delete $rootScope
				$cookieStore.remove("currentUser")
				$location.path('/login')
		},function(response){
			console.log(response.status)
			$rootScope.message=response.data.message
			$location.path('/login')
		})
	}
	
})