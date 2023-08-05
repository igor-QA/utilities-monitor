package com.ipavlov.monitor.functional;

import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.RepeatedTest;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MeasurementsPositiveTests extends BaseApiTest {
    private Response response;

    @Description("Test for check the saving && getting of new measurements")
    @RepeatedTest(3)
    public void saveAndGetMeasurementsTest() {

        step("Save new measurements", () ->
                measurementsResponse = client.createMeasurements(request));

        step("Check that save new measurements", () -> {
            assertThat(measurementsResponse.getId()).isNotNull();
            assertThat(measurementsResponse.getGas()).isEqualTo(request.getGas());
            assertThat(measurementsResponse.getUserId()).isEqualTo(request.getUserId());
        });

        step("Get particular user's measurement", () ->
                response = client.getMeasurement(measurementsResponse.getUserId()));

        step("Check getting user measurements", () -> {
            assertThat(response.getBody()).isNotNull();
            assertThat(response.getStatusCode()).isEqualTo(200);
            assertThat(response.jsonPath().get("userId").toString()).isNotNull();
        });
    }
}