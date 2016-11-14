
'use strict';

angular.module('tenan', ['serviciosRest'])

.controller('tenanController', ['$scope', 'serviciosRestRequest',loginController]);

function loginController($scope, serviciosRestRequest) {
	
	$scope.delay = 0;
	$scope.minDuration = 0;
	$scope.message = 'Por favor espere...';
	$scope.backdrop = true;
	$scope.promise = null;
	
	$scope.consultar = function() {
		
		$scope.promise = $http.get('http://localhost/PosServiceRest/rest/conf/registrar/1/2/Los%20Santanderes/Algunacalle/81235');
//		alert("Consultar");
	}
	
	$scope.crear = function() {
		
		$scope.tenant={}
		
		$scope.promise = serviciosRestRequest.creaTenant("1","80735633","ElAmigoSupermercado","Calle","8123412").success(function (data){
			
			$scope.tenant = data;
			
			//alert("Mensaje: "+$scope.tenant.mensaje);
			
		});
		
		
		
		
	}
	
	$scope.cancelar = function() {
		alert("Cancelar");
	}

}
