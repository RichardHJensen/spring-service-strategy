package com.rhjensen.examples.spring.services;

import org.joda.time.LocalDate;

/**
 * User: rjensen
 * Date: 9/23/14
 * Time: 6:14 AM
 */
public interface ServiceOneEndpoint {
    int majorVersion();
    int minorVersion();
    String endpointName();

    String operationOne();
    String operationTwo(LocalDate serviceDate);
    String operationThree(LocalDate beginDate, LocalDate endDate);
}
