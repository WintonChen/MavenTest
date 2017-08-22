/**
 * http://usejsdoc.org/
 */
'use strict'

var mainApp = angular.module("myApp", [ 
	'ui.router',
	'ngRoute',
	'myApp.main',
	'myApp.view1'
	]);
	
mainApp.config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
	  $locationProvider.hashPrefix('!');

	  $routeProvider.otherwise({redirectTo: '/main'});
	}]);