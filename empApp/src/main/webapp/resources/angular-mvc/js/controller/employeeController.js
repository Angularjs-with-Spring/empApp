'use strict';

// Controller when the main page/view loads

angular.module('employeeApp').controller("SpaCtrl", [ '$scope', function($scope) {

} ]);

// Controller for All Employees View

angular.module('employeeApp').controller(
		"EmployeesCtrl",
		[ '$scope', 'employeeservice', '$route', '$routeParams', '$location',
				function($scope, employeeservice, $route, $routeParams, $location) {

					employeeservice.getEmployees($scope);

				} ]);

// Controller for New User View

angular.module('employeeApp').controller(
		"NewEmployeeCtrl",
		[ '$scope', 'employeeservice', '$route', '$routeParams', '$location',
				function($scope, employeeservice, $route, $routeParams, $location) {

					console.log("new controller started. rout: "+$route+" routeParam: "+$routeParams);

					employeeservice.getEmployees($scope); 
					/*employeeservice.updateUser($scope);*/
					console.log($scope.employees);

					$scope.createNewUser = function() {

						var newemployee = {
							'firstname' : $scope.firstname,
							'lastname' : $scope.lastname,
							'address' : $scope.address,
							'email' : $scope.email
						};

						employeeservice.createUser(newemployee, $scope);

						$scope.employees.push(newemployee);

						$scope.firstname = '';

						$scope.lastname = '';

						$scope.address = '';

						$scope.email = '';

					};

				} ]);

// Controller for Individual User View

angular.module('employeeApp').controller(
		"EmployeesByIdCtrl",
		[ '$scope', 'employeeservice', '$routeParams',
				function($scope, employeeservice, $routeParams) {

					employeeservice.getUser($routeParams.employeeId, $scope);

				} ]);