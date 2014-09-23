package com.rhjensen.examples.spring.services;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.MessageFormat;

/**
 * User: rjensen
 * Date: 9/23/14
 * Time: 6:17 AM
 */
public class ClassicServiceOne implements ServiceOneEndpoint {

    private final DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("MM/dd/yyyy");

    @Override
    public int majorVersion() {
        return 14;
    }

    @Override
    public int minorVersion() {
        return 8;
    }

    @Override
    public String endpointName() {
        return "ClassicServiceOne";
    }

    @Override
    public String operationOne() {
        return MessageFormat.format("{0}_{1}.{2} -- operationOne()", endpointName(), majorVersion(), minorVersion());
    }

    @Override
    public String operationTwo(LocalDate serviceDate) {
        return MessageFormat.format("{0}_{1}.{2} -- operationTwo({3})", endpointName(), majorVersion(), minorVersion(), serviceDate.toString(dateFormatter));
    }

    @Override
    public String operationThree(LocalDate beginDate, LocalDate endDate) {
        return MessageFormat.format("{0}_{1}.{2} -- operationThree({3}, {4})", endpointName(), majorVersion(), minorVersion(),
                beginDate.toString(dateFormatter), endDate.toString(dateFormatter));
    }
}
