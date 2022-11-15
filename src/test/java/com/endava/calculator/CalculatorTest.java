package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.extensions.TestExecutionExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(TestExecutionExtension.class)
public class CalculatorTest {
    private BasicOperations basicCalculator;


    @BeforeAll
    public static void setUpAllTests() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAllTests() {
        System.out.println("After all");
    }

    @BeforeEach
    public void setUpEachTest() {
        System.out.println("\nBefore each");
        basicCalculator = new Basic();
    }

    @AfterEach
    public void tearDownEachTest() {
        System.out.println("After each\n");
    }

    @Tags({@Tag("smoke"), @Tag("ui"),})
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumbersGivenOperand0(int a, int b) {

        //GIVEN
        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.add(a, b);

        //THEN
        System.out.println(result);
    }

    public static List<Arguments> numberProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2));
        argumentsList.add(Arguments.of(2, 0));
        return argumentsList;
    }

    @Tag("smoke")
    @Test
    public void shouldAddNegativeNumbers() {

        //GIVEN

        //WHEN
        long result = basicCalculator.add(-3, -2);
        //THEN
        System.out.println(result);

    }

    @Tags({@Tag("smoke"), @Tag("api"),})
    @Test
    public void shouldAddBigNumbers() {
        //GIVEN

        //WHEN
        long result = basicCalculator.add(Integer.MAX_VALUE, 1);
        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddNoOperands() {
        //GIVEN

        //WHEN
        long result = basicCalculator.add();
        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddOneOperand() {
        //GIVEN

        //WHEN
        long result = basicCalculator.add(1999);
        //THEN
        System.out.println(result);
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,4", "-1,+1,1,1"})
    @CsvFileSource(resources = "/numberSource.csv")
    public void shouldAddMoreThanTwoOperands(int a1, int a2, int a3, int a4) {
        //GIVEN

        //WHEN
        long result = basicCalculator.add(a1, a2, a3, a4);
        //THEN
        System.out.println(result);
    }

}
