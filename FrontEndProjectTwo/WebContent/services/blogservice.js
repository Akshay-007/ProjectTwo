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
	
	blogService.getBlogPost=function(id){
		return $http.get("http://localhost:8080/BackEndProjectTwo/getblogpost/"+id)
	}
	
	blogService.updateBlogPost=function(blogPost){
		return $http.put("http://localhost:8080/BackEndProjectTwo/updateblog",blogPost)
	}
	
	blogService.addComment=function(blogComment){
		return $http.post("http://localhost:8080/BackEndProjectTwo/addblogcomment",blogComment) 
	}
	
	blogService.getComments=function(blogId){
		return $http.get("http://localhost:8080/BackEndProjectTwo/getblogcomments/"+blogId)
	}
	
	blogService.viewWall=function(username){
		return $http.get("http://localhost:8080/BackEndProjectTwo/wall/"+username)
	}
	
	
	return blogService;
})