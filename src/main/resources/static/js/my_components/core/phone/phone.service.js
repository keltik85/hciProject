angular.
  module('core.phone').
  factory('Phone', [
    '$resource',
    function($resource) {
      return $resource('phones/:method?phoneId=:phoneId', {}, {
        getAllPhones: {
          method: 'GET',
          params: {method: 'getAllPhones', phoneId: ''},
          isArray: true
        }
      });
    }
  ]);