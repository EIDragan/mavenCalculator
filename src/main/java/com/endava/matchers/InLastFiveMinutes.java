package com.endava.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.time.LocalDateTime;

public class InLastFiveMinutes extends TypeSafeMatcher<LocalDateTime> {

    @Override
    protected boolean matchesSafely(LocalDateTime actual) {
        //create date ul trebuie sa se fi intamplat in ultimele 5 minute
        LocalDateTime fiveMinutesAgo = LocalDateTime.now().minusMinutes(5L);
        return actual.isAfter(fiveMinutesAgo)  && actual.isBefore(LocalDateTime.now()) ;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Date is not in the last five minutes");
    }

    public static InLastFiveMinutes isInLastFiveMinutes(){
        return new InLastFiveMinutes();
    }
}
