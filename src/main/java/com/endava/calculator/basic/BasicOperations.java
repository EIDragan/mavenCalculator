package com.endava.calculator.basic;

public interface BasicOperations{
    public abstract long add(int... no);

    public abstract long add(long... no);

    public abstract double add(double... no);

    public abstract int substract(int... no);

    public abstract long substract(long... no);

    public abstract double substract(double... no);

    public abstract long multiply(int... no);

    public abstract long multiply(long... no);

    public abstract double multiply(double... a);

    public abstract double divide(int... a);

    public abstract double divide(long... a);

    public abstract double divide(double... a);

}
