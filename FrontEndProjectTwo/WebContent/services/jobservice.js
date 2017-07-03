/**
 * 
 */
app.factory("JobService",function($http){
	var jobService={}
	jobService.saveJob=function(job){
		return $http.post("http://localhost:8080/BackEndProjectTwo/savejob",job)
	}
	
	jobService.getAllJobs=function(){
		return $http.get("http://localhost:8080/BackEndProjectTwo/getalljobs")
	}
	
	jobService.viewJobDetails=function(id){
		return $http.get("http://localhost:8080/BackEndProjectTwo/viewjob/"+id)
	}
	return jobService;
})