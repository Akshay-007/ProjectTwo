/**
 * 
 */
app.controller("WallController",function($scope,$location,BlogService,$window,$routeParams){
	var username=$routeParams.username
	$scope.wallName=username
	
		$scope.blogPost=BlogService.viewWall(username).then(function(response){
			$scope.blogPost=response.data
		},function(response){
			$window.alert('Failed to open Wall')
			console.log(response.status)
		})
		
		$scope.addComment=function(){
		$scope.blogComment.blogPost=$scope.blogPost
		BlogService.addComment($scope.blogComment).then(function(response){
			console.log(response.status)
			alert('Comment added successfully')
			$scope.blogComment.body=''
		},function(response){
			console.log(response.status)
		})
	}
		
		$scope.getBlogComments=function(blogId){
		$scope.showComments=true
		BlogService.getComments(blogId).then(function(response){
			$scope.blogComments=response.data
			console.log(response.data)
			console.log(response.status)
		},function(response){
			console.log(response.status)
		})
	}

	
	
	
})