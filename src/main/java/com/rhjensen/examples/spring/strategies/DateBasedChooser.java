package com.rhjensen.examples.spring.strategies;

import com.rhjensen.examples.spring.domain.Systems;
import org.joda.time.LocalDate;

/**
* User: rjensen
* Date: 9/22/14
* Time: 4:16 PM
*/
public class DateBasedChooser implements SystemChooser {
    @Override
    public Systems chooseSystem() {
        return Systems.NONE;
    }

    @Override
    public Systems chooseSystem(LocalDate localDate) {
        return ((localDate.getMonthOfYear() % 2) == 1)?Systems.SystemOne:Systems.SystemTwo;
    }
}
