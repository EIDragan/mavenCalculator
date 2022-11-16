package com.endava.homework;

import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import com.endava.extensions.TestExecutionExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

//@ExtendWith(TestExecutionExtension.class)
public class ITPowTest {

    ExpertOperations expertCalculator;

    @BeforeAll
    public static void setUpAllTests() {
        System.out.println("Before All Tests");
    }

    @AfterAll
    public static void tearDownAllTests() {
        System.out.println("After all tests");
    }

    @BeforeEach
    public void setUpEachTest() {
        System.out.println("\nBefore each");
        expertCalculator = new Expert();
    }

    @AfterEach
    public void tearDownEachTest() {
        System.out.println("After each\n");
    }

    @Test
    public void base0() {

        //when
        double result = expertCalculator.pow(0, 1);
        //then
        assertThat(result, is(0.0));

    }

    @Test
    public void exponent0() {

        //when
        double result = expertCalculator.pow(4, 0);
        //then
        assertThat(result, is(1.0));

    }

    @Test
    public void base0Exponent0() {

        //when
        double result = expertCalculator.pow(0, 0);
        //then
        assertThat(result, is(1.0));

    }

    @Test
    public void negativeBase() {

        //when
        double result = expertCalculator.pow(-3, 3);
        //then
        assertThat(result, is(-27.0));

    }

    @Test
    public void negativeExponent() {

        //when
        double result = expertCalculator.pow(3, -3.2);
        //then
        assertThat(result, is(0.037037037));

    }

    @Test
    public void negativeBaseNegativeExponent() {

        //when
        double result = expertCalculator.pow(-10, -4);
        //then
        assertThat(result, is(1.0E-4));

    }

    @Test
    public void bigBaseNumber() {

        //when
        double result = expertCalculator.pow(Long.MAX_VALUE, 2);
        //then
        assertThat(result, is(8.507059173023462E37));

    }

    @Test
    public void maxExponentNumber() {

        //when
        double result = expertCalculator.pow(2, 112);
        //then
        assertThat(result, is(5.1922968585348276E33));

    }

}
