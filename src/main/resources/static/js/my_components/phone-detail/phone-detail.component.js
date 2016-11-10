'use strict';

// Register `phoneDetail` component, along with its associated controller and template
angular.
  module('phoneDetail').
  component('phoneDetail', {
    template: 'js/my_components/phone-detail/phone-detail.template.html',
    controller: ['$http', '$routeParams',
      function PhoneDetailController($routeParams) {
        var self = this;
        $http.get('phones/' + $routeParams.phoneId + '.json').then(function(response) {
         self.phone = response.data;
        });
      }
    ]
  });
