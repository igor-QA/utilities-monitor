package com.ipavlov.monitor.scenario;

import com.ipavlov.monitor.BaseLoadTest;
import com.ipavlov.monitor.configs.ConfigHelper;
import org.apache.http.entity.ContentType;
import org.apache.jmeter.protocol.http.util.HTTPConstants;
import org.junit.jupiter.api.Test;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;
import java.time.Duration;

import static com.ipavlov.monitor.logger.TestExecutionLogger.sentInfluxDbListener;
import static com.ipavlov.monitor.variables.RequestBodyGenerator.buildRequestBody;
import static org.assertj.core.api.Assertions.assertThat;
import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

public class PerformanceTests extends BaseLoadTest {

    //Load Test for save and get user measurements scenario
    @Test
    public void saveAndGetMeasurementsLoadTest() throws IOException {
        TestPlanStats stats = testPlan(
                threadGroup(THREADS, ITERATIONS,
                        httpSampler(ConfigHelper.url() + "/measurements")
                                .method(HTTPConstants.POST)
                                .post(s -> buildRequestBody(), ContentType.APPLICATION_JSON)
                                .children(jsonExtractor("userIdVar", "userId"))
                                .children(jsonAssertion("dateTime")),

                        httpSampler(ConfigHelper.url() + "/users/${userIdVar}/measurements")
                                .method(HTTPConstants.GET)
                                .contentType(ContentType.APPLICATION_JSON)
                                .children(jsonAssertion("[*].userId"))
                ), sentInfluxDbListener()
        ).run();
        assertThat(stats.overall().sampleTimePercentile99()).isLessThan(Duration.ofSeconds(5));
    }
}