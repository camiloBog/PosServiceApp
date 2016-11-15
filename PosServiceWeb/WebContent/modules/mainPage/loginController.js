'use strict';

angular.module('login', ['serviciosRest'])

.controller('loginController', ['$scope','serviciosRestRequest',loginController]);

function loginController($scope, serviciosRestRequest) {
	
	//Objeto que contiene los tipos de identificacion del sistema
	$scope.tiposId={}
	
	//Objeto que contiene los input del login
	$scope.Usu={}
	
	//Objeto que contiene los permisos a cada pantalla
	$scope.menu={}
	
	//Valida si el usuario y el pass son correctos
	$scope.loginFunction = function(){
		
		//Objeto que maneja la respuesta del servicio
		$scope.valUsu={}
		
		serviciosRestRequest.validar($scope.Usu.usu, $scope.Usu.pass).success(function (data){
			$scope.valUsu = data;
			$scope.login = !$scope.valUsu.validacion;
						
			$scope.menu = $scope.valUsu.menu;
			$scope.tiposId = $scope.valUsu.tiposIdentificacion;

		});
		
		//Se vacia nuevamente el objeto que contiene los input del login
		$scope.Usu={}
		
	};
	
	//Salir de la app
	$scope.salirFunction = function(){
		//Vacia las variables usadas
		$scope.tiposId={}
		$scope.valUsu={}
		$scope.Usu={}
		$scope.menu={}
		$scope.login = true;
	}
	
//	//BORRAR
//	$scope.menu.headConfiguracion = true;
//	$scope.menu.tenan = true;
//	$scope.menu.usuario = true;
//	$scope.menu.headInventario = true;
//	$scope.menu.proveedores = true;
//	$scope.menu.productos = true;
//	$scope.menu.ingreso = true;
//	$scope.menu.headFacturacion = true;
//	$scope.menu.headConsultas = true;
//	$scope.menu.inventario = true;
//	$scope.menu.ventas = true;

}

