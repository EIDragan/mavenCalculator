package com.endava.calculator;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.endava.matchers.InLastFiveMinutes.isInLastFiveMinutes;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.endava.matchers.DateAssert.assertThat;

public class DateTest {

    @Test
    public void testDates(){

        LocalDateTime actual = LocalDateTime.now();

        assertThat(actual, isInLastFiveMinutes());
    }
    @Test
    public void testDatesAssertJ(){

        LocalDateTime actual = LocalDateTime.now();
        assertThat(actual).inLastFiveMinutes();
    }
}
