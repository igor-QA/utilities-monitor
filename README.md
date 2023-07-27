# Utilities-monitor

Performance and Functional testing for https://github.com/singeev/utilitiesMonitor project.

Before running the tests, launch the Application - utilitiesMonitor according to the instructions in the project description

- Stack: Java 17, RestAssured, JUnit5, Maven, Gatling
- Reporting: Allure Reports, Gatling Reports

## USAGE examples

## if Functional Tests: 
#### run command

```bash
mvn clean -Dtest=MeasurementsNegativeTests,MeasurementsPositiveTests test
```

## Reports:
#### run command

```bash
mvn allure:report
mvn allure:serve
```

## if Performance Tests:
#### run command

```bash
mvn gatling:test
```

## Allure Reports
> Dashboard with statuses of testcases on Allure
<p  align="left">
<code>
<img width="80%" title="Allure overview" src="images/allure.png">
</code>
</p>

> Failed test report on Allure
<p  align="left">
<code>
<img width="80%" title="Allure overview" src="images/allure3.png">
</code>
</p>

## Gatling Report
> Dashboard of load testing results
<p  align="left">
<code>
<img width="80%" title="Gatling overview" src="images/gatling.png">
</code>
</p>

> Activity users graph
<p  align="left">
<code>
<img width="80%" title="Gatling overview" src="images/gatling1.png">
</code>
</p>

> Number of request and response per seconds
<p  align="left">
<code>
<img width="80%" title="Gatling overview" src="images/gatling2.png">
</code>
</p>
