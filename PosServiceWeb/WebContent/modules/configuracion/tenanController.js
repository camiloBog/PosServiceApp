
'use strict';

angular.module('tenan', ['serviciosRest'])

.controller('tenanController', ['$scope', 'serviciosRestRequest',tenanController]);

function tenanController($scope, serviciosRestRequest) {
	
	//Valores del formulario
	$scope.tenant = {};
	
	//Valores de respuesta de los WS
	$scope.tenantResp = {};
	
	//Valores para la grilla
	$scope.tenantGrid = {};
	
	//Bandera para mostrar la grilla
	$scope.grilla_tenant = false;
	
	
	
	$scope.borrarTenant = function(tenantBorrar) {
		
		swal({
			title: "Eliminar Registro",
			text: "Esta accion eliminara el Tenant y el Esquema de la Base de datos, esta seguro que desea eliminar el Tenant y el Esquema?",
			type: "warning",
			showCancelButton: true,
			closeOnConfirm: false,
			showLoaderOnConfirm: true,
		}, function(){
			
			serviciosRestRequest.eliminaTenant(tenantBorrar).success(function (data){
				
				$scope.tenantResp = data;
				if( $scope.tenantResp.validacion == true ){
					$scope.tenant = {};
					swal($scope.tenantResp.mensaje, "", "success");
				} else {
					swal($scope.tenantResp.mensaje, "", "error");
				}
				
				//Si la grilla esta visible, la recarga.
				if($scope.grilla_tenant == true){
					$scope.consultarTenant();
				}
				
			});
		});
		
	}
	
	$scope.consultarTenant = function() {
		
		$scope.tenantResp = {};
				
		var json_tenant = {
			idtenant : $scope.productos.idtenant,
			tipoidentificacion : $scope.productos.tipoidentificacion,
			identificacion : $scope.productos.identificacion,
			nombre : $scope.productos.nombre,
			direccion : $scope.productos.direccion,
			telefono : $scope.productos.telefono
		};
		
		serviciosRestRequest.consultaTenant(json_tenant).success(function (data){
			
			$scope.tenantResp = data;
			if( $scope.tenantResp.validacion == true ){
				
				$scope.grilla_tenant = true;
				$scope.tenantGrid = $scope.tenantResp.objeto;
				
			} else {
				$scope.grilla_tenant = false;
				swal($scope.tenantResp.mensaje, "", "error");
			}
			
		});
	}
	
	$scope.cancelar = function() {
		
		$scope.tenant = {};
		$scope.tenantResp = {};
		$scope.tenantGrid = {};
		$scope.grilla_tenant = false;
		
	}

	$scope.crear = function() {
		
		if($scope.tenant.nom == null || $scope.tenant.nom ==""){
			swal("Upss!", "El campo Nombre esta vacio.", "error");
		} else if ($scope.tenant.idTipo == null || $scope.tenant.idTipo == ""){
			swal("Upss!", "El campo Tipo de Identificacion esta vacio.", "error");
		} else if ($scope.tenant.idNum == null || $scope.tenant.idNum == ""){
			swal("Upss!", "El campo Identificacion esta vacio.", "error");
		} else if ($scope.tenant.dir == null || $scope.tenant.dir == ""){
			swal("Upss!", "El campo Direccion esta vacio.", "error");
		} else if ($scope.tenant.tel == null || $scope.tenant.tel == ""){
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
