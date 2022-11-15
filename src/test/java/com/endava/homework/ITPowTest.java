package com.endava.homework;

import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import com.endava.extensions.TestExecutionExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

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
    public void base0(){

        //when
        double result = expertCalculator.pow(0,1);
        //then
        System.out.println(result);

    }

    @Test
    public void exponent0(){

        //when
        double result = expertCalculator.pow(4,0);
        //then
        System.out.println(result);

    }

    @Test
    public void base0Exponent0(){

        //when
        double result = expertCalculator.pow(0,0);
        //then
        System.out.println(result);

    }

    @Test
    public void negativeBase(){

        //when
        double result = expertCalculator.pow(-3,3);
        //then
        System.out.println(result);

    }

    @Test
    public void negativeExponent(){

        //when
        double result = expertCalculator.pow(3,-3.2);
        //then
        System.out.println(result);

    }

    @Test
    public void negativeBaseNegativeExponent(){

        //when
        double result = expertCalculator.pow(-10,-4);
        //then
        System.out.println(result);

    }

    @Test
    public void bigBaseNumber(){

        //when
        double result = expertCalculator.pow(Double.MAX_VALUE,2);
        //then
        System.out.println(result);

    }

    @Test
    public void maxExponentNumber(){

        //when
        double result = expertCalculator.pow(2, 112);
        //then
        System.out.println(result);

    }

}
