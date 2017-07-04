/**
 * 
 */
app.factory("BlogService",function($http){
	var blogService={}
	blogService.saveBlogPost=function(blogPost){
		return $http.post("http://localhost:8080/BackEndProjectTwo/saveblogpost",blogPost)  
	}
	
	blogService.getBlogsApproved=function(){
		return $http.get("http://localhost:8080/BackEndProjectTwo/listofblogs/"+true)
	}
	
	blogService.getBlogsWaitingForApproval=function(){
		return $http.get("http://localhost:8080/BackEndProjectTwo/listofblogs/"+false)
	}
	return blogService;
})