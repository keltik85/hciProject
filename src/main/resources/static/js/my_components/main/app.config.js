angular.
  module('phonecatApp').
  config(['$locationProvider' ,'$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/', {
          template: '<phone-list></phone-list>'
        }).
        when('/detail/:phoneId', {
          template: '<phone-detail></phone-detail>'
        }).
        otherwise('/');
    }
  ]);
