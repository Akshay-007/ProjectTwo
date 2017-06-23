/**
 * 
 */
var app=angular.module("app",['ngRoute'])
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
	.otherwise('/',{
		templateUrl:'views/Home.html'
	})
})