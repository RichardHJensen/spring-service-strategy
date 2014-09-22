package com.rhjensen.examples.spring.strategies;

import com.rhjensen.examples.spring.domain.Systems;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: rjensen
 * Date: 9/22/14
 * Time: 1:52 PM
 */
public class SystemOneChooserTest {
    @Test
    public void shouldAlwaysChooseSystemOne() {
        SystemChooser chooser = new SystemOneChooser();
        assertThat(chooser.chooseSystem(), is(Systems.SystemOne));
    }

}
