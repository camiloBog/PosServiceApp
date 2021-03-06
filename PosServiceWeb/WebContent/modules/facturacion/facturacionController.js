
'use strict';

angular.module('facturacion', ['serviciosRest'])

.controller('facturacionController', ['$scope', 'serviciosRestRequest', facturacionController]);

function facturacionController($scope, serviciosRestRequest) {
	
	//Contiene el valor y el texto de la factura
	$scope.totaliza = {};
	$scope.totaliza.totalPesos ='$ 0';
	$scope.totaliza.total = 0;
	
	$scope.verCalendario = false;
	
	$scope.fecha_seleccion;
	
	//Contiene los input del front
	$scope.cliente = {};
	
	//Contiene los input de la grilla
	$scope.movimientoTemp = {};
	$scope.movimientoResp = {};
	$scope.facturacion = {};
	
	$scope.grilla_facturacion = true;
	$scope.grilla_consulta_facturacion = false;
	$scope.facturacion_pedido = false;
	$scope.facturacion_btnConsultar = true;
	$scope.facturacion_btnRegistrar = true;
	
	var json_usuario = {
		usuario : $scope.valUsu.usuario,
	};
	
	//Carga la lista de productos
	$scope.productosList = {};
	serviciosRestRequest.consultaProducto(json_usuario).success(function (data){
		$scope.productosList = data.objeto;
	});
	
	
	$scope.consultaFacturacionGrilla = {};
	//Consulta la facturacion
	$scope.FacturacionConsultar = function() {
		
		$scope.facturacionFinal.idFactura = $scope.cliente.idMovimiento;
		$scope.facturacionFinal.usuario = $scope.valUsu.usuario;
		$scope.facturacionFinal.nombre = $scope.cliente.nombre;
		$scope.facturacionFinal.fecha = $scope.fecha_seleccion;
		$scope.facturacionFinal.identificacion = $scope.cliente.identificacion;
		$scope.facturacionFinal.idtipoidentificacion = $scope.cliente.idtipoidentificacion;

		serviciosRestRequest.consultafacturacionProductos($scope.facturacionFinal).success(function (data){

			$scope.facturacion = data;
			if( $scope.facturacion.validacion == true ){
				
				$scope.consultaFacturacionGrilla = $scope.facturacion.objeto;
				
				
				$scope.facturacion_pedido = true;
				$scope.facturacion_btnRegistrar = false;
				$scope.facturacion_btnConsultar = false;
				$scope.grilla_facturacion = false;
				$scope.grilla_consulta_facturacion = true;
				$scope.facturacionGrilla = [];
				
			}else {
				swal($scope.facturacion.mensaje, "", "error");
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
	
	$scope.VerFactura = function(factura) {
		
		var txt = "<h1 style='display: table-row-group; text-align: right;' >Fecha de Compra: "+factura.fecha+"<h1>";
		
		txt += "<table>";
		
		txt += "<tr>";
		txt += "<th>Cliente: "+factura.nombre+"</th>";
		txt += "<th>Documento: "+factura.identificacion+"</th>";
		txt += "</tr>";
		
		txt += "</table>";
		
		var productos = factura.detallemovimiento;
		
		txt += "<BR>";
		
		txt += "<table>";
		
		txt += "<tr>";
		txt += "<th>Producto</th>";
		txt += "<th>Cantidad</th>";
		txt += "<th>Precio</th>";
		txt += "<th>Total</th>";
		txt += "</tr>";
		
		for ( var index in productos ) {
			var producto = productos[index];
			
			txt += "<tr>";
			txt += "<th>"+producto.nombreproducto+"</th>";
			txt += "<th>"+producto.cantidad+"</th>";
			txt += "<th>$"+producto.valorunitario+"</th>";
			txt += "<th>$"+producto.valor+"</th>";
			txt += "</tr>";
			
		}
		
		txt += "<tr>";
		txt += "<th></th>";
		txt += "<th></th>";
		txt += "<th>TOTAL</th>";
		txt += "<th>$"+factura.valorTotal+"</th>";
		txt += "</tr>";
		
		txt += "</table>";
		
		swal({
			title: "Factura #"+factura.idFactura,
			text: txt,
			html: true
		});
	}
	

	$scope.FacturacionCancelar = function() {
		$scope.totaliza = {};
		$scope.totaliza.totalPesos ='$ 0';
		$scope.totaliza.total = 0;
		$scope.cliente = {};
		$scope.movimientoTemp = {};
		$scope.movimientoResp = {};
		$scope.facturacion = {};
		$scope.facturacionGrilla = [];
		$scope.consultaFacturacionGrilla = {};
		$scope.facturacionFinal = {};
		$scope.facturacion_pedido = false;
		$scope.facturacion_btnRegistrar = true;
		$scope.facturacion_btnConsultar = true;
		$scope.grilla_facturacion = true;
		$scope.grilla_consulta_facturacion = false;
		$scope.fecha_seleccion = "";
		
	}
	
	var regexp = /^[\ |0-9]{0,10}$/;
	$scope.facturacionGrilla = [];
	
	//Agregar registros a la grilla
	$scope.agregarFacturacion = function(json_movimiento) {

		if (json_movimiento.idproducto == null || json_movimiento.idproducto == "") {
			swal("Upss!", "El campo Producto esta vacio.", "error");
		} else if (json_movimiento.cantidad == null || json_movimiento.cantidad == "") {
			swal("Upss!", "El campo Cantidad esta vacio.", "error");
		} else if (!regexp.test(json_movimiento.cantidad)) {
			swal("Upss!", "El campo Cantidad debe ser numerico.", "error");
		} else{
			
			$scope.facturacion_pedido = true;
			$scope.facturacion_btnConsultar = false;
			$scope.cliente.idMovimiento = "";
			
			//Procesa los datos para que sean mostrados en la grilla
			for (var i = 0; i < $scope.productosList.length; i++)
				if(json_movimiento.idproducto==$scope.productosList[i].idproducto){
					
					json_movimiento.nombreproducto=$scope.productosList[i].nombreproducto;
					json_movimiento.valorunitario=$scope.productosList[i].precioVenta;
					json_movimiento.valor=$scope.productosList[i].precioVenta * json_movimiento.cantidad;
					
					$scope.totaliza.total = $scope.totaliza.total + $scope.productosList[i].precioVenta * json_movimiento.cantidad;
					$scope.totaliza.totalPesos ='$ ' + $scope.totaliza.total;
				}
			
			$scope.facturacionGrilla.push({
				idproducto : json_movimiento.idproducto,
				nombreproducto : json_movimiento.nombreproducto,
				cantidad : json_movimiento.cantidad,
				valorunitario : json_movimiento.valorunitario,
				valor : json_movimiento.valor
			});
			
			$scope.movimientoTemp = {};
		}
	}
	
	//Elimina un registro de la grilla
	$scope.borrarFacturacion = function(json_movimiento) {
		
		$scope.totaliza.total = $scope.totaliza.total - json_movimiento.valor;
		$scope.totaliza.totalPesos ='$ ' + $scope.totaliza.total;
		
		$scope.facturacionGrilla.splice(
				$scope.facturacionGrilla.indexOf(json_movimiento), 1);
	}
	
	$scope.facturacionFinal = {};
	
	//Agrega registros a la base de datos
	$scope.FacturacionRegistrar  = function() {

		$scope.facturacionFinal.usuario = $scope.valUsu.usuario;
		$scope.facturacionFinal.nombre = $scope.cliente.nombre;
		$scope.facturacionFinal.identificacion = $scope.cliente.identificacion;
		$scope.facturacionFinal.idtipoidentificacion = $scope.cliente.idtipoidentificacion;
		$scope.facturacionFinal.detallemovimiento = $scope.facturacionGrilla;
		
		if($scope.facturacionFinal.nombre == null || $scope.facturacionFinal.nombre == "" ){
			swal("Upss!", "El campo Cliente esta vacio.", "error");
		} else if($scope.facturacionFinal.identificacion == null || $scope.facturacionFinal.identificacion == "" ){
			swal("Upss!", "El campo Identificacion esta vacio.", "error");
		} else if($scope.facturacionFinal.idtipoidentificacion == null || $scope.facturacionFinal.idtipoidentificacion == "" ){
			swal("Upss!", "El campo Tipo Id esta vacio.", "error");
		} else if($scope.facturacionGrilla == null || $scope.facturacionGrilla == "" ){
			swal("Upss!", "Debe haber por lo menos un producto.", "error");
		}else{
			
			swal({
				title: "Creacion de Factura",
				text: "Esta accion creara una venta de Productos en la Base de datos, esta seguro que desea crear la venta?",
				type: "info",
				showCancelButton: true,
				closeOnConfirm: false,
				showLoaderOnConfirm: true,
			}, function(){

				serviciosRestRequest.creafacturacionProductos($scope.facturacionFinal).success(function (data){
								
					$scope.movimientoResp = data;
					if( $scope.movimientoResp.validacion == true ){
						
						$scope.cliente.idMovimiento = $scope.movimientoResp.objeto;
						$scope.facturacion_pedido = true;
						$scope.facturacion_btnConsultar = false;
						$scope.facturacion_btnRegistrar = false;
						
						swal($scope.movimientoResp.mensaje, "", "success");
					} else {
						swal($scope.movimientoResp.mensaje, "", "error");
					}
				});
			});
		}	
	}

	
}