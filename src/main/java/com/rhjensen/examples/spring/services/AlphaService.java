package com.rhjensen.examples.spring.services;

import com.rhjensen.examples.spring.strategies.SystemChooser;
import com.rhjensen.examples.spring.strategies.SystemOneChooser;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* User: rjensen
* Date: 9/22/14
* Time: 4:06 PM
*/
@Service
class AlphaService {
    private SystemChooser chooser;

    AlphaService(SystemChooser chooser) { this.chooser = chooser; }
    public String invoke() {
        return chooser.chooseSystem().name();
    }

    public String invoke(LocalDate localDate) {
        return chooser.chooseSystem(localDate).name();
    }
}
