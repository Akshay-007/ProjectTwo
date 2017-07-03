/**
 * 
 */
app.factory("BlogService",function($http){
	var blogService={}
	blogService.saveBlogPost=function(blogPost){
		return $http.post("http://localhost:8080/BackEndProjectTwo/saveblogpost",blogPost)  
	}
	
	return blogService;
})