
'use strict';

angular.module('ingreso', ['serviciosRest'])

.controller('ingresoController', ['$scope', 'serviciosRestRequest', ingresoController]);

function ingresoController($scope, serviciosRestRequest) {
	
	//Contiene los input del front
	$scope.movimiento = {};
	
	//Contiene los input de la grilla
	$scope.movimientoTemp = {};
	
	$scope.movimientoResp = {};
	
	$scope.grilla_ingresos = true;
	
	var json_usuario = {
		usuario : $scope.valUsu.usuario,
	};
	
	//Carga la lista de proveedores
	$scope.proveedoresList = {};
	serviciosRestRequest.consultaProveedor(json_usuario).success(function (data){
		$scope.proveedoresList = data.objeto;
	});
	
	//Carga la lista de productos
	$scope.productosList = {};
	serviciosRestRequest.consultaProducto(json_usuario).success(function (data){
		$scope.productosList = data.objeto;
	});
	
	$scope.patternNumeric=/^[0-9]*$/;
	var regexp = /^[\ |0-9]{0,10}$/;
	
	$scope.ingresoGrilla = [];
	$scope.agregarIngreso = function(json_movimiento) {
		

		if (json_movimiento.idproducto == null || json_movimiento.idproducto == "") {
			swal("Upss!", "El campo Producto esta vacio.", "error");
		} else if (json_movimiento.cantidad == null || json_movimiento.cantidad == "") {
			swal("Upss!", "El campo Cantidad esta vacio.", "error");
		} else if (json_movimiento.valor == null || json_movimiento.valor == "") {
			swal("Upss!", "El campo Valor Unitario esta vacio.", "error");
		} else if (!regexp.test(json_movimiento.cantidad)) {
			swal("Upss!", "El campo Cantidad debe ser numerico.", "error");
		} else if (!regexp.test(json_movimiento.valor)) {
			swal("Upss!", "El campo Valor Unitario debe ser numerico.", "error");
		}else{
			$scope.ingresoGrilla.push({
				idproducto : json_movimiento.idproducto,
				cantidad : json_movimiento.cantidad,
				valor : json_movimiento.valor,
				observacion : json_movimiento.observacion
			});
			
			console.log($scope.ingresoGrilla);
			
			$scope.movimientoTemp = {};
		}
	}
	
	$scope.ingresoFinal = {};
	$scope.IngresoRegistrar  = function() {

		$scope.ingresoFinal.usuario = $scope.valUsu.usuario;
		$scope.ingresoFinal.idpersona = $scope.movimiento.proveedorId;
		$scope.ingresoFinal.detallemovimiento = $scope.ingresoGrilla;
		
		if($scope.ingresoFinal.idpersona == null || $scope.ingresoFinal.idpersona == "" ){
			swal("Upss!", "El campo Proveedor esta vacio.", "error");
		}else{
			
			swal({
				title: "Creacion de Movimiento",
				text: "Esta accion creara un nuevo Ingreso de Productos en la Base de datos, esta seguro que desea crear el Ingreso?",
				type: "info",
				showCancelButton: true,
				closeOnConfirm: false,
				showLoaderOnConfirm: true,
			}, function(){

				serviciosRestRequest.creaIngresoProductos($scope.ingresoFinal).success(function (data){
								
					$scope.movimientoResp = data;
					if( $scope.movimientoResp.validacion == true ){
						swal($scope.movimientoResp.mensaje, "", "success");
					} else {
						swal($scope.movimientoResp.mensaje, "", "error");
					}
					
				});
				
			});
		}	
		
	}

	
}
