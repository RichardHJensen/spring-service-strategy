package com.rhjensen.examples.spring.strategies;

import com.rhjensen.examples.spring.domain.Systems;
import org.joda.time.LocalDate;

/**
 * User: rjensen
 * Date: 9/25/14
 * Time: 7:47 AM
 */
public class DefaultChooser implements SystemChooser {
    @Override
    public Systems chooseSystem() {
        return null;
    }

    @Override
    public Systems chooseSystem(LocalDate localDate) {
        return null;
    }
}
