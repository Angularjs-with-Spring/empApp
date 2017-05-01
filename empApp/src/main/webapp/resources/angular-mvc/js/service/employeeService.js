'use strict';

angular.module('employeeApp').factory('employeeservice',
		[ '$resource', function($resource) {
			return new Employee($resource);
		} ]);

function Employee(resource) {
	this.resource = resource;
	
	this.createEmployee = function(employee, scope) {
		var Employee = resource('/users/new');
		Employee.save(employee, function(response) {
			scope.message = response.message;
		});
	}

	this.getEmployee = function(id, scope) {
		var Employee = resource('/users/:employeeId', {
			employeeId : '@employeeId'
		});
		Employee.get({employeeId : id}, function(employee) {
			scope.employee = employee;
		})
	}

	this.getEmployees = function(scope) {
		var Employees = resource('/angSpring/users/all');
		Employees.query(function(employees) {
			scope.employees = employees;
		});
	}

	this.updateEmployee = function(scope) {
		var Employees = resource('/angSpring/users/all', null, {
			update : {
				method : 'PUT'
			}
		});
		Employees.update(function(employees) {
			scope.employees = employees;
		});
	}
}