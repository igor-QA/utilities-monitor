package com.ipavlov.monitor.configs;
import org.aeonbits.owner.Config;

    @Config.LoadPolicy(Config.LoadType.MERGE)
    @Config.Sources({
            "system:properties",
            "classpath:api.properties",
            "classpath:request.properties"
    })

    public interface ApiConfig extends Config {
        @Key("host")
        String host();
        @Key("port")
        String port();
        @Key("getMeasurement")
        String getMeasurement();
}