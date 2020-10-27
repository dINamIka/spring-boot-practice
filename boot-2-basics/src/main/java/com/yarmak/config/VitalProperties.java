package com.yarmak.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

//as we user @EnableConfigurationProperties we don't need this annotation
//@Configuration
@ConfigurationProperties("vital.things")
public class VitalProperties {

    private int heartRate;
    private int bodyTemperature;
    private List<String> bloodPressure;

    public int getHeartRate() {
        return heartRate;
    }

    public int getBodyTemperature() {
        return bodyTemperature;
    }

    public List<String> getBloodPressure() {
        return bloodPressure;
    }

    public VitalProperties setHeartRate(final int heartRate) {
        this.heartRate = heartRate;
        return this;
    }

    public VitalProperties setBodyTemperature(final int bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
        return this;
    }

    public VitalProperties setBloodPressure(final List<String> bloodPressure) {
        this.bloodPressure = bloodPressure;
        return this;
    }
}
