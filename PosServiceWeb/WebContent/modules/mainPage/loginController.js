'use strict';

angular.module('login', ['serviciosRest'])

.controller('loginController', ['$scope','serviciosRestRequest',loginController]);

function loginController($scope, serviciosRestRequest) {
	
//	$scope.posts={};
	$scope.loginFunction = function(){
		
		//alert("login");
		
		var json = serviciosRestRequest.validar().success(function (data){
			
			alert("success: "+data);
			$scope.posts=data;
			
//			$scope.posts=data; // Asignaremos los datos de todos los posts
//			$scope.posts.exist=1;
		});
		
		alert("json: "+json);
		
		
		
		
		
	};
	
//	$scope.getPost = function(){
//		$scope.unPost={};
//		testRequest.post($scope.post_id).success(function (data){
//			$scope.unPost=data; // Asignaremos los datos del post
//			$scope.unPost.exist=1;
//			$scope.posts.exist=0;
//		});
//	};
	
}



/////////////////////////////////////////////////////
//'use strict';
//
//angular.module('login')
//
//.controller('loginController', ['$scope', '$http',
//    function($scope, $http) {
//	
//		var path = "http://localhost:8080/Core/";//API path
//	
//		$scope.loginFunction = function() {
//			
//			//alert("path: "+path+'someservice/getusuario');
//			alert(ruta);
//			var global = $http.get(path+'someservice/getusuario');
//			alert("Respuesta: "+global);
//			return global;
//			
//			//$scope.login = !$scope.login;
//			
////			$http.get(path+'someservice/getusuario').success(function(data) {
////				
////				alert("Respuesta: "+data);
////				
////				//$scope.films = data;
////			});
//			
//		};
//		
//		
//	}
//]);






//'use strict';
//
//angular.module('login')
//
//.controller('loginController', function($scope) {
//	
//	$scope.loginFunction = function() {
//	    $scope.login = !$scope.login;
//	};
//	
//});