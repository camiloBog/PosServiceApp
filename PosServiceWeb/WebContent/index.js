'use strict';

// declaracion de modulos modules
angular.module('tenan', []);
angular.module('usuario', []);
angular.module('inventario', []);
angular.module('ventas', []);
angular.module('facturacion', []);
angular.module('ingreso', []);
angular.module('productos', []);
angular.module('proveedores', []);
angular.module('login', []);
angular.module('serviciosRest', []);

// se agregan los modulos
var mainApp = angular.module('mainApp', [
    'ngRoute', 'ngResource', 
    'serviciosRest',
    'tenan', 'usuario', 'inventario', 
    'ventas', 'facturacion', 'ingreso', 
    'productos', 'proveedores', 'login'
]);

// enrutamiento
mainApp.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.
	
	when('/tenan', {
		templateUrl : 'modules/configuracion/tenan.html',
		controller: "tenanController"
	}).
	
	when('/usuario', {
		templateUrl : 'modules/configuracion/usuario.html',
		controller: "usuarioController"
	}).
	
	when('/inventario', {
		templateUrl : 'modules/consultas/inventario.html',
		controller: "inventarioController"
	}).
	
	when('/ventas', {
		templateUrl : 'modules/consultas/ventas.html',
		controller: "ventasController"
	}).
	
	when('/facturacion', {
		templateUrl : 'modules/facturacion/facturacion.html',
		controller: "facturacionController"
	}).
	
	when('/ingreso', {
		templateUrl : 'modules/inventario/ingreso.html',
		controller: "ingresoController"
	}).
	
	when('/productos', {
		templateUrl : 'modules/inventario/productos.html',
		controller: "productosController"
	}).
	
	when('/proveedores', {
		templateUrl : 'modules/inventario/proveedores.html',
		controller: "proveedoresController"
	}).
	
	when('/login', {
		templateUrl : 'modules/mainPage/login.html',
		controller: "loginController"
	}).
	
	when('/home', {
		templateUrl : 'modules/mainPage/home.html'
	}).
	
	otherwise({
		redirectTo : '/home'
	});

} ]);