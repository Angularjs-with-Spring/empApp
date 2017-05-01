'use strict';

var employeeApp = angular.module("employeeApp", [ 'ngRoute', 'ngResource', 'ui.router' ]);

/*employeeApp.config([
		'$routeProvider',
		function($routeProvider) {

			$routeProvider.when(
					'/employees/new',
					{
						controller : 'NewUserCtrl',
						templateUrl : templateUrlConfig.appTemplateEntryPoint
								+ templateUrlConfig.employeeTemplateGroup
								+ 'launchUser'
						redirectTo: '/check'
					}).when('/check', {
				template : 'This is the default Route'
			}).otherwise({
				controller : 'SpaCtrl',
				templateUrl : 'views/spahome.html'
			});
		} ]);*/


employeeApp.config(function($stateProvider, $urlRouterProvider){
	  $stateProvider
	    .state('forms', {
	      url: '/employees/new',
	      views: employeeViewsConfig.indexView,
	      controller: 'NewEmployeeCtrl',
	      authenticate: true
	    })
	    .state('login', {
	      url: '/check',
	      template: 'This is the default Route',
	      authenticate: false
	    })
	    .state('page', {
	      url: '/checkPage',
	      views: employeeViewsConfig.homeView,
	      authenticate: false
	    });
	  // Send to login if the URL was not found
	  $urlRouterProvider.otherwise("/check");
	});

employeeApp.run(function ($rootScope, $state, AuthService) {
	  $rootScope.$on("$stateChangeStart", function(event, toState, toParams, fromState, fromParams){
	    if (toState.authenticate && !AuthService.isAuthenticated()){
	      // User isn’t authenticated
	      $state.transitionTo("login");
	      event.preventDefault(); 
	    }
	  });
	});


