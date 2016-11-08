This Project has:
- an Angular JS Front End
- uses NodeJS
- a Spring MVC Backend
- a MongoDB Database

To get the Project running in your IDE:
- install MongoDB
- install NodeJs
- create a Gradle Project in your IDE of choice from the sources in this Git repo
- cd to "ressources/static/js"
- npm install karma karma-jasmine jasmine-core karma-phantomjs-launcher
- npm install -g protractor phantomjs karma-cli
- put karma, karma-cli, protractor and phantomjs on path

To run the e2e tests do:
- cd into the folder
- webdriver-manager start
- protractor protractor.conf.js