package com.ipavlov.monitor;

import com.ipavlov.monitor.model.MeasurementsRequest;
import com.ipavlov.monitor.model.MeasurementsResponse;
import com.ipavlov.monitor.performance.steps.Steps;
import com.ipavlov.monitor.service.UserClient;

import static com.ipavlov.monitor.generator.MeasurementsGenerator.measurementsGenerator;
public class BaseApiTest {
    protected UserClient client = new UserClient();
    protected MeasurementsRequest request = measurementsGenerator();
    protected MeasurementsResponse measurementsResponse = new MeasurementsResponse();
}