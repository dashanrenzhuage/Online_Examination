//module -container for application – controllers, services, filters, directives, etc.
var cartApp = angular.module('cartApp', [ngdemo.services, ngdemo.controllers]);

cartApp.controller('cartController', function($scope, $http) {
	$scope.persons = [];
	$scope.getAll = function() {
		$http.get('http://localhost:8089/abcd').success(function(data) {
			alert("success" + data);
			$scope.persons = data;
		}).error(function(data) {
			alert("failure");
		});
	};

});
