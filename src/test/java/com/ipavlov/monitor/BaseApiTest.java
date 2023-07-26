package com.ipavlov.monitor;

import com.ipavlov.monitor.model.MeasurementsRequest;
import com.ipavlov.monitor.model.MeasurementsResponse;
import com.ipavlov.monitor.performance.steps.Steps;
import com.ipavlov.monitor.service.UserClient;

import static com.ipavlov.monitor.generator.MeasurementsGenerator.measurementsGenerator;
public class BaseApiTest {
    protected static final String ID_REGEXP = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";
    protected static Steps step = new Steps();
    protected UserClient client = new UserClient();
    protected MeasurementsRequest request = measurementsGenerator();
    protected MeasurementsResponse measurementsResponse = new MeasurementsResponse();
}