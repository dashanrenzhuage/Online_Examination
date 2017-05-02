/*var contextRoot = "/" + window.location.pathname.split('/')[1];
var app = angular.module("myApp", [ "ngRoute" ]);
app.config(function($routeProvider, $locationProvider) {
	$routeProvider.when("/", {
		templateUrl : contextRoot + '/resources/html/main.html'
	}).when("/london", {
		templateUrl : contextRoot + '/resources/html/london.html'
	}).when("/paris", {
		templateUrl : contextRoot + '/resources/html/paris.html'
	}).otherwise({
		redirectTo : '/'
	});
});*/

var contextRoot = "/" + window.location.pathname.split( '/' )[1];

//A module is a collection of services, directives, controllers, 
// filters, and configuration information.
var myApp = angular.module('myApp',['ui.router', 'cartApp']);

myApp.config(function($stateProvider,$httpProvider,$locationProvider){
	
    $stateProvider.state('/',{
        url:'/',
        templateUrl: contextRoot + '/resources/html/main.html',
        controller:'cartController'
    })
    .state('london',{
       url:'/london',
       templateUrl: contextRoot + '/resources/html/london.html',
       controller:'cartController'
    })
    .state('paris',{
        url:'/paris',
        templateUrl: contextRoot + '/resources/html/paris.html',
        controller:'cartController'
    });
    
 // use the HTML5 History API
    $locationProvider.html5Mode(true);

});
