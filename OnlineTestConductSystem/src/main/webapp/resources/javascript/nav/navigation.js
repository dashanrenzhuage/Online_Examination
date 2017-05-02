var VLogin = angular.module('myapp',[]);

VLogin.controller('TestCtrl', ['$scope',function($scope) {

    $scope.clicked = function(){   

        $location.path('/test.html');
    }

}]);