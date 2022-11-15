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
        System.out.println(result);

    }

    @Test
    public void shouldMultiplyWith0IntegerOperand() {

        //when
        long result = basicCalculator.multiply(0, 1);
        //then
        System.out.println(result);

    }
    @Test
    public void shouldMultiplyWith0LongOperand() {

        //when
        long result = basicCalculator.multiply(0L, 1L);
        //then
        System.out.println(result);

    }

    @Test
    public void shouldMultiplyWith0DoubleOperand() {

        //when
        double result = basicCalculator.multiply(0.0, 5.6);
        //then
        System.out.println(result);

    }

    @Test
    public void shouldMultiplyWith1IntegerOperand() {

        //when
        long result = basicCalculator.multiply(6);
        //then
        System.out.println(result);

    }

    @Test
    public void shouldMultiplyWith1LongOperand() {

        //when
        long result = basicCalculator.multiply(Long.MAX_VALUE);
        //then
        System.out.println(result);

    }

    @Test
    public void shouldMultiplyWith1DoubleOperand() {

        //when
        double result = basicCalculator.multiply(35432.1234);
        //then
        System.out.println(result);

    }

    @Test
    public void shouldMultiplyWithNegativeIntegerOperands() {

        //when
        long result = basicCalculator.multiply(-5, -1, -10, 20);
        //then
        System.out.println(result);

    }

    @Test
    public void shouldMultiplyWithNegativeLongOperands() {

        //when
        long result = basicCalculator.multiply(-5L, -1L, -1000L, 2000000L);
        //then
        System.out.println(result);

    }

    @Test
    public void shouldMultiplyWithNegativeDoubleOperands() {

        //when
        double result = basicCalculator.multiply(125.0, -10.0, 50.0, 1.67);
        //then
        System.out.println(result);

    }


    @ParameterizedTest
    @MethodSource("iNumbersProvider")
    public void shouldMultiply2orMoreIntegerOperands(int... no) {
        //when
        long result = basicCalculator.multiply(no);
        //then
        System.out.println(result);

    }

    public static List<Arguments> iNumbersProvider() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.of(new int[]{1, 2, 3}));
        list.add(Arguments.of(new int[]{1, 0, 10, 1}));
        list.add(Arguments.of(new int[]{-10, 12, 2, 4, 7}));
        return list;
    }


    @ParameterizedTest
    @MethodSource("lNumbersProvider")
    public void shouldMultiply2orMoreLongOperands(long... no) {
        //when
        long result = basicCalculator.multiply(no);
        //then
        System.out.println(result);

    }

    public static List<Arguments> lNumbersProvider() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.of(new long[]{1, 288888, -3}));
        list.add(Arguments.of(new long[]{1, 0, 100000000, 1}));
        list.add(Arguments.of(new long[]{10, 12, 78888, 4, 7}));
        return list;
    }

    @ParameterizedTest
    @MethodSource("dNumbersProvider")
    public void shouldMultiply2orMoreDoubleOperands(double... no) {
        //when
        double result = basicCalculator.multiply(no);
        //then
        System.out.println(result);

    }

    public static List<Arguments> dNumbersProvider() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.of(new double[]{1.1, 2.3, 3.4}));
        list.add(Arguments.of(new double[]{1.4, 0.0, 10.7, 1.8}));
        list.add(Arguments.of(new double[]{10.0, 12.0, 2.0, 4.0, -7.0}));
        return list;
    }

    @Test
    public void shouldMultiplyBigIntegerNumbers() {

        //when
        long result = basicCalculator.multiply(Integer.MAX_VALUE, 2);
        //then
        System.out.println(result);

    }

    @Test
    public void shouldMultiplyBigLongNumbers() {

        //when
        long result = basicCalculator.multiply(10000000L, 10000000L);
        //then
        System.out.println(result);

    }

    @Test
    public void shouldMultiplyBigDoubleNumbers() {

        //when
        double result = basicCalculator.multiply(1000000.0, 756777.567);
        //then
        System.out.println(result);

    }
}
