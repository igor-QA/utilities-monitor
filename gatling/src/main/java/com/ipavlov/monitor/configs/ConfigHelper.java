package com.ipavlov.monitor.configs;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {
    private final static ApiConfig api = ConfigFactory
            .create(ApiConfig.class, System.getProperties());
    private final static ApiConfig request = ConfigFactory
            .create(ApiConfig.class, System.getProperties());

    public static String url() {
        return api.host() + ":" + api.port();
    }
}