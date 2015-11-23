/**
 * Created by gusta on 23/11/2015.
 */
angular.module('distribuidas', [
    'ui.router'
])
.config(function ($stateProvider, $urlRouterProvider) {
    console.log('dsa');
    $stateProvider
        .state('home', {
            url: '/',
            templateUrl: 'js/home/home.html',
            controller: 'HomeCtrl'
        });
    $urlRouterProvider.otherwise('/');
});