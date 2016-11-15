'use strict';

describe('phoneDetail', function() {

  // Load the module that contains the `phoneDetail` component before each test
  beforeEach(module('phoneDetail'));

  // Test the controller
  describe('PhoneDetailController', function() {
    var $httpBackend, ctrl;

    beforeEach(inject(function($componentController, _$httpBackend_, $routeParams) {
      $httpBackend = _$httpBackend_;
      $httpBackend.expectGET('phones/getPhoneDetail?phoneId=dell-streak-7').respond({name: 'phones/getPhoneDetail?phoneId=dell-streak-7'});
      $routeParams.phoneId = 'dell-streak-7';
      ctrl = $componentController('phoneDetail');
    }));

    it('should fetch the phone details', function() {
      $httpBackend.flush();
      expect(ctrl.phone).toEqual({name: 'phone dell-streak-7'});
    });

  });

});
