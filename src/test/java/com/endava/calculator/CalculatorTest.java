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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

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
    public void shouldAddNumbersGivenOperand0(int a, int b, long expected) {

        //WHEN
        long result = basicCalculator.add(a, b);

        //THEN
        assertThat(result, is(expected));
    }

    public static List<Arguments> numberProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2, 2));
        argumentsList.add(Arguments.of(2, 0, 2));
        return argumentsList;
    }

    @Tag("smoke")
    @Test
    public void shouldAddNegativeNumbers() {

        //GIVEN

        //WHEN
        Long result = basicCalculator.add(-3, -2);
        //THEN
        assertEquals(-5L, result);
        assertTrue(result.equals(-5L));

    }

    //BUG Found: JIRA - 187107
    @Tags({@Tag("smoke"), @Tag("api"),})
    @Test
    @DisplayName( "Test that adds a big number as: MAX INT" )
    public void shouldAddBigNumbers() {

        assertThrows(AssertionError.class, () -> {

            //WHEN
            Long result = basicCalculator.add(Integer.MAX_VALUE, 1);
            //THEN
            assertThat(result, is(Integer.MAX_VALUE + 1L));
            assertThat(result, notNullValue());
            assertThat(result, lessThan(0L));
        });
    }

    @Test
    public void shouldAddNoOperands() {

        //WHEN
        long result = basicCalculator.add();
        //THEN
        assertThat(result, is(0L));
    }

    @Test
    public void shouldAddOneOperand() {

        //WHEN
        long result = basicCalculator.add(1999);
        //THEN
        assertThat(result, is(1999L));
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,4,10", "-1,+1,1,1,2"})
    @CsvFileSource(resources = "/numberSource.csv")
    public void shouldAddMoreThanTwoOperands(int a1, int a2, int a3, int a4, Long expected) {

        //WHEN
        long result = basicCalculator.add(a1, a2, a3, a4);
        //THEN
        assertThat(result, is(expected));
    }

}
