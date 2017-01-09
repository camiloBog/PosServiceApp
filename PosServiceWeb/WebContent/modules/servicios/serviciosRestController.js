'use strict';

angular.module('serviciosRest', [])

.factory('serviciosRestRequest', function($http) {
	
	var path = "/PosServiceRest/rest/";//API path
	
	return {
		
//		validar : function(usu, pas){
		validar : function(val_usuario){
			return $http.post(path+"loginsrv/validar/",val_usuario);
		},
		
//		creaTenant : function(tipoid,id,nom,dir,tel){
		creaTenant : function(crea_tenant){
			return $http.post(path+"conf/reg/ten/",crea_tenant);
		},
		
//		consultaTenant : function(cod){
		consultaTenant : function(cons_tenant){
			return $http.post(path+"conf/cons/ten/cod/",cons_tenant);
		},
		
//		creaUsuario : function(usuario, nombre, apellidos, contrasena, idperfil, idtenant){
		creaUsuario : function(crea_usuario){
			return $http.post(path+"conf/reg/usu/",crea_usuario);
		}
		
	};
	
});