
'use strict';

angular.module('usuario', ['serviciosRest'])

.controller('usuarioController', ['$scope', 'serviciosRestRequest',usuarioController]);

function usuarioController($scope, serviciosRestRequest) {
	
	//Contiene los input del front
	$scope.confUsu = {};
	
	//Contiene la data de respuesta
	$scope.confUsuResp = {};

	$scope.UsuarioConsultar = function() {
		swal("Upss! UsuarioConsultar", "Hace falta implementar este metodo!", "error");
	}
	
	$scope.UsuarioCancelar = function() {
		$scope.confUsu = {};
	}
	
	$scope.UsuarioCrear = function() {
		
		if($scope.confUsu.usu == null){
			swal("Upss!", "El campo Usuario esta vacio.", "error");
		}else if($scope.confUsu.nom == null){
			swal("Upss!", "El campo Nombre esta vacio.", "error");
		}else if($scope.confUsu.ape == null){
			swal("Upss!", "El campo Apellidos esta vacio.", "error");
		}else if($scope.confUsu.pass == null){
			swal("Upss!", "El campo Contraseña esta vacio.", "error");
		}else if($scope.confUsu.perfil == null){
			swal("Upss!", "El campo Perfil esta vacio.", "error");
		}else if($scope.confUsu.IdTenant == null){
			swal("Upss!", "El campo Tenant esta vacio.", "error");
		}else{
			
			swal({
				title: "Creacion de Usuario",
				text: "Esta accion creara un nuevo usuario en la Base de datos, esta seguro que desea crear el usuario?",
				type: "info",
				showCancelButton: true,
				closeOnConfirm: false,
				showLoaderOnConfirm: true,
			}, function(){
					
				var json_usuario = {
					usuario : $scope.confUsu.usu,
					nombre : $scope.confUsu.nom,
					apellidos : $scope.confUsu.ape,
					contrasena : $scope.confUsu.pass,
					idperfil : $scope.confUsu.perfil,
					idtenant : $scope.confUsu.IdTenant
				};

				serviciosRestRequest.creaUsuario(json_usuario).success(function (data){
								
					$scope.confUsuResp = data;
					if( $scope.confUsuResp.validacion == true ){
						$scope.confUsu = {};
						swal($scope.confUsuResp.mensaje, "", "success");
					} else {
						swal($scope.confUsuResp.mensaje, "", "error");
					}
					
				});
			});
			
		}

	}

}
