angular.
  module('phoneList').
  component('phoneList', {
    templateUrl: 'js/my_components/phone-list/phone-list.template.html',
    controller: [
      '$http',
      function PhoneListController($http) {
        var self = this;
        self.orderProp = 'age';
        $http.get('phones/getAllPhones').then(function(response) {
          self.phones = response.data;
        });
      }
    ]
  });
