angular.module('myApp').service('ConsoleService', function($http) {
	var service = {
		getAllJXC : function() {
			var url = "../rest/getSessionsList";
			return $http.get(url, {
				cache : true
			}).then(function(resp) {
				return resp.data;
			});
		},

		getJXC : function(id) {
			function jxcMatchesParam(jxc) {
				return jxc.id === id;
			}

			return service.getAllJXC().then(function(jxclist) {
				return jxclist.find(jxcMatchesParam)
			});
		}
	}

	return service;
})