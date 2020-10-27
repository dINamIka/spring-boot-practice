package com.yarmak;

import com.yarmak.config.VitalProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class DummyMedicalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final VitalProperties vitalProperties;

    public DummyMedicalService(final VitalProperties vitalProperties) {
        this.vitalProperties = vitalProperties;
        LOGGER.info("Heart rate is: {}", vitalProperties.getHeartRate());
        LOGGER.info("Body temperature is: {}", vitalProperties.getBodyTemperature());
        LOGGER.info("Blood pressure is: {}", vitalProperties.getBloodPressure());
    }
}
