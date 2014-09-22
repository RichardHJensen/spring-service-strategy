package com.rhjensen.examples.spring.strategies;

import com.rhjensen.examples.spring.domain.Systems;
import org.joda.time.LocalDate;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: rjensen
 * Date: 9/22/14
 * Time: 3:20 PM
 */
public class DateBasedChooserTest {
    @Test
    public void shouldReturnSystemOneForOddMonths() {
        SystemChooser chooser = new DateBasedChooser();
        assertThat(chooser.chooseSystem(new LocalDate(2014, 1, 1)), is(Systems.SystemOne));
        assertThat(chooser.chooseSystem(new LocalDate(2014, 3, 1)), is(Systems.SystemOne));
        assertThat(chooser.chooseSystem(new LocalDate(2014, 5, 1)), is(Systems.SystemOne));
        assertThat(chooser.chooseSystem(new LocalDate(2014, 7, 1)), is(Systems.SystemOne));
        assertThat(chooser.chooseSystem(new LocalDate(2014, 9, 1)), is(Systems.SystemOne));
        assertThat(chooser.chooseSystem(new LocalDate(2014, 11, 1)), is(Systems.SystemOne));
    }

    @Test
    public void shouldReturnSystemTwoForEvenMonths() {
        SystemChooser chooser = new DateBasedChooser();
        assertThat(chooser.chooseSystem(new LocalDate(2014, 2, 1)), is(Systems.SystemTwo));
        assertThat(chooser.chooseSystem(new LocalDate(2014, 4, 1)), is(Systems.SystemTwo));
        assertThat(chooser.chooseSystem(new LocalDate(2014, 6, 1)), is(Systems.SystemTwo));
        assertThat(chooser.chooseSystem(new LocalDate(2014, 8, 1)), is(Systems.SystemTwo));
        assertThat(chooser.chooseSystem(new LocalDate(2014, 10, 1)), is(Systems.SystemTwo));
        assertThat(chooser.chooseSystem(new LocalDate(2014, 12, 1)), is(Systems.SystemTwo));
    }

}
