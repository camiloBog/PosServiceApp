
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
	$scope.ingreso_btnIngreso = true;
	
	
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
	
	
	$scope.IngresoCancelar = function() {
		$scope.movimiento = {};
		$scope.movimientoTemp = {};
		$scope.movimientoResp = {};
		$scope.ingresoGrilla = [];
		$scope.ingresoFinal = {};
		$scope.ingreso_btnIngreso = true;
		$scope.ingreso_btnConsultar = true;
		$scope.grilla_ingresos = true;
		$scope.grilla_movimientos = false;
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
			
			//Trae el nombre del producto para que se observe en la grilla
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
						$scope.ingreso_btnIngreso = false;
						
						swal($scope.movimientoResp.mensaje, "", "success");
					} else {
						swal($scope.movimientoResp.mensaje, "", "error");
					}
				});
			});
		}	
	}
	
	
	$scope.consultaMovimientosGrilla = {};
	
	$scope.IngresoConsultar = function() {
		
		$scope.ingresosResp = {};
		
		var json_producto = {
			idmovimiento : $scope.movimiento.id,
			idpersona : $scope.movimiento.proveedorId,
			usuario : $scope.valUsu.usuario
		};
		
		$scope.movimientoResp = {};
		
		serviciosRestRequest.consultaIngresoProductos(json_producto).success(function (data){
			
			$scope.movimientoResp = data;
			
			if( $scope.movimientoResp.validacion == true ){
				
				$scope.consultaMovimientosGrilla = $scope.movimientoResp.objeto;
				
				
				
				$scope.ingreso_btnConsultar = false;
				$scope.ingreso_btnIngreso = false;
				$scope.grilla_ingresos = false;
				$scope.grilla_movimientos = true;
				
				$scope.ingresoFinal = {};
				$scope.ingresoGrilla = [];
				
			}else {
				swal($scope.movimientoResp.mensaje, "", "error");
			}
						
		});
		
	}
	
	$scope.formatDate = function (date) {
	    function pad(n) {
	        return n < 10 ? '0' + n : n;
	    }

	    return date && 
	    pad(date.getDate()
        + '-' + pad(date.getMonth() + 1)
        + '-' + date.getFullYear() )
        ;
	};

	$scope.VerFecha = function() {
		$scope.verCalendario = !$scope.verCalendario;		
	}
	
	$scope.VerMovimiento = function(movimiento) {
		
		var txt = "<h1 style='display: table-row-group; text-align: right;' >Fecha de Ingreso: "+movimiento.fecha+"<h1>";
		
		txt += "<table>";
		
		txt += "<tr>";
		txt += "<th>Cliente: "+movimiento.nombre+"</th>";
		txt += "<th>Documento: "+movimiento.identificacion+"</th>";
		txt += "</tr>";
		
		txt += "</table>";
		
		var movimientos = movimiento.detallemovimiento;
		
		txt += "<BR>";
		
		txt += "<table>";
		
		txt += "<tr>";
		txt += "<th>Producto</th>";
		txt += "<th>Cantidad</th>";
		txt += "<th>Precio</th>";
		txt += "<th>Total</th>";
		txt += "</tr>";
		
		for ( var index in movimientos ) {
			var movimi = movimientos[index];
			
			txt += "<tr>";
			txt += "<th>"+movimi.nombreproducto+"</th>";
			txt += "<th>"+movimi.cantidad+"</th>";
			txt += "<th>$"+movimi.valorunitario+"</th>";
			txt += "<th>$"+movimi.valor+"</th>";
			txt += "</tr>";
			
		}
		
		txt += "<tr>";
		txt += "<th></th>";
		txt += "<th></th>";
		txt += "<th>TOTAL</th>";
		txt += "<th>$"+movimiento.valorTotal+"</th>";
		txt += "</tr>";
		
		txt += "</table>";
		
		swal({
			title: "Ingreso #"+movimiento.idFactura,
			text: txt,
			html: true
		});
	}

	
}
