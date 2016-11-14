angular.
  module('phoneList').
  component('phoneList', {
    templateUrl: 'js/my_components/phone-list/phone-list.template.html',
    controller: [
      'Phone',
      function PhoneListController(Phone) {
        var self = this;
        self.orderProp = 'age';
        self.phones = Phone.getAllPhones();
        /*
        $http.get('phones/getAllPhones').then(function(response) {
          self.phones = response.data;
        });
        */
      }
    ]
  });
