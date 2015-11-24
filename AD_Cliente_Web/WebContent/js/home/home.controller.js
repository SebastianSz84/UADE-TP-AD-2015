/**
 * Created by gusta on 23/11/2015.
 */
angular.module('distribuidas')
    .controller('HomeCtrl', function($scope, $http, $rootScope) {
        $scope.cotizaciones = [];
        $scope.rodamientos = [];
        $scope.armandoCot = false;

        $scope.verCotizaciones = function(){
            $http({
                'data': { 'nroCliente' : $rootScope.nroCliente},
                'method':'post',
                'url':'http://localhost:8080/AD_Cliente_Web/ServletGetCotizacion'
            })
            .success(function (data) {
                $scope.cotizaciones = data;
            }).
            error(function (data, status) {
                console.log(data);
                console.log(status);
            });
        };

        $scope.armarCotizacion = function(){
            $scope.armandoCot = true;
        };
    });