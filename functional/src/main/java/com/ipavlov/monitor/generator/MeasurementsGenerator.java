package com.ipavlov.monitor.generator;

import com.ipavlov.monitor.helpers.DataHelper;
import com.ipavlov.monitor.model.MeasurementsRequest;
import io.qameta.allure.Step;

public class MeasurementsGenerator {

    @Step("Generate random measurements and UserId")
    public static MeasurementsRequest measurementsGenerator() {
        MeasurementsRequest mr = new MeasurementsRequest();
        mr.setUserId(DataHelper.getRandomInteger());
        mr.setGas(DataHelper.getRandomDouble());
        mr.setColdWater(DataHelper.getRandomDouble());
        mr.setHotWater(DataHelper.getRandomDoubleV2(3,2));
        return mr;
    }
}