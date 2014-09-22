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
 * Date: 9/22/14
 * Time: 3:46 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/alpha-system-one-context.xml")
public class AlphaServiceTest {
    @Autowired
    AlphaService service;

    @Test
    public void shouldUseSystemOneChooser() {
        assertThat(service.invoke(), is("SystemOne"));
    }

    @Test
    public void shouldUseSystemOneChooserForDateAsWell() {
        assertThat(service.invoke(new LocalDate()), is("SystemOne"));
    }

}
