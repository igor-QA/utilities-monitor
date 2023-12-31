## Utilities-monitor

**Performance** and **Functionality** testing for https://github.com/singeev/utilitiesMonitor project.

Before running the tests, launch the Application - utilitiesMonitor according to the instructions in the project description

- Stack: Java 17, RestAssured, JUnit5, Maven, Gatling, JMeter
- Reporting: Allure Reports, Gatling Reports, Grafana

For Grafana reporting install it:  

- [Grafana](https://grafana.com/grafana/download)
- [InfluxDB](https://portal.influxdata.com/downloads/) 

## USAGE examples

## Functional Tests: 

### need go to module and run test

```bash
cd functional
```
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

## Performance Tests (Gatling-Java-Dsl):

### need go to module and run test

```bash
cd gatling
```
#### run command

```bash
mvn gatling:test
```

## Performance Tests (JMeter-Java-Dsl):

### need go to module and run test

```bash
cd jmeter
```
#### run command

```bash
mvn clean -Dtest=PerformanceTests test
```
## Grafana
> Real-time monitoring for tests
> <p  align="left">
<code>
<img width="80%" title="Grafana monitoring" src="images/grafana.png">
</code>
</p>

## Allure Reports
> Dashboard with statuses of testcases on Allure
<p  align="left">
<code>
<img width="80%" title="Allure overview" src="images/allure.png">
</code>
</p>

> Allure report with failed tests
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
