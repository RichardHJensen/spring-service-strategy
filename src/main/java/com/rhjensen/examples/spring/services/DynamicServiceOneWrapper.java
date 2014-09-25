package com.rhjensen.examples.spring.services;

import com.rhjensen.examples.spring.domain.Systems;
import com.rhjensen.examples.spring.strategies.DynamicSystemChooser;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * User: rjensen
 * Date: 9/25/14
 * Time: 8:45 AM
 */
public class DynamicServiceOneWrapper implements ServiceOneEndpoint {
    private static final String SERVICE_NAME = "serviceOne";
    @Autowired
    DynamicSystemChooser serviceChooser;

    private Map<Systems, ServiceOneEndpoint> endpointMap;
    
    @Override
    public int majorVersion() {
        return endpointMap.get(serviceChooser.chooseSystem(SERVICE_NAME)).majorVersion();
    }

    @Override
    public int minorVersion() {
        return endpointMap.get(serviceChooser.chooseSystem(SERVICE_NAME)).minorVersion();
    }

    @Override
    public String endpointName() {
        return endpointMap.get(serviceChooser.chooseSystem(SERVICE_NAME)).endpointName();
    }

    @Override
    public String operationOne() {
        return endpointMap.get(serviceChooser.chooseSystem(SERVICE_NAME)).operationOne();
    }

    @Override
    public String operationTwo(LocalDate serviceDate) {
        return endpointMap.get(serviceChooser.chooseSystem(SERVICE_NAME, serviceDate)).operationTwo(serviceDate);
    }

    @Override
    public String operationThree(LocalDate beginDate, LocalDate endDate) {
        return endpointMap.get(serviceChooser.chooseSystem(SERVICE_NAME, beginDate)).operationThree(beginDate, endDate);
    }

    public void setEndpointMap(Map<Systems, ServiceOneEndpoint> endpointMap) {
        this.endpointMap = endpointMap;
    }

}
