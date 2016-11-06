'use strict';

angular.module('serviciosRest', [])

.factory('serviciosRestRequest', function($http) {
	
	var path = "http://localhost:8080/Core/";//API path
	
	return {
		
		validar : function(){ 
			return $http.get(path+'someservice/getusuario');
		}
		
//		//Login
//		posts : function(){ //Retornara la lista de posts
//			global = $http.get(path+'posts');
//			return global;
//		},
//		
//		post : function(id){ //retornara el post por el id
//			global = $http.get(path+'posts/'+id);
//			return global;	
//		}	
	};
	
});