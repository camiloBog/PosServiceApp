'use strict';

angular.module('login', ['serviciosRest'])

.controller('loginController', ['$scope','serviciosRestRequest',loginController]);

function loginController($scope, serviciosRestRequest) {
	
	//Objeto que contiene los input del login
	$scope.Usu={}
	
	//Valida si el usuario y el pass son correctos
	$scope.loginFunction = function(){
		
		//Objeto que maneja la respuesta del servicio
		$scope.valUsu={}
		
		serviciosRestRequest.validar($scope.Usu.usu, $scope.Usu.pass).success(function (data){
			
			$scope.valUsu = data;
			$scope.login = !$scope.valUsu.validacion;
			
		});
		
		//Se vacia nuevamente el objeto que contiene los input del login
		$scope.Usu={}
	};
	
	//Salir de la app
	$scope.salirFunction = function(){
		//Vacia las variables usadas
		$scope.valUsu={}
		$scope.Usu={}
		$scope.login = true;
	}

}

