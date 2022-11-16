package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTestAssertJ {

    private BasicOperations basicCalculator = new Basic();

    @Test
    public void shouldAddOneOperand() {

        //WHEN
        long result = basicCalculator.add(1999);
        //THEN
        System.out.println(result);

        assertThat(result).isEqualTo(1999)
                .isGreaterThan(150)
                .isNotNegative()
                .isBetween(1800L,2000L)
                .isNotNull();
    }
}
