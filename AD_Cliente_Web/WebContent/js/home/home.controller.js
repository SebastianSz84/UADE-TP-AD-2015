/**
 * Created by gusta on 23/11/2015.
 */
angular.module('distribuidas')
    .controller('HomeCtrl', function($scope, $http) {
        $scope.cotizaciones = [];

        $scope.verCotizaciones = function(){
            $http.post('http://localhost:8080/AD_Cliente_Web/ServletGetCotizacion')
            .success(function (data) {
                $scope.cotizaciones = data;
            }).
            error(function (data, status) {
                console.log(data);
                console.log(status);
            });
        };

        $scope.armarCotizacion = function(){

        };
    });