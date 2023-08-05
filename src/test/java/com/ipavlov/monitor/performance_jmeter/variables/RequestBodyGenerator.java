package com.ipavlov.monitor.performance_jmeter.variables;

import com.ipavlov.monitor.helpers.DataHelper;
import io.qameta.allure.Step;
import net.minidev.json.JSONObject;
import org.apache.jmeter.threads.JMeterVariables;

public class RequestBodyGenerator {

    @Step("Generation random Json")
    public static String buildRequestBody(JMeterVariables vars) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.appendField("userId", DataHelper.getRandomInteger());
        jsonObject.appendField("gas", DataHelper.getRandomDouble());
        jsonObject.appendField("coldWater", DataHelper.getRandomDouble());
        jsonObject.appendField("hotWater", DataHelper.getRandomDouble());
        return jsonObject.toJSONString();
    }
}