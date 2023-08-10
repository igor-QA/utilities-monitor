package com.ipavlov.monitor.sampler;


import com.ipavlov.monitor.configs.ConfigHelper;
import org.apache.http.entity.ContentType;
import org.apache.jmeter.protocol.http.util.HTTPConstants;
import us.abstracta.jmeter.javadsl.http.DslHttpSampler;

import static com.ipavlov.monitor.variables.RequestBodyGenerator.buildRequestBody;
import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

public class DslHttpSamplers {

    //Save new measurements for particular user
    private static DslHttpSampler saveMeasurementsRequest() {
        return httpSampler(ConfigHelper.url() + "/measurements")
                .post(s -> buildRequestBody(), ContentType.APPLICATION_JSON)
                .children(
                        jsonExtractor("userIdVar", "userId"));
    }

    //Get particular user's measurement history
    private static DslHttpSampler getUserIdRequest() {
        return httpSampler(ConfigHelper.url() + "/users/${userIdVar}/measurements")
                .method(HTTPConstants.GET)
                .children(responseAssertion().containsSubstrings("userId"));
    }
}