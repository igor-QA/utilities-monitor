package com.ipavlov.monitor.simulation;

import com.ipavlov.monitor.configs.ConfigHelper;
import com.ipavlov.monitor.scenario.Scenario;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.http.HttpDsl.http;
import static ru.tinkoff.gatling.javaapi.Assertions.assertionFromYaml;

public class MeasurementsLoad extends Simulation {

    private static final int USER_COUNT = Integer.parseInt(System.getProperty("USERS", "2"));
    private static final Duration RAMP_DURATION =
            Duration.ofSeconds(Integer.parseInt(System.getProperty("RAMP_DURATION", "2")));

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
                .assertions(assertionFromYaml("src/test/resources/assertions.yml"));
    }
}
