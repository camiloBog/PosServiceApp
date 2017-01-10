'use strict';

angular.module('serviciosRest', [])

.factory('serviciosRestRequest', function($http) {
	
	var path = "/PosServiceRest/rest/";//API path
	
	return {
		
		validar : function(val_usuario){
			return $http.post(path+"loginsrv/validar/",val_usuario);
		},

		creaTenant : function(crea_tenant){
			return $http.post(path+"conf/reg/ten/",crea_tenant);
		},

		consultaTenant : function(cons_tenant){
			return $http.post(path+"conf/cons/ten/cod/",cons_tenant);
		},

		creaUsuario : function(crea_usuario){
			return $http.post(path+"conf/reg/usu/",crea_usuario);
		},
		
		creaProducto : function(crea_producto){
			return $http.post(path+"inv/reg/prod/",crea_producto);
		},
		
		consultaProducto : function(busca_producto){
			return $http.post(path+"inv/busc/prod/",busca_producto);
		}
		
	};
	
});