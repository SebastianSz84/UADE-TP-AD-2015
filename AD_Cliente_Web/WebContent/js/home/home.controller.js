/**
 * Created by gusta on 23/11/2015.
 */
angular.module('distribuidas')
    .controller('HomeCtrl', function($scope, $http, $rootScope, $timeout) {
        $scope.cotizaciones = [];
        $scope.rodamientos = [];
        $scope.armandoCot = false;
        $rootScope.nroCliente = 2;
        $scope.datos = { openCot:0};

        $scope.verCotizaciones = function(){
            $scope.armandoCot = false;
            $scope.msg = '';
            $scope.error = '';
            
            /*if ($scope.cotizaciones.length > 0){
            	return;
            }*/
            $http({
                'data': { 'nroCliente' : $rootScope.nroCliente},
                'method':'post',
                'url':'http://localhost:8080/AD_Cliente_Web/ServletListCotizaciones'
            })
            .success(function (data) {
                console.log(data);
                $scope.cotizaciones = [];
                $scope.cotizaciones = data;
            }).
            error(function (data, status) {
                console.log(data);
                console.log(status);
            });
        };

        $scope.armarCotizacion = function(){
            $scope.armandoCot = true;
            $scope.msg = '';
            $scope.error = '';
            
            if ($scope.rodamientos.length > 0){
            	return;
            }
            
            $http({
                'method':'get',
                'url':'http://localhost:8080/AD_Cliente_Web/ServletCrearCot'
            })
            .success(function (data) {
                console.log(data);
                $scope.rodamientos = data;
            }).
            error(function (data, status) {
                $scope.showError();
                console.log(data);
                console.log(status);
            });
        };
        
        $scope.generarCotizacion = function(rodamientos){
        	var listaItems = [];
        	for (var i=0; rodamientos.length > i; i ++){
        		console.log(rodamientos[i]);
        		if (rodamientos[i].cantidad && Number(rodamientos[i].cantidad) > 0){
        			listaItems.push({ 'codigoSKF':rodamientos[i].codigoSKF, 'cantidad':rodamientos[i].cantidad});
        		}
        	}
        	var data = { 'nroCliente': $rootScope.nroCliente, 'items': listaItems};
        	console.log(data);
        	$http({
        		'data': data,
                'method':'post',
                'url':'http://localhost:8080/AD_Cliente_Web/ServletCrearCot'
            })
            .success(function (data) {
                console.log(data);
                if (data == 'true'){
                	$scope.rodamientos = [];
                	$scope.msg = 'Cotizacion creada';
                } else {
                	$scope.showError();
                }
            }).
            error(function (data, status) {
                $scope.showError();
                console.log(data);
                console.log(status);
            });
        };
        
        $scope.aceptarCotizacion = function(cotId){
        	var data = { 'nroCliente': $rootScope.nroCliente, 'cotId': cotId};
        	$http({
        		'data': data,
                'method':'post',
                'url':'http://localhost:8080/AD_Cliente_Web/ServletAceptarCot'
            })
            .success(function (data) {
                console.log(data);
                if (data == 'true'){
                	$scope.msg = 'Cotizacion Aceptada';
                	$timeout(function(){
                    	$scope.verCotizaciones();
                	}, 1000);
                } else {
                	$scope.showError();
                }
            }).
            error(function (data, status) {
                $scope.showError();
                console.log(data);
                console.log(status);
            });
        };

        $scope.showError = function(){
            $scope.error = 'Ocurrio un error';
        };
        
        $scope.verCotizaciones();
    });