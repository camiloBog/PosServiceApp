
'use strict';

angular.module('tenan', ['serviciosRest'])

.controller('tenanController', ['$scope','serviciosRestRequest',loginController]);

function loginController($scope, serviciosRestRequest) {
	
	$scope.consultar = function() {
		alert("Consultar");
	}
	
	$scope.crear = function() {
		
		$scope.tenant={}
		
		serviciosRestRequest.creaTenant("1","80735633","ElAmigoSupermercado","Calle","8123412").success(function (data){
			
			$scope.tenant = data;
			
			alert("Mensaje: "+$scope.tenant.mensaje);
			
		});
		
		
		
		
	}
	
	$scope.cancelar = function() {
		alert("Cancelar");
	}

}
