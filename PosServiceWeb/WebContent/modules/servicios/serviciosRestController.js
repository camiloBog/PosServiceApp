'use strict';

angular.module('serviciosRest', [])

.factory('serviciosRestRequest', function($http) {
	
	var path = "http://localhost:8082/PosServiceRest/rest/";//API path
//	var path = "/PosServiceRest/rest/";//API path
	
	return {
		
		validar : function(usu, pas){
			return $http.get(path+"loginsrv/validar/"+usu+"/"+pas);
		}
	
//		validar : function(usu, pas){ 
//			
////			var resp = $http({
////	            method: 'GET',
////	            url: path+'someservice/getusuarios'
////	        }).success(function(data, status, headers, config) {
////	        	var txt = "****success: "+data+"\nstatus:"+status+"\nheaders:"+headers+"\nconfig:"+config;
//////	        	alert(txt);
////	        	console.log(txt)
////	        	return data;
//////	            defered.resolve(data);
////	        }).error(function(data, status, headers, config) {
////	        	var txt = "error: "+data+"\nstatus:"+status+"\nheaders:"+headers+"\nconfig:"+config;
////	        	console.log(txt)
//////	        	alert(txt);
////	        	
//////	            if (status === 400) {
//////	                defered.reject(data);
//////	            } else {	
//////	                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
//////	            }
////	        });
////			
////			
////			
////			
////			
////			return resp;
////			return $http.get(path+'someservice/getipcliente');
//			return $http.get(path+"loginsrv/validar/"+usu+"/"+pas);
//		}
		
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