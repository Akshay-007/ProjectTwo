/**
 * 
 */
app.controller("BlogController",function($scope, $location, BlogService) {
					$scope.saveBlogPost = function() {
						BlogService.saveBlogPost($scope.blogPost).then(function(response) {
						$scope.message = 'Blog posted successfully and awaiting Administrator approval. Have a nice day!'
						$location.path('/listofblogs')
						},function(response) {
						$scope.message = response.data.message
						if (response.status == 401) 
						{
					       $location.path('/login')
						}
						if (response.status == 500) 
						{
						   $location.path('/saveblogpost')
						}
					})
					}
				})