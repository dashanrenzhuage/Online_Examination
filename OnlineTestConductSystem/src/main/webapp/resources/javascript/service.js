
var services = angular.module('ngdemo.services', ['ngResource']);

services.factory('UserFactory', function ($resource) {
    return $resource('/abcd', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});

