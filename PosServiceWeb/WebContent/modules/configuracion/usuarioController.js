
'use strict';

angular.module('usuario', ['serviciosRest'])

.controller('usuarioController', ['$scope', 'serviciosRestRequest',usuarioController]);

function usuarioController($scope, serviciosRestRequest) {
	
	//Contiene los input del front
	$scope.confUsu = {};
	
	//Contiene la data de respuesta
	$scope.usuariosResp = {};
	
	//Usuarios de la grilla
	$scope.usuariosGrid = {};
	
	$scope.grilla_usuarios = false;
	
	/*
	 * Se encarga de borrar un usuario
	 */
	$scope.borrarUsuario = function(usuarioBorrar) {
		
		swal({
			title: "Eliminar Usuario",
			text: "Esta accion eliminara el usuario en la Base de datos, esta seguro que desea eliminar el Usuario?",
			type: "warning",
			showCancelButton: true,
			closeOnConfirm: false,
			showLoaderOnConfirm: true,
		}, function(){
			
			serviciosRestRequest.eliminaUsuario(usuarioBorrar).success(function (data){
				
				$scope.usuariosResp = data;				
				if( $scope.usuariosResp.validacion == true ){
					swal($scope.usuariosResp.mensaje, "", "success");
				} else {
					swal($scope.usuariosResp.mensaje, "", "error");
				}
				
				//Si la grilla esta visible, la recarga.
				if($scope.grilla_usuarios == true){
					$scope.UsuarioConsultar();
				}
				
			});
		});
		
	}

	$scope.UsuarioConsultar = function() {
		
		$scope.usuariosResp = {};
		
		var json_usuario = {
				usuario : $scope.confUsu.usu,
				nombre : $scope.confUsu.nom,
				apellidos : $scope.confUsu.ape,
				contrasena : $scope.confUsu.pass,
				idperfil : $scope.confUsu.perfil,
				idtenant : $scope.confUsu.IdTenant,
		};
		
		serviciosRestRequest.consultaUsuario(json_usuario).success(function (data){
			
			$scope.usuariosResp = data;
			if( $scope.usuariosResp.validacion == true ){
				
				$scope.grilla_usuarios = true;
				$scope.usuariosGrid = $scope.usuariosResp.objeto;
				
				//Trae los nombre de los perfiles
				for (var i = 0; i < $scope.usuariosGrid.length; i++)
					for (var j = 0; j < $scope.tiposPerfil.length; j++)
						if( $scope.usuariosGrid[i].idperfil == $scope.tiposPerfil[j].idperfil )
							//$scope.usuariosGrid[i].idperfil = $scope.tiposPerfil[j].descripcion;
							$scope.usuariosGrid[i].descripcion = $scope.tiposPerfil[j].descripcion;
						

			} else {
				$scope.grilla_usuarios = false;
				swal($scope.usuariosResp.mensaje, "", "error");
			}
			
		});
		
		
	}
	
	$scope.UsuarioCancelar = function() {
		$scope.confUsu = {};
		$scope.usuariosGrid = {};
		$scope.usuariosResp = {};
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
								
					$scope.usuariosResp = data;
					if( $scope.usuariosResp.validacion == true ){
						$scope.confUsu = {};
						swal($scope.usuariosResp.mensaje, "", "success");
					} else {
						swal($scope.usuariosResp.mensaje, "", "error");
					}
					
				});
			});
			
		}

	}

}
