package com.rhjensen.examples.spring.strategies;

import org.junit.Test;

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
