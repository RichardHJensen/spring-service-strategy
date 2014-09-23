package com.rhjensen.examples.spring.services;

import com.rhjensen.examples.spring.strategies.SystemChooser;
import org.joda.time.LocalDate;

/**
 * User: rjensen
 * Date: 9/23/14
 * Time: 5:52 AM
 */
public class BetaService {
    private SystemChooser chooser;

    BetaService(SystemChooser chooser) { this.chooser = chooser; }

    public String invoke() { return chooser.chooseSystem().name(); }

    public String invoke(LocalDate localDate) { return chooser.chooseSystem(localDate).name(); }
}
