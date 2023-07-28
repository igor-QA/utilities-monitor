package com.ipavlov.monitor.performance.simulation;

import com.ipavlov.monitor.configs.ConfigHelper;
import com.ipavlov.monitor.performance.scenario.Scenario;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.global;
import static io.gatling.javaapi.http.HttpDsl.http;

public class MeasurementsLoad extends Simulation {

    private static final int USER_COUNT = Integer.parseInt(System.getProperty("USERS", "15"));
    private static final Duration RAMP_DURATION =
            Duration.ofSeconds(Integer.parseInt(System.getProperty("RAMP_DURATION", "30")));

    @Override
    public void before() {
        System.out.printf("Running test with %d users%n", USER_COUNT);
        System.out.printf("Ramping users over %d seconds%n", RAMP_DURATION.getSeconds());
    }

    @Override
    public void after() {
        System.out.println("Stress test completed");
    }

    HttpProtocolBuilder httpProtocol = http
            .baseUrl(ConfigHelper.url())
            .contentTypeHeader("application/json");

    public MeasurementsLoad() {
        this.setUp(
                Scenario.userScenario.injectOpen(
                        CoreDsl.constantUsersPerSec(USER_COUNT).during(RAMP_DURATION).randomized()
                )
        ).protocols(httpProtocol)
                .assertions(
                        global().successfulRequests().percent().gte(99.0),
                        global().responseTime().max().lt(1000));
    }
}