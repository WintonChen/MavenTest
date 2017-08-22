/**
 * http://usejsdoc.org/
 */
myApp = angular.module('myApp', [ 'ui.router' ]);

myApp.config(function($stateProvider,$urlRouterProvider) {

	var states = [

		{
			name : 'home',
			url : '/home',
			// Using component: instead of template:
			component : 'home'
		},

		{
			name : 'console',
			url : '/console',
			// Using component: instead of template:
			component : 'console',
			resolve : {
				jxclist : function(ConsoleService) {
					return ConsoleService.getAllJXC();
				}
			}
		},

		{
			name : 'detail',
			url : '/detail',
			// Using component: instead of template:
			component : 'detail',
			resolve : {
				
			}
		}


	];


	// Loop over the state definitions and register them
	states.forEach(function(state) {
		$stateProvider.state(state);
	});
	
	 $urlRouterProvider
     .otherwise('home');
	

});