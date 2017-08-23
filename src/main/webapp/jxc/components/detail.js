angular.module('myApp').component('detail', {
	templateUrl : 'components/detail.html',

	controller : 'detailCtrl'
})


angular.module('myApp').controller('detailCtrl'
	, function($scope, $stateParams, $http) {
		$scope.id = $stateParams.id;
		$scope.address = $stateParams.address;

		$scope.submit = function() {

			console.log($scope.id + $scope.address + $scope.data);

			$http({
				method : "POST",
				url : "../rest/send",
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded;charset=UTF-8'
				},
				data : {
					id : $scope.id,
					address : $scope.address,
					data : $scope.data
				},
				transformRequest : function(obj) {
					var str = [];
					for (var p in obj) {
						str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
					}
					return str.join("&");
				}
			}).then(function(response) {
				console.log(response.status);
				console.log(response.data);
				$scope.messages = response.data;
			});

		}
	})