package com.ipavlov.monitor.service;

import com.ipavlov.monitor.configs.ConfigHelper;
import com.ipavlov.monitor.model.MeasurementsRequest;
import com.ipavlov.monitor.model.MeasurementsResponse;
import io.qameta.allure.Step;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    @Step("Save new measurements for particular user")
    public MeasurementsResponse createMeasurements(MeasurementsRequest measurementsRequest) {
        return given(RequestSpec.spec())
                .body(measurementsRequest)
                .log().ifValidationFails(LogDetail.ALL, true)
                .post("/measurements")
                .then().extract().response().as(MeasurementsResponse.class);
    }

    @Step("Get particular user's measurement history")
    public Response getMeasurement(Integer userId) {
        Response response = given(RequestSpec.spec())
                .pathParam("userId", userId)
                .log().ifValidationFails(LogDetail.ALL, true)
                .get(ConfigHelper.getMeasurement())
                .then().extract().response();
        Integer userIdResponse = response.jsonPath().getInt("userId");
        return response;
    }
}