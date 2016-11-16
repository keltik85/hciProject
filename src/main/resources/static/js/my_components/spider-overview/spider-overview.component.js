angular.
  module('spiderOverview').
  component('spiderOverview', {
    templateUrl: 'js/my_components/spider-overview/spider-overview.template.html',
    controller: [
      function SpiderWebOverviewController() {
        var self = this;
        self.someProperty = 'Hello Spider Web Grpahic World!';

        self.labels =["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"];
        self.data = [
          [65, 59, 90, 81, 56, 55, 40],
          [28, 48, 40, 19, 96, 27, 100]
        ];

      }
    ]
  });
