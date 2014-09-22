package com.rhjensen.examples.spring.strategies;

import com.rhjensen.examples.spring.domain.Systems;

/**
 * User: rjensen
 * Date: 9/22/14
 * Time: 2:37 PM
 */
public interface SystemChooser {
    Systems chooseSystem();
}
