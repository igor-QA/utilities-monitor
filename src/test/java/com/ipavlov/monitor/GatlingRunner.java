package com.ipavlov.monitor;

import com.ipavlov.monitor.performance.simulation.MeasurementsLoad;
import io.gatling.app.Gatling;
import io.gatling.core.config.GatlingPropertiesBuilder;
import scala.collection.mutable.Map;

public class GatlingRunner {

    public static void main(String[] args) {

        final Map<String, Object> gatlingProperties = new GatlingPropertiesBuilder()
                .simulationClass(MeasurementsLoad.class.getName())
                .build();
        Gatling.fromMap(gatlingProperties);
    }
}