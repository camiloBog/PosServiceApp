
'use strict';

angular.module('usuario', ['serviciosRest'])

.controller('usuarioController', ['$scope', 'serviciosRestRequest',usuarioController]);

function usuarioController($scope, serviciosRestRequest) {
	
	//Contiene los input del front
	$scope.confUsu = {};
	
	//Contiene la data de respuesta
	$scope.confUsuResp = {};
	
	//Usuarios de la grilla
	$scope.usuariosGrid = {};
	
	$scope.grilla_usuarios = false;

	$scope.UsuarioConsultar = function() {
		
		$scope.confUsuResp = {};
		
		var json_usuario = {
				usuario : $scope.confUsu.usu,
				nombre : $scope.confUsu.nom,
				apellidos : $scope.confUsu.ape,
				contrasena : $scope.confUsu.pass,
				idperfil : $scope.confUsu.perfil,
				idtenant : $scope.confUsu.IdTenant
		};
		
		serviciosRestRequest.consultaUsuario(json_usuario).success(function (data){
			
			$scope.confUsuResp = data;
			if( $$scope.confUsuResp.validacion == true ){
				
				$scope.grilla_usuarios = true;
				$scope.usuariosGrid = $scope.confUsuResp.objeto;
				
			} else {
				$scope.grilla_usuarios = false;
				swal($scope.confUsuResp.mensaje, "", "error");
			}
			
		});
		
		
	}
	
	$scope.UsuarioCancelar = function() {
		$scope.confUsu = {};
		$scope.usuariosGrid = {};
		$scope.confUsuResp = {};
		$scope.grilla_usuarios = false;
	}
	
	$scope.UsuarioCrear = function() {
		
		if($scope.confUsu.usu == null || $scope.confUsu.usu == ""){
			swal("Upss!", "El campo Usuario esta vacio.", "error");
		}else if($scope.confUsu.nom == null || $scope.confUsu.nom == ""){
			swal("Upss!", "El campo Nombre esta vacio.", "error");
		}else if($scope.confUsu.ape == null || $scope.confUsu.ape == ""){
			swal("Upss!", "El campo Apellidos esta vacio.", "error");
		}else if($scope.confUsu.pass == null || $scope.confUsu.pass == ""){
			swal("Upss!", "El campo Contraseña esta vacio.", "error");
		}else if($scope.confUsu.perfil == null || $scope.confUsu.perfil == ""){
			swal("Upss!", "El campo Perfil esta vacio.", "error");
		}else if($scope.confUsu.IdTenant == null || $scope.confUsu.IdTenant == ""){
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
