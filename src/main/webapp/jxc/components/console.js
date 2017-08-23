angular.module('myApp').component('console', {
	bindings : {
		jxclist : '<'
	},

	templateUrl : 'components/console.html',

	controller : 'consoleCtrl'
})


angular.module('myApp').controller('consoleCtrl', function($scope,$state) {
	$scope.visitJXC = function(id,address){ 

//		alert("id:"+id+"\n"+"address:"+address);

		$state.go("detail", {
			id : id,
			address : address
		});
	};
	
	
})