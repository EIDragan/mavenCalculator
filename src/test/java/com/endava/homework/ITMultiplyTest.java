package com.endava.homework;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.extensions.TestExecutionExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

//@ExtendWith(TestExecutionExtension.class)
public class ITMultiplyTest {

    private BasicOperations basicCalculator;

    @BeforeAll
    public static void setUpAllTests() {
        //System.out.println("Before All Tests");
    }

    @AfterAll
    public static void tearDownAllTests() {
        //System.out.println("After all tests");
    }

    @BeforeEach
    public void setUpEachTest() {
        //System.out.println("\nBefore each");
        basicCalculator = new Basic();
    }

    @AfterEach
    public void tearDownEachTest() {
        //System.out.println("After each\n");
    }

    @Test
    public void shouldMultiplyNoOperand() {

        //when
        long result = basicCalculator.multiply();
        //then
        assertThat(result, is(1L));

    }

    @Test
    public void shouldMultiplyWith0IntegerOperand() {

        //when
        long result = basicCalculator.multiply(0, 1);
        //then
        assertThat(result, is(0L));

    }

    @Test
    public void shouldMultiplyWith0LongOperand() {

        //when
        long result = basicCalculator.multiply(0L, 1L);
        //then
        assertThat(result, is(0L));

    }

    @Test
    public void shouldMultiplyWith0DoubleOperand() {

        //when
        double result = basicCalculator.multiply(0.0, 5.6);
        //then
        assertThat(result, is(0.0));

    }

    @Test
    public void shouldMultiplyWith1IntegerOperand() {

        //when
        long result = basicCalculator.multiply(6);
        //then
        assertThat(result, is(6L));

    }

    @Test
    public void shouldMultiplyWith1LongOperand() {

        //when
        long result = basicCalculator.multiply(Long.MAX_VALUE);
        //then
        assertThat(result, is(Long.MAX_VALUE));

    }

    @Test
    public void shouldMultiplyWith1DoubleOperand() {

        //when
        double result = basicCalculator.multiply(35432.1234);
        //then
        assertThat(result, is(35432.1234));

    }

    @Test
    public void shouldMultiplyWithNegativeIntegerOperands() {

        //when
        long result = basicCalculator.multiply(-5, -1, -10, 20);
        //then
        assertThat(result, is(-1000L));

    }

    @Test
    public void shouldMultiplyWithNegativeLongOperands() {

        //when
        long result = basicCalculator.multiply(-5L, -1L, -1000L, 2000000L);
        //then
        assertThat(result, is(-10000000000L));

    }

    @Test
    public void shouldMultiplyWithNegativeDoubleOperands() {

        //when
        double result = basicCalculator.multiply(125.0, -10.0, 50.0, 1.67);
        //then
        assertThat(result, is(-104375.0));

    }

    @ParameterizedTest
    @MethodSource("iNumbersProvider")
    public void shouldMultiply2orMoreIntegerOperands(long expected, int... no) {
        //when
        long result = basicCalculator.multiply(no);
        //then
        assertThat(result, is(expected));

    }

    public static List<Arguments> iNumbersProvider() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.of(6, new int[]{1, 2, 3}));
        list.add(Arguments.of(0, new int[]{1, 0, 10, 1}));
        list.add(Arguments.of(-6720, new int[]{-10, 12, 2, 4, 7}));
        return list;
    }


    @ParameterizedTest
    @MethodSource("lNumbersProvider")
    public void shouldMultiply2orMoreLongOperands(long expected, long... no) {
        //when
        long result = basicCalculator.multiply(no);
        //then
        assertThat(result, is(expected));

    }

    public static List<Arguments> lNumbersProvider() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.of(-866664, new long[]{1, 288888, -3}));
        list.add(Arguments.of(0, new long[]{1, 0, 100000000, 1}));
        list.add(Arguments.of(265063680, new long[]{10, 12, 78888, 4, 7}));
        return list;
    }

    @ParameterizedTest
    @MethodSource("dNumbersProvider")
    public void shouldMultiply2orMoreDoubleOperands(double expected, double... no) {
        //when
        double result = basicCalculator.multiply(no);
        //then
        assertThat(result, is(expected));

    }

    public static List<Arguments> dNumbersProvider() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.of(8.602, new double[]{1.1, 2.3, 3.4}));
        list.add(Arguments.of(0.0, new double[]{1.4, 0.0, 10.7, 1.8}));
        list.add(Arguments.of(-6720.0, new double[]{10.0, 12.0, 2.0, 4.0, -7.0}));
        return list;
    }

    @Test
    public void shouldMultiplyBigIntegerNumbers() {

        //when
        long result = basicCalculator.multiply(Integer.MAX_VALUE, 2);
        //then
        assertThat(result, is(Integer.MAX_VALUE * 2L));

    }

    @Test
    public void shouldMultiplyBigLongNumbers() {

        //when
        long result = basicCalculator.multiply(10000000L, 10000000L);
        //then
        assertThat(result, is(100000000000000L));

    }

    @Test
    public void shouldMultiplyBigDoubleNumbers() {

        //when
        double result = basicCalculator.multiply(1000000.0, 756777.567);
        //then
        assertThat(result, is(7.56777567E11));

    }
}
