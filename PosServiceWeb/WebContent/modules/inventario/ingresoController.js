
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
	$scope.grilla_movimientos = false;
	$scope.ingreso_pedido = false;
	$scope.ingreso_btnConsultar = true;
	
	
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
	
	$scope.IngresoConsultar = function() {
		
		$scope.grilla_movimientos = true;
		alert("Por implementar...");

	}
	
	
	$scope.IngresoCancelar = function() {
		$scope.movimiento = {};
		$scope.movimientoTemp = {};
		$scope.movimientoResp = {};
		$scope.ingresoGrilla = [];
		$scope.ingresoFinal = {};
		$scope.ingreso_pedido = false;
		$scope.ingreso_btnConsultar = true;
	}
	
	var regexp = /^[\ |0-9]{0,10}$/;
	$scope.ingresoGrilla = [];
	
	//Agregar registros a la grilla
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
			
			$scope.ingreso_pedido = true;
			$scope.ingreso_btnConsultar = false;
			$scope.movimiento.id = "";
			
			for (var i = 0; i < $scope.productosList.length; i++)
				if(json_movimiento.idproducto==$scope.productosList[i].idproducto)
					json_movimiento.nombreproducto=$scope.productosList[i].nombreproducto;

			$scope.ingresoGrilla.push({
				idproducto : json_movimiento.idproducto,
				nombreproducto : json_movimiento.nombreproducto,
				cantidad : json_movimiento.cantidad,
				valor : json_movimiento.valor,
				observacion : json_movimiento.observacion
			});
			
			$scope.movimientoTemp = {};
		}
	}
	
	//Elimina un registro de la grilla
	$scope.borrarIngreso = function(json_movimiento) {
		$scope.ingresoGrilla.splice(
				$scope.ingresoGrilla.indexOf(json_movimiento), 1);
	}
	
	$scope.ingresoFinal = {};
	//Agrega registros a la base de datos
	$scope.IngresoRegistrar  = function() {

		$scope.ingresoFinal.usuario = $scope.valUsu.usuario;
		$scope.ingresoFinal.idpersona = $scope.movimiento.proveedorId;
		$scope.ingresoFinal.detallemovimiento = $scope.ingresoGrilla;
		
		if($scope.ingresoFinal.idpersona == null || $scope.ingresoFinal.idpersona == "" ){
			swal("Upss!", "El campo Proveedor esta vacio.", "error");
		}else if($scope.ingresoGrilla == null || $scope.ingresoGrilla == "" ){
			swal("Upss!", "Debe haber por lo menos un producto.", "error");
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
						
						$scope.movimiento.id = $scope.movimientoResp.objeto;
						$scope.ingreso_pedido = true;
						$scope.ingreso_btnConsultar = false;
						
						swal($scope.movimientoResp.mensaje, "", "success");
					} else {
						swal($scope.movimientoResp.mensaje, "", "error");
					}
				});
			});
		}	
	}

	
}
