
'use strict';

angular.module('tenan', ['serviciosRest'])

.controller('tenanController', ['$scope', 'serviciosRestRequest',loginController]);

function loginController($scope, serviciosRestRequest) {
	
	$scope.tenant = {};

	$scope.consultar = function() {
		swal("Upss!", "Hace falta implementar este metodo!", "error");
	}
	
	$scope.cancelar = function() {
		swal("Upss!", "Hace falta implementar este metodo!", "error");
	}
	
	$scope.crear = function() {
		
		if($scope.tenant.nom == null){
			swal("Upss!", "El campo Nombre esta vacio.", "error");
		} else if ($scope.tenant.idTipo == null){
			swal("Upss!", "El campo Tipo de Identificacion esta vacio.", "error");
		} else if ($scope.tenant.idNum == null){
			swal("Upss!", "El campo Identificacion esta vacio.", "error");
		} else if ($scope.tenant.dir == null){
			swal("Upss!", "El campo Direccion esta vacio.", "error");
		} else if ($scope.tenant.tel == null){
			swal("Upss!", "El campo Telefono esta vacio.", "error");
		} else {
			
			swal({
				  title: "Creacion de Tenant",
				  text: "Esta accion creara un nuevo esquema en la Base de datos, esta seguro que desea crear el tenant?",
				  type: "info",
				  showCancelButton: true,
				  closeOnConfirm: false,
				  showLoaderOnConfirm: true,
				}, function(){
					
					serviciosRestRequest.creaTenant($scope.tenant.idTipo, $scope.tenant.idNum, $scope.tenant.nom,
							$scope.tenant.dir, $scope.tenant.tel).success(function (data){

						$scope.tenantResp = data;
						if( $scope.tenantResp.validacion == true ){
							$scope.tenant = {};
							swal($scope.tenantResp.mensaje, "", "success");
						} else {
							swal($scope.tenantResp.mensaje, "", "error");
						}
							
					});
				});
			
		}
		
	}

}
