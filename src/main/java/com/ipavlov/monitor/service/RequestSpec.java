package com.ipavlov.monitor.service;

import com.ipavlov.monitor.configs.ConfigHelper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    private static final
    HttpClientConfig httpClientConfig = HttpClientConfig.httpClientConfig()
            .setParam("CONNECTION_MANAGER_TIMEOUT", 10000);

    private static final RequestSpecification SPEC = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri(ConfigHelper.url())
            .setConfig(RestAssured.config().httpClient(httpClientConfig))
            .addFilter(new AllureRestAssured())
            .build();

    public static RequestSpecification spec() { return SPEC;}
}