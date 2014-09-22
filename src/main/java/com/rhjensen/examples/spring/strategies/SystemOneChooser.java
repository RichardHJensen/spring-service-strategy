package com.rhjensen.examples.spring.strategies;

import com.rhjensen.examples.spring.domain.Systems;
import org.joda.time.LocalDate;

/**
* User: rjensen
* Date: 9/22/14
* Time: 4:12 PM
*/
public class SystemOneChooser implements SystemChooser {
    @Override
    public Systems chooseSystem() {
        return Systems.SystemOne;
    }

    @Override
    public Systems chooseSystem(LocalDate localDate) {
        return Systems.SystemOne;
    }
}
