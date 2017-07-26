/**
 * 
 */
app.factory("MessageService",function($http){
	var messageService={};
	
	messageService.sendMessage=function(message){
		return $http.post("http://localhost:8080/BackEndProjectTwo/sendmessage",message)
	}
	
	messageService.viewMessage=function(username){
		return $http.get("http://localhost:8080/BackEndProjectTwo/getmessage/"+username)
	}
	return messageService;
})