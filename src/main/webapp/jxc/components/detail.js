angular.module('myApp').component('detail', {

	templateUrl : 'components/detail.html',

	controller : 'detailCtrl'
})


angular.module('myApp').controller('detailCtrl', function($scope, $stateParams) {
	$scope.id= $stateParams.id;
	$scope.address = $stateParams.address;
})