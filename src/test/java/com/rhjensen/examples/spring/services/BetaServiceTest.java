package com.rhjensen.examples.spring.services;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: rjensen
 * Date: 9/23/14
 * Time: 5:47 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/beta-date-based-context.xml")
public class BetaServiceTest {
    @Autowired
    BetaService service;

    @Test
    public void shouldUseSystemOneForOddMonths() {
        assertThat(service.invoke(new LocalDate(2014, 1, 1)), is("SystemOne"));
        assertThat(service.invoke(new LocalDate(2014, 3, 1)), is("SystemOne"));
        assertThat(service.invoke(new LocalDate(2014, 5, 1)), is("SystemOne"));
        assertThat(service.invoke(new LocalDate(2014, 7, 1)), is("SystemOne"));
        assertThat(service.invoke(new LocalDate(2014, 9, 1)), is("SystemOne"));
        assertThat(service.invoke(new LocalDate(2014, 11, 1)), is("SystemOne"));
    }

    @Test
    public void shouldUseSystemTwoForEvenMonths() {
        assertThat(service.invoke(new LocalDate(2014, 2, 1)), is("SystemTwo"));
        assertThat(service.invoke(new LocalDate(2014, 4, 1)), is("SystemTwo"));
        assertThat(service.invoke(new LocalDate(2014, 6, 1)), is("SystemTwo"));
        assertThat(service.invoke(new LocalDate(2014, 8, 1)), is("SystemTwo"));
        assertThat(service.invoke(new LocalDate(2014, 10, 1)), is("SystemTwo"));
        assertThat(service.invoke(new LocalDate(2014, 12, 1)), is("SystemTwo"));
    }

    @Test
    public void shouldUseNoneIfInvocationNotDateBased() {
        assertThat(service.invoke(), is("NONE"));
    }

}
