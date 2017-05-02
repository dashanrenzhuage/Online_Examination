var cartApp = angular.module('ashishApp', []);

cartApp.controller('ashishController', function($scope, $http) {

	$scope.persons = [];
	$scope.message;
	$scope.red = function() {

		$http.get('http://localhost:8089/abcd').then(function(success) {	
			$scope.persons = success.data;
		}, function(error) {
			alert("FAIL");	
		});
	};

});
