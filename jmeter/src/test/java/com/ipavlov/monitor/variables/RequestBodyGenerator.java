package com.ipavlov.monitor.variables;

import groovy.json.JsonException;
import net.minidev.json.JSONObject;

import static com.ipavlov.monitor.helpers.DataHelper.getRandomDouble;
import static com.ipavlov.monitor.helpers.DataHelper.getRandomInteger;

public class RequestBodyGenerator {

    //Generation random Json
    public static String buildRequestBody() throws JsonException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", getRandomInteger());
        jsonObject.put("gas", getRandomDouble());
        jsonObject.put("coldWater", getRandomDouble());
        jsonObject.put("hotWater", getRandomDouble());
        return jsonObject.toJSONString();
    }

//Generation random Json and concert with Jackson
//    public static String buildMapperRequestBody(JMeterVariables vars) throws JsonProcessingException {
//        MeasurementsRequest request = measurementsGenerator();
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(request);
//    }
}