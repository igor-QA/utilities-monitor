package com.ipavlov.monitor.performance.scenario;

import com.ipavlov.monitor.BaseApiTest;
import com.ipavlov.monitor.performance.steps.Steps;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class Scenario extends BaseApiTest {
    private static final Steps step = new Steps();

    public static ScenarioBuilder userScenario = scenario("Save User's Measurements scenario")
            .exec(step.saveMeasurements)
            .exec(step.getUsersMeasurement);
}