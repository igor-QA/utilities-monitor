package com.ipavlov.monitor.functional;

import com.ipavlov.monitor.model.MeasurementsRequest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MeasurementsNegativeTests extends BaseApiTest {
    private Response response;

    //TODO Need Exceptions : "userId": "UserId should be positive"
    @ValueSource(strings = {"measurements.json"})
    @Description("Test for check the saving && getting of new measurements where UserId {-1}")
    @ParameterizedTest(name = "Test")
    public void saveAndGetMeasurementsWhereUserIdIsMinusTest() {

        step("Save new measurements where UserId {-1}", () ->
                response = client.createIncorrectMeasurements(request));

        step("Check response for incorrect data", () -> {
            assertThat(response.getStatusCode()).isEqualTo(400);
        });
    }

    //TODO Need normal error then Measurements > 1000.01
    @Description("Test for check the saving && getting of new measurements where HotWater {1000.01}")
    @Test
    public void saveAndGetMeasurementsWhereHotWaterMoreThanMaxTest() {

        step("Save new measurements where HotWater 1000.01", () ->
                response = client.createIncorrectMeasurements(new MeasurementsRequest
                        (12, 22.2, 33.11, 1000.01)));

        step("Check response for incorrect data", () -> {
            assertThat(response.getStatusCode()).isEqualTo(400);
        });
    }

    @Description("Test for check the saving && getting of new measurements where Gas {is Null}")
    @Test
    public void saveAndGetMeasurementsWhereGasIsNullTest() {

        step("Save new measurements where Gas is Null", () ->
                response = client.createIncorrectMeasurements(new MeasurementsRequest
                        (13, null, 999.11, 1000.00)));

        step("Check response for incorrect data", () -> {
            assertThat(response.getStatusCode()).isEqualTo(400);
            assertThat(response.jsonPath().get("gas").toString())
                    .isEqualTo("Gas measurement should not be empty");
        });
    }
}