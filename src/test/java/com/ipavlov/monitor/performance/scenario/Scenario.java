package com.ipavlov.monitor.performance.scenario;

import com.ipavlov.monitor.BaseApiTest;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class Scenario extends BaseApiTest {

    public static ScenarioBuilder userScenario = scenario("Save User's Measurements scenario")
            .exec(step.saveMeasurements)
            .exec(step.getUsersMeasurement);
}