package com.ipavlov.monitor.functional;

import com.ipavlov.monitor.BaseApiTest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.RepeatedTest;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MeasurementsPositiveTests extends BaseApiTest {
    private Response response;

    @Description("Test to check the saving && getting of new measurements")
    @RepeatedTest(5)
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

        step("Check getting user measurement", () -> {
            assertThat(response.getBody()).isNotNull();
            assertThat(response.getStatusCode()).isEqualTo(200);
            assertThat(response.jsonPath().get("userId").toString()).isNotNull();
        });
    }
}