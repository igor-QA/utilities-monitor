### Utilities-monitor ###

Performance and Functional testing for https://github.com/singeev/utilitiesMonitor project 

* Stack: Java 17, RestAssured, JUnit5, Maven, Gatling
* Reporting: Allure Reports, Gatling Reports


### Functional: ###
* mvn clean -Dtest=*/functional/* test
* mvn allure:report
* mvn allure:serve

### Performance: ###

* mvn gatling:test





