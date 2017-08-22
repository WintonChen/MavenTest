angular.module('myApp').service('ConsoleService', function($http) {
	var service = {
		getAllJXC : function() {
			var url = "../rest/getSessionsList";
			return $http.get(url, {
				cache : true
			}).then(function(resp) {
				return resp.data;
			});
		}
	}

	return service;
})