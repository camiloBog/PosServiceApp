
'use strict';

angular.module('tenan', ['serviciosRest'])

.controller('tenanController', ['$scope', 'serviciosRestRequest',tenanController]);

function tenanController($scope, serviciosRestRequest) {
	
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
			
			var json_tenant = {
					tipoidentificacion : $scope.tenant.idTipo,
					identificacion : $scope.tenant.idNum,
					nombre : $scope.tenant.nom,
					direccion : $scope.tenant.dir,
					telefono : $scope.tenant.tel
				};

			swal({
				  title: "Creacion de Tenant",
				  text: "Esta accion creara un nuevo esquema en la Base de datos, esta seguro que desea crear el tenant?",
				  type: "info",
				  showCancelButton: true,
				  closeOnConfirm: false,
				  showLoaderOnConfirm: true,
				}, function(){
					
					
					
					serviciosRestRequest.creaTenant(json_tenant).success(function (data){

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
