package com.ipavlov.monitor.functional;

import com.ipavlov.monitor.BaseApiTest;
import com.ipavlov.monitor.model.MeasurementsRequest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MeasurementsNegativeTests extends BaseApiTest {

//TODO Need Exceptions :
    @ValueSource(strings = {"measurements.json"})
    @Description("Test to check the saving && getting of new measurements where UserId {-1}")
    @ParameterizedTest(name = "Test")
    public void saveAndGetMeasurementsWhereUserIdIsMinusTest() {

        step("Save new measurements where UserId {-1}", () ->
                measurementsResponse = client.createMeasurements(request));

        step("Check that save new measurements", () -> {
            assertThat(measurementsResponse.getUserId()).isNegative();
            assertTrue(measurementsResponse.getId().toString().matches(ID_REGEXP));
        });
    }

    @Description("Test to check the saving && getting of new measurements where UserId {1000.01}")
    @Test
    public void saveAndGetMeasurementsWhereUserIdMoreThanMaxTest() {

        step("Save new measurements where UserId 1000.01", () ->
                measurementsResponse = client.createMeasurements(new MeasurementsRequest
                        (1, 22.2, 33.11, 1000.01)));

        step("Check that save new measurements", () -> {
            assertThat(measurementsResponse.getHotWater()).isNegative();
            assertTrue(measurementsResponse.getId().toString().matches(ID_REGEXP));
        });
    }

    @Description("Test to check the saving && getting of new measurements where UserId {1000.01}")
    @Test
    public void saveAndGetMeasurementsWhereGasIsNullTest() {

        step("Save new measurements where Gas 1000.01", () ->
                measurementsResponse = client.createMeasurements(new MeasurementsRequest
                        (13, null, 33.11, 1000.00)));

        step("Check that save new measurements", () -> {
            assertThat(measurementsResponse.getGas()).isNegative();
            assertTrue(measurementsResponse.getId().toString().matches(ID_REGEXP));
        });
    }
}