
'use strict';

angular.module('proveedores', ['serviciosRest'])

.controller('proveedoresController', ['$scope', 'serviciosRestRequest',proveedoresController]);

function proveedoresController($scope, serviciosRestRequest) {
	
	
	//Contiene los input del front
	$scope.proveedor = {};
	
	//Contiene la data de respuesta
	$scope.proveedorResp = {};
	
	//Productos de la grilla
	$scope.proveedorGrid = {};
	
	$scope.grilla_proveedor = false;
	
	/*
	 * Se encarga de borrar un proveedor
	 */
	$scope.borrarProveedor = function(proveedorBorrar) {
		
		proveedorBorrar.usuario = $scope.valUsu.usuario;
		
		swal({
			title: "Eliminar Registro",
			text: "Esta accion eliminara el proveedor en la Base de datos, esta seguro que desea eliminar el proveedor?",
			type: "warning",
			showCancelButton: true,
			closeOnConfirm: false,
			showLoaderOnConfirm: true,
		}, function(){
			
			serviciosRestRequest.eliminaProveedor(proveedorBorrar).success(function (data){
				
				$scope.proveedorResp = data;
				if( $scope.proveedorResp.validacion == true ){
					$scope.proveedor = {};
					swal($scope.proveedorResp.mensaje, "", "success");
				} else {
					swal($scope.proveedorResp.mensaje, "", "error");
				}
				
				//Si la grilla esta visible, la recarga.
				if($scope.grilla_proveedor == true){
					$scope.ProveedorConsultar();
				}
				
			});
		});
		
	}
	
	$scope.ProveedorCancelar = function() {
		$scope.grilla_proveedor = false;
		$scope.proveedor = {};
		$scope.proveedorResp = {};
	}

	/*
	 * Metodo para consultar los proveedores
	 */
	$scope.ProveedorConsultar = function() {
		
		$scope.proveedorResp = {};

		var json_proveedor = {
				
			idpersona : $scope.proveedor.idpersona,
			idtipopersona : $scope.proveedor.idtipopersona,
			idtipoidentificacion : $scope.proveedor.idTipo,
			identificacion : $scope.proveedor.identificacion,
			nombre : $scope.proveedor.nombre,
			direccion : $scope.proveedor.direccion,
			telefono : $scope.proveedor.telefono,
			correocontacto : $scope.proveedor.correocontacto,
			contacto : $scope.proveedor.contacto,
			usuario : $scope.valUsu.usuario,
			
		};
		
		serviciosRestRequest.consultaProveedor(json_proveedor).success(function (data){
			
			$scope.proveedorResp = data;
			if( $scope.proveedorResp.validacion == true ){
				
				$scope.grilla_proveedor = true;
				$scope.proveedorGrid = $scope.proveedorResp.objeto;
				
			} else {
				$scope.grilla_proveedor = false;
				swal($scope.proveedorResp.mensaje, "", "error");
			}
			
		});
		
	}
	
	/*
	 * Metodo para guardar un proveedor
	 */
	$scope.ProveedorRegistrar = function() {
		
		if($scope.proveedor.nombre == null || $scope.proveedor.nombre == ""){
			swal("Upss!", "El campo Nombre esta vacio.", "error");
		}else if($scope.proveedor.idTipo == null || $scope.proveedor.idTipo == ""){
			swal("Upss!", "El campo Tipo identificacion esta vacio.", "error");
		}else if($scope.proveedor.identificacion == null || $scope.proveedor.identificacion == ""){
			swal("Upss!", "El campo Identificacion esta vacio.", "error");
		}else if($scope.proveedor.direccion == null || $scope.proveedor.direccion == ""){
			swal("Upss!", "El campo Direccion esta vacio.", "error");
		}else if($scope.proveedor.telefono == null || $scope.proveedor.telefono == ""){
			swal("Upss!", "El campo Telefono esta vacio.", "error");
		}else if($scope.proveedor.correocontacto == null || $scope.proveedor.correocontacto == ""){
			swal("Upss!", "El campo Correo no es correcto.", "error");
		}else if($scope.proveedor.contacto == null || $scope.proveedor.contacto == ""){
			swal("Upss!", "El campo Contacto esta vacio.", "error");
		}else{
			
			swal({
				title: "Creacion de Proveedor",
				text: "Esta accion creara un nuevo proveedor en la Base de datos, esta seguro que desea crear el Proveedor?",
				type: "info",
				showCancelButton: true,
				closeOnConfirm: false,
				showLoaderOnConfirm: true,
			}, function(){
					
				var json_proveedor = {

						idtipoidentificacion : $scope.proveedor.idtipoidentificacion,
						identificacion : $scope.proveedor.identificacion,
						nombre : $scope.proveedor.nombre,
						direccion : $scope.proveedor.direccion,
						telefono : $scope.proveedor.telefono,
						correocontacto : $scope.proveedor.correocontacto,
						contacto : $scope.proveedor.contacto,
						usuario : $scope.valUsu.usuario,
						
				};

				serviciosRestRequest.creaProveedor(json_proveedor).success(function (data){
								
					$scope.proveedorResp = data;
					if( $scope.proveedorResp.validacion == true ){
						$scope.proveedor = {};
						swal($scope.proveedorResp.mensaje, "", "success");
					} else {
						swal($scope.proveedorResp.mensaje, "", "error");
					}
					
				});
			});
		}	
	}
	
	
}
