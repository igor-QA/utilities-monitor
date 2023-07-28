package com.ipavlov.monitor.performance.steps;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.http.HttpDsl;

import static io.gatling.javaapi.core.CoreDsl.*;

public class Steps {

    public ChainBuilder saveMeasurements =
            exec(HttpDsl.http("Save new measurements")
                    .post("/measurements")
                    .body(ElFileBody("templates/measurementsRequest.json"))
                    .check(jmesPath("userId").saveAs("userId")));

    public ChainBuilder getUsersMeasurement =
            exec(HttpDsl.http("Get particular user's measurements")
                    .get("/users/#{userId}/measurements")
                    .check(HttpDsl.status().is(200)));
}