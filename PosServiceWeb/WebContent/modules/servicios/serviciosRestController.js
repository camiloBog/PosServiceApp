'use strict';

angular.module('serviciosRest', [])

.factory('serviciosRestRequest', function($http) {
	
//	var path = "http://localhost:8080/PosServiceRest/rest/";//API path
	var path = "/PosServiceRest/rest/";//API path
	
	return {
		
//		validar : function(usu, pas){
//			return $http.get(path+"loginsrv/validar/"+usu+"/"+pas);
//		},
		
		validar : function(usu, pas){
			
			var val_usuario = {
				contrasena:pas,
				usuario:usu
			};
			
			return $http.post(path+"loginsrv/validar/", val_usuario);
		},
		
		creaTenant : function(tipoid,id,nom,dir,tel){
			return $http.get(path+"conf/reg/ten/"+tipoid+"/"+id+"/"+nom+"/"+dir+"/"+tel);
		},
		
		consultaTenant : function(cod){
			return $http.get(path+"conf/cons/ten/cod/"+cod);
		},
		
		creaUsuario : function(usuario, nombre, apellidos, contrasena, idperfil, idtenant){
			return $http.get(path+"conf/reg/usu/"+usuario+"/"+nombre+"/"+apellidos+"/"+contrasena+"/"+idperfil+"/"+idtenant);
		},
		
		
		creaUsuario : function(usuario, nombre, apellidos, contrasena, idperfil, idtenant){
			return $http.get(path+"conf/reg/usu/"+usuario+"/"+nombre+"/"+apellidos+"/"+contrasena+"/"+idperfil+"/"+idtenant);
		}
		
		
	};
	
});