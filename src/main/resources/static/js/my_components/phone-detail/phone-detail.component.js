'use strict';

// Register `phoneDetail` component, along with its associated controller and template
angular.
  module('phoneDetail').
  component('phoneDetail', {
    templateUrl: 'js/my_components/phone-detail/phone-detail.template.html',
    controller: ['$http', '$routeParams',
      function PhoneDetailController($http, $routeParams) {
        var self = this;
        $http.get('phones/getPhoneDetail?phoneId=' + $routeParams.phoneId).then(function(response) {
          self.phone = response.data;
        });
      }
    ]
  });
