package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;

public class TestCalculator {

    public static void main(String[] args) {
        BasicOperations b = new Basic(3);
        ExpertOperations e = new Expert(3);

        //add
        System.out.println(b.add(1, 4, 6, 1, 5));
        System.out.println(b.add(1.3, 1.4));

        //subtract
        System.out.println(b.substract(2));

        //multiply
        System.out.println(b.multiply(2, 6));
        System.out.println(b.multiply(3.5, 2.3));

        //divide
        System.out.println(b.divide(10, 3));
        System.out.println(b.divide(5, 0));
        System.out.println(b.divide(3.4, 1.2));

        //pow
        System.out.println(e.pow(2, -5));

        //root
        System.out.println(e.root(10));
        System.out.println(e.root(7));
        System.out.println(e.root(125,3));
        System.out.println(e.root(8,3));
        System.out.println(e.root(144,2));

        //factorial + factorial recursive
        System.out.println(e.factorial(6));
        System.out.println(e.factorialRecursive(6));

        //String expressions
        System.out.println("String expressions: ");
        System.out.println(e.calculate("2 * 4 + 11.2 / 3.2"));
        System.out.println(e.calculate("10 * 2 + 3 / 5 + 19"));
        System.out.println(e.calculate("-5-3*9"));
        System.out.println(e.calculate(" 2 * (3+2) / 5 "));
        System.out.println(e.calculate("(3+2)/5"));
        System.out.println(e.calculate("6+2/(5-4)"));
        System.out.println(e.calculate("2*(-3+2)"));
        System.out.println(e.calculate("(-3-5)/2"));
        System.out.println(e.calculate("2+(-3-5)*(-7-5)"));
        System.out.println(e.calculate("(3+2)/5*5+(8/2)"));
        System.out.println(e.calculate("3+4+5^2+(3^2-1) +2^0"));
        System.out.println(e.calculate("4+(3+5)*2+(5^2+1)"));

        System.out.println(e.calculate("4+(3+(5^2+1)+1)-4/2"));
        System.out.println(e.calculate("(4+2*(4+2+(2^2-1) +4) -3)"));
        System.out.println(e.calculate("(4/2*3+1/2+(3*4*(5^0)+1)-(2-1*(3-1)+1)+1)+3"));
        System.out.println(e.calculate("(1+2)*(3+4)"));
        System.out.println(e.calculate("(((2+3)*5)*(4+2))*3"));
        System.out.println(e.calculate("125$3 + 4*5"));

    }
}
