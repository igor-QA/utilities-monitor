package com.ipavlov.monitor.performance_jmeter;

import com.ipavlov.monitor.configs.ConfigHelper;
import io.qameta.allure.Description;
import org.apache.http.entity.ContentType;
import org.apache.jmeter.protocol.http.util.HTTPConstants;
import org.junit.jupiter.api.Test;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;
import java.time.Duration;

import static com.ipavlov.monitor.performance_jmeter.variables.RequestBodyGenerator.buildRequestBody;
import static org.assertj.core.api.Assertions.assertThat;
import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

public class PerformanceTests extends BaseLoadTest {

    @Description("Load Test for save and get user measurements")
    @Test
    public void saveAndGetMeasurementsLoadTest() throws IOException {
        TestPlanStats stats = testPlan(
                threadGroup(THREADS, ITERATIONS,
                        httpSampler(ConfigHelper.url() + "/measurements")
                                .post(s -> buildRequestBody(s.vars), ContentType.APPLICATION_JSON)
                                .children(
                                        jsonExtractor("userIdVar", "userId")),
                        httpSampler(ConfigHelper.url() + "/users/${userIdVar}/measurements")
                                .method(HTTPConstants.GET)
                                .children(
                                        responseAssertion().containsSubstrings("userId"))
                ),
                influxDbListener("http://localhost:8086/write?db=jmeter")
                        .measurement("jmeter")
                        .application("jmeter")
                        .token(ConfigHelper.getToken())
        ).run();
        assertThat(stats.overall().sampleTimePercentile99()).isLessThan(Duration.ofSeconds(5));
    }
}