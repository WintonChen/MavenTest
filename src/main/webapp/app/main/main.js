/**
 * http://usejsdoc.org/
 */
'use strict';

angular.module('myApp.main', ['ui.router','ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/main', {
    templateUrl: 'main/main.html',
    controller: 'MainCtrl'
  });
}])

.controller('MainCtrl', function($scope, $http,$state) {
	var url = "../rest/getSessionsList";
	$http.get(url).then(function onSuccess(response){
		$scope.jxcs = response.data;
	});
	
	$scope.visitJXC = function(index) {
		var jxc = $scope.jxcs[index];

		alert("id:"+jxc.id+"\n"+"address:"+jxc.address);

		$state.go("visitjxc", {
			id : jxc.id,
			name : jxc.address
		});
	};
});