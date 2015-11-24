/**
 * Created by gusta on 23/11/2015.
 */
angular.module('distribuidas')
    .controller('LoginCtrl', function($scope, $rootScope, $state) {
    	$scope.checkNumber = function (){
    		//VALIDAR SI EXISTE
    		$rootScope.nroCliente = $scope.nroCliente;
    		$state.go('home');
    	};
    });