/**
 * Created by shekhargulati on 10/06/14.
 */

var app = angular.module('ercapp', [
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngRoute'
]);

app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'views/list.html',
        controller: 'ListCtrl'
    }).otherwise({
        redirectTo: '/'
    })
});

app.controller('ListCtrl', function ($scope, $http) {
    $http.get('/api/v1/principals').success(function (data) {
        $scope.principals = data;
    }).error(function (data, status) {
        console.log('Error ' + data)
    })

    $scope.todoStatusChanged = function (principal) {
        console.log(principal);
        $http.put('/api/v1/principals/' + principal.id, principal).success(function (data) {
            console.log('status changed');
        }).error(function (data, status) {
            console.log('Error ' + data)
        })
    }
});
