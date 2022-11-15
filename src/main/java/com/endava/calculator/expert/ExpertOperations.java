package com.endava.calculator.expert;

import com.endava.calculator.basic.BasicOperations;

public interface ExpertOperations extends BasicOperations {
    public abstract double pow(double base, double exponent);

    public double root(int a);
    public double root(double a, double n);
    public long factorial(int n);

    public long factorialRecursive(int n);
    abstract double calculate(String stringToCalculate);
}
