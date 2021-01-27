package com.yarmak;

import com.yarmak.config.VitalProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;

@Service
public class DummyMedicalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final VitalProperties vitalProperties;
    private final Environment env;

    public DummyMedicalService(final VitalProperties vitalProperties, Environment env) {
        this.vitalProperties = vitalProperties;
        this.env = env;
        LOGGER.info("Heart rate is: {}", vitalProperties.getHeartRate());
        LOGGER.info("Body temperature is: {}", vitalProperties.getBodyTemperature());
        LOGGER.info("Blood pressure is: {}", vitalProperties.getBloodPressure());
    }

    @PostConstruct
    public void printProps() {
        LOGGER.info("PROPERTIES ---");
        LOGGER.info("classpath: {}", env.getProperty("cp.key"));
        LOGGER.info("external: {}", env.getProperty("external.key"));
    }
}
