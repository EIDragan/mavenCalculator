package com.endava.homework;

import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import com.endava.extensions.TestExecutionExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


//@ExtendWith(TestExecutionExtension.class)
public class ITFactorialTest {

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
    public void shouldCalculate0factorial(){

        //when
        long result = expertCalculator.factorial(0);
        //then
        assertThat(result, is(1L));

    }

    @Test
    public void shouldCalculate1factorial(){

        //when
        long result = expertCalculator.factorial(1);
        //then
        assertThat(result, is(1L));
    }

    @Test
    public void calculateFactorialFromNegative(){

        //when
        long result = expertCalculator.factorial(-4);
        //then
        assertThat(result, is(0L));
    }

    @ParameterizedTest
    @CsvSource({"4, 24","10, 3628800", "20, 2432902008176640000"})
    public void calculateFactorialFromNumberBiggerThan1(int n, long expected){

        //when
        long result = expertCalculator.factorial(n);
        //then
        assertThat(result, is(expected));

    }

}
