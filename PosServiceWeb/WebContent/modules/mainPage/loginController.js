'use strict';

angular.module('login', ['serviciosRest'])

.controller('loginController', ['$scope','serviciosRestRequest',loginController]);

function loginController($scope, serviciosRestRequest) {
	
	$scope.loginFunction = function(){
		
		$scope.valUsu={}
		serviciosRestRequest.validar().success(function (data){
			
			$scope.valUsu = data;

			
		});

	};

}

