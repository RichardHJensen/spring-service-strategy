package com.rhjensen.examples.spring.services;

import com.rhjensen.examples.spring.domain.Systems;
import com.rhjensen.examples.spring.strategies.SystemChooser;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: rjensen
 * Date: 9/23/14
 * Time: 8:42 AM
 */
public class ServiceOneWrapper implements ServiceOneEndpoint {
    private SystemChooser chooser;
    @Autowired
    private ClassicServiceOne classic;
    @Autowired
    private ImprovedServiceOne improved;

    ServiceOneWrapper(SystemChooser chooser) { this.chooser = chooser; }

    @Override
    public int majorVersion() {
        int version = -1;
        switch (chooser.chooseSystem()) {
            case SystemOne:
                version = classic.majorVersion();
                break;
            case SystemTwo:
                version = improved.majorVersion();
                break;
            case NONE:
                version = -100;
                break;
            default:
                version = 0;
        }
        return version;
    }

    @Override
    public int minorVersion() {
        int version = -1;
        switch (chooser.chooseSystem()) {
            case SystemOne:
                version = classic.minorVersion();
                break;
            case SystemTwo:
                version = improved.minorVersion();
                break;
            case NONE:
                version = -10;
                break;
            default:
                version = 0;
        }
        return version;
    }

    @Override
    public String endpointName() {
        return (Systems.SystemTwo == chooser.chooseSystem())?improved.endpointName():classic.endpointName();
    }

    @Override
    public String operationOne() {
        return (Systems.SystemTwo == chooser.chooseSystem())?improved.operationOne():classic.operationOne();
    }

    @Override
    public String operationTwo(LocalDate serviceDate) {
        if (Systems.SystemTwo == chooser.chooseSystem(serviceDate)) {
            return improved.operationTwo(serviceDate);
        } else {
            return classic.operationTwo(serviceDate);
        }
    }

    @Override
    public String operationThree(LocalDate beginDate, LocalDate endDate) {
        Systems beginSystem = chooser.chooseSystem(beginDate);
        Systems endSystem = chooser.chooseSystem(endDate);
        if (Systems.SystemTwo == beginSystem && Systems.SystemTwo == endSystem) {
            return improved.operationThree(beginDate, endDate);
        } else {
            return classic.operationThree(beginDate, endDate);
        }
    }
}
