'use strict';

angular.module('serviciosRest', [])

.factory('serviciosRestRequest', function($http) {
	
	//API path
	var path = "/PosServiceRest/rest/";
	
	return {
		
		validar : function(val_usuario){
			return $http.post(path+"loginsrv/validar/",val_usuario);
		},

		creaTenant : function(crea_tenant){
			return $http.post(path+"conf/reg/ten/",crea_tenant);
		},

		consultaTenant : function(cons_tenant){
			return $http.post(path+"conf/cons/ten/",cons_tenant);
		},

		creaUsuario : function(crea_usuario){
			return $http.post(path+"conf/reg/usu/",crea_usuario);
		},
		
		consultaUsuario : function(consulta_usuario){
			return $http.post(path+"conf/cons/usu/params",consulta_usuario);
		},
		
		eliminaUsuario : function(elimina_usuario){
			return $http.post(path+"conf/elim/usu/",elimina_usuario);
		},
		
		creaProducto : function(crea_producto){
			return $http.post(path+"inv/reg/prod/",crea_producto);
		},
		
		consultaProducto : function(busca_producto){
			return $http.post(path+"inv/busc/prod/",busca_producto);
		},
		
		eliminaProducto : function(busca_producto){
			return $http.post(path+"inv/elim/prod/",busca_producto);
		},
		
		creaProveedor : function(crea_producto){
			return $http.post(path+"inv/reg/pers/",crea_producto);
		},
		
		consultaProveedor : function(busca_producto){
			return $http.post(path+"inv/busc/pers/",busca_producto);
		},
		
		eliminaProveedor : function(busca_producto){
			return $http.post(path+"inv/elim/pers/",busca_producto);
		}
		
	};
	
});