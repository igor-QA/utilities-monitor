package com.ipavlov.monitor.performance_gatling.scenario;

import com.ipavlov.monitor.performance_gatling.steps.Steps;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class Scenario {
    private static final Steps step = new Steps();

    public static ScenarioBuilder userScenario = scenario("Save User's Measurements scenario")
            .exec(step.saveMeasurements)
            .exec(step.getUsersMeasurement);
}