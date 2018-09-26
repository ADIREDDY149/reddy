
var module=angular.module("application",[]);
module.controller("onecontroller",function($scope,$http){
	
	
	$scope.updatestudent=function(){
		$http.post("update.do",$scope.std).success(function(){
			alert("sucessfully updated");
		}).error(function(){
			alert("error");
		});
		
	}
	$scope.deletestudent=function(){
		$http.post("delete.do",$scope.std).success(function(){
			alert("sucessfully deleted");
		}).error(function(){
			alert("error");
		});
		
	}
	
	$scope.getById=function(id){
		$http.get("GetById.do?id="+id)
		.success(function(data){
		$scope.std=data;
		alert(std);})
		.error(function(){
		alert("error");
		});
	}
	
	
	$scope.Getall=function(){
		
		$http.get("getall.do").success(function(data){
			$scope.students=data;
			alert(data);
		}).error(function(){
			alert("error");
		});
	}
	
	$scope.savedata=function(){
		$http.post("savedata.do",$scope.std)
		.success(function(){
		alert("sucessfuuly saved");
		}).error(function(){
		alert("error")
		});
		
	}
});

module.config(function($routeProvider){
	
	
	$routeProvider.when("/one",{controller:"onecontroller",templateUrl:'one.html'});
	
});
	
	
