'use strict';

angular.module('serviciosRest', [])

.factory('serviciosRestRequest', function($http) {
	
//	var path = "http://localhost:8080/PosServiceRest/rest/";//API path
	var path = "/PosServiceRest/rest/";//API path
	
	return {
		
		validar : function(usu, pas){
			return $http.get(path+"loginsrv/validar/"+usu+"/"+pas);
		},
		
		creaTenant : function(tipoid,id,nom,dir,tel){
			return $http.get(path+"conf/registrar/"+tipoid+"/"+id+"/"+nom+"/"+dir+"/"+tel);
		}
		
	};
	
});