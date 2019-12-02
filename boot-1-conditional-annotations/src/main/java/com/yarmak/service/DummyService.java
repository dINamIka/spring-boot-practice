package com.yarmak.service;

import java.text.MessageFormat;

public abstract class DummyService {

    private final String serviceName;

    public DummyService(final String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceStatus() {
        return MessageFormat.format("{0} is initialized", serviceName);
    }
}
