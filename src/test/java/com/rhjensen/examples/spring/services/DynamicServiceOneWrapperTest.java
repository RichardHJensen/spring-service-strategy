package com.rhjensen.examples.spring.services;

import com.rhjensen.examples.spring.services.ServiceOneEndpoint;
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
 * Time: 6:06 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/dynamic-service-chooser-context.xml")
public class DynamicServiceOneWrapperTest {
    @Autowired
    ServiceOneEndpoint serviceOne;

    @Test
    public void shouldBeUsingImprovedServiceOneInEvenMonths() {
        assertThat(serviceOne.operationTwo(new LocalDate(2014, 2, 1)), is("ImprovedServiceOne_1.0 -- operationTwo(2014/02/01)"));
        assertThat(serviceOne.operationTwo(new LocalDate(2014, 4, 2)), is("ImprovedServiceOne_1.0 -- operationTwo(2014/04/02)"));
        assertThat(serviceOne.operationTwo(new LocalDate(2014, 6, 4)), is("ImprovedServiceOne_1.0 -- operationTwo(2014/06/04)"));
        assertThat(serviceOne.operationTwo(new LocalDate(2014, 8, 8)), is("ImprovedServiceOne_1.0 -- operationTwo(2014/08/08)"));
        assertThat(serviceOne.operationTwo(new LocalDate(2014, 10, 16)), is("ImprovedServiceOne_1.0 -- operationTwo(2014/10/16)"));
        assertThat(serviceOne.operationTwo(new LocalDate(2014, 12, 31)), is("ImprovedServiceOne_1.0 -- operationTwo(2014/12/31)"));
    }

    @Test
    public void shouldBeUsingClassicServiceOneInOddMonths() {
        assertThat(serviceOne.operationTwo(new LocalDate(2014, 1, 1)), is("ClassicServiceOne_14.8 -- operationTwo(01/01/2014)"));
        assertThat(serviceOne.operationTwo(new LocalDate(2014, 3, 2)), is("ClassicServiceOne_14.8 -- operationTwo(03/02/2014)"));
        assertThat(serviceOne.operationTwo(new LocalDate(2014, 5, 3)), is("ClassicServiceOne_14.8 -- operationTwo(05/03/2014)"));
        assertThat(serviceOne.operationTwo(new LocalDate(2014, 7, 7)), is("ClassicServiceOne_14.8 -- operationTwo(07/07/2014)"));
        assertThat(serviceOne.operationTwo(new LocalDate(2014, 9, 15)), is("ClassicServiceOne_14.8 -- operationTwo(09/15/2014)"));
        assertThat(serviceOne.operationTwo(new LocalDate(2014, 11, 30)), is("ClassicServiceOne_14.8 -- operationTwo(11/30/2014)"));
    }

    @Test
    public void shouldUseImprovedWhenBothDatesAreInEvenMonths() {
        assertThat(serviceOne.operationThree(new LocalDate(2014, 2, 1), new LocalDate(2014, 4, 3)),
                is("ImprovedServiceOne_1.0 -- operationThree(2014/02/01, 2014/04/03)"));
        assertThat(serviceOne.operationThree(new LocalDate(2014, 6, 10), new LocalDate(2014, 8, 15)),
                is("ImprovedServiceOne_1.0 -- operationThree(2014/06/10, 2014/08/15)"));
        assertThat(serviceOne.operationThree(new LocalDate(2014, 10, 17), new LocalDate(2014, 12, 31)),
                is("ImprovedServiceOne_1.0 -- operationThree(2014/10/17, 2014/12/31)"));
        assertThat(serviceOne.operationThree(new LocalDate(2014, 12, 1), new LocalDate(2015, 2, 3)),
                is("ImprovedServiceOne_1.0 -- operationThree(2014/12/01, 2015/02/03)"));
        assertThat(serviceOne.operationThree(new LocalDate(2015, 2, 1), new LocalDate(2014, 4, 3)),
                is("ImprovedServiceOne_1.0 -- operationThree(2015/02/01, 2014/04/03)"));
    }

    @Test
    public void shouldUseClassicWhenBothDatesAreInOddMonths() {
        assertThat(serviceOne.operationThree(new LocalDate(2014, 1, 1), new LocalDate(2014, 3, 3)),
                is("ClassicServiceOne_14.8 -- operationThree(01/01/2014, 03/03/2014)"));
        assertThat(serviceOne.operationThree(new LocalDate(2014, 5, 10), new LocalDate(2014, 7, 15)),
                is("ClassicServiceOne_14.8 -- operationThree(05/10/2014, 07/15/2014)"));
        assertThat(serviceOne.operationThree(new LocalDate(2014, 9, 17), new LocalDate(2014, 11, 30)),
                is("ClassicServiceOne_14.8 -- operationThree(09/17/2014, 11/30/2014)"));
        assertThat(serviceOne.operationThree(new LocalDate(2014, 11, 1), new LocalDate(2015, 1, 3)),
                is("ClassicServiceOne_14.8 -- operationThree(11/01/2014, 01/03/2015)"));
        assertThat(serviceOne.operationThree(new LocalDate(2015, 1, 1), new LocalDate(2014, 2, 3)),
                is("ClassicServiceOne_14.8 -- operationThree(01/01/2015, 02/03/2014)"));
    }

}
