'use strict';

// Register `phoneDetail` component, along with its associated controller and template
angular.
  module('phoneDetail').
  component('phoneDetail', {
    templateUrl: 'js/my_components/phone-detail/phone-detail.template.html',
    controller: ['Phone', '$routeParams',
      function PhoneDetailController(Phone, $routeParams) {
        var self = this;

        self.setImage = function setImage(imageUrl) {
            self.mainImageUrl = imageUrl;
        };

        self.doubleClickAction = function doubleClickAction(imageUrl) {
          alert('You double-clicked image: ' + imageUrl);
        };

/*
        $http.get('phones/getPhoneDetail?phoneId=' + $routeParams.phoneId).then(function(response) {
          self.phone = response.data;
          self.setImage(self.phone.images[0]);
        });
*/
        self.phone = Phone.get({phoneId: $routeParams.phoneId, method: 'getPhoneDetail'}, function(phone) {
          self.setImage(phone.images[0]);
        });
      }
    ]
  });
