
'use strict';

angular.module('productos', ['serviciosRest'])

.controller('productosController', ['$scope', 'serviciosRestRequest',productosController]);

function productosController($scope, serviciosRestRequest) {
	
	//Contiene los input del front
	$scope.productos = {};
	
	//Contiene la data de respuesta
	$scope.productosResp = {};
	
	//Productos de la grilla
	$scope.productosGrid = {};
	
	$scope.grilla_productos = false;
	
	/*
	 * Se encarga de borrar un producto
	 */
	$scope.borrarProducto = function(productoBorrar) {
		
		productoBorrar.usuario = $scope.valUsu.usuario;
		
		swal({
			title: "Eliminar Registro",
			text: "Esta accion eliminara el producto en la Base de datos, esta seguro que desea eliminar el producto?",
			type: "warning",
			showCancelButton: true,
			closeOnConfirm: false,
			showLoaderOnConfirm: true,
		}, function(){
			
			serviciosRestRequest.eliminaProducto(productoBorrar).success(function (data){
							
				$scope.productosResp = data;
				if( $scope.productosResp.validacion == true ){
					$scope.productos = {};
					swal($scope.productosResp.mensaje, "", "success");
				} else {
					swal($scope.productosResp.mensaje, "", "error");
				}
				
			});
		});
		
	}
	
	$scope.ProductoCancelar = function() {
		$scope.grilla_productos = false;
		$scope.productos = {};
		$scope.productosResp = {};
	}

	/*
	 * Metodo para consultar los productos
	 */
	$scope.ProductoConsultar = function() {
		
		$scope.productosResp = {};
		
		var json_producto = {
			idproducto : $scope.productos.id,
			nombreproducto : $scope.productos.nombre,
			idtipomedida : $scope.productos.medidaTipo,
			descripcion : $scope.productos.descri,
			usuario : $scope.valUsu.usuario
		};
		
		serviciosRestRequest.consultaProducto(json_producto).success(function (data){
			
			$scope.productosResp = data;
			if( $scope.productosResp.validacion == true ){
				
				$scope.grilla_productos = true;
				$scope.productosGrid = $scope.productosResp.objeto;
				
			} else {
				$scope.grilla_productos = false;
				swal($scope.productosResp.mensaje, "", "error");
			}
			
		});
		
	}
	
	/*
	 * Metodo para guardar un producto
	 */
	$scope.ProductoRegistrar = function() {
		
		if($scope.productos.nombre == null){
			swal("Upss!", "El campo Nombre esta vacio.", "error");
		}else if($scope.productos.medidaTipo == null){
			swal("Upss!", "El campo Medida esta vacio.", "error");
		}else if($scope.productos.descri == null){
			swal("Upss!", "El campo Descripcion esta vacio.", "error");
		}else{
			
			swal({
				title: "Creacion de Producto",
				text: "Esta accion creara un nuevo producto en la Base de datos, esta seguro que desea crear el Producto?",
				type: "info",
				showCancelButton: true,
				closeOnConfirm: false,
				showLoaderOnConfirm: true,
			}, function(){
					
				var json_producto = {
					nombreproducto : $scope.productos.nombre,
					idtipomedida : $scope.productos.medidaTipo,
					descripcion : $scope.productos.descri,
					usuario : $scope.valUsu.usuario
				};

				serviciosRestRequest.creaProducto(json_producto).success(function (data){
								
					$scope.productosResp = data;
					if( $scope.productosResp.validacion == true ){
						$scope.productos = {};
						swal($scope.productosResp.mensaje, "", "success");
					} else {
						swal($scope.productosResp.mensaje, "", "error");
					}
					
				});
			});
		}	
	}
	
}
