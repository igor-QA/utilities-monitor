package com.ipavlov.monitor.variables;

import com.ipavlov.monitor.helpers.DataHelper;
import net.minidev.json.JSONObject;

public class RequestBodyGenerator {

    //Generation random Json
    public static String buildRequestBody() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.appendField("userId", DataHelper.getRandomInteger());
        jsonObject.appendField("gas", DataHelper.getRandomDouble());
        jsonObject.appendField("coldWater", DataHelper.getRandomDouble());
        jsonObject.appendField("hotWater", DataHelper.getRandomDouble());
        return jsonObject.toJSONString();
    }

//Generation random Json and concert with Jackson
//    public static String buildMapperRequestBody(JMeterVariables vars) throws JsonProcessingException {
//        MeasurementsRequest request = measurementsGenerator();
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(request);
//    }
}