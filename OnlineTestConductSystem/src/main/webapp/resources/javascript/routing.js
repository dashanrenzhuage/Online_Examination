var app = angular.module("AngularFormDemo", ["AngularFormDemo.controllers", "ngRoute"]);
app.config(["$routeProvider", function($routeProvider){
	$routeProvider.
		when("/send_email", {
			templateUrl : "/resources/html/emailSendPage.html", 
			controller : "AddPlayerController"
		}).
		otherwise({redirectTo: "/"})
	
}]);