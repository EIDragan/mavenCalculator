package com.endava.calculator.basic;

public class Basic implements BasicOperations {
    //2 constructori pentru pornirea calculatorului

    protected int decimals;

    public Basic() {
        //by default calculatorul porneste cu 10
        decimals = 10;
    }

    public Basic(int decimals) {
        this.decimals = decimals;
    }

    @Override
    public long add(int... no) {
        long sum = 0;
        for (int n : no) {
            sum += n;
        }
        return sum;
    }

    @Override
    public long add(long... no) {
        int sum = 0;
        for (long n : no) {
            sum += n;
        }
        return sum;
    }

    @Override
    public double add(double... no) {
        double sum = 0;
        for (double n : no) {
            sum += n;
        }
        return sum;
    }

    @Override
    public int substract(int... no) {
        int result = no[0];
        for (int i = 1; i < no.length; i++) result -= no[i];
        return result;
    }

    @Override
    public long substract(long... no) {
        long result = no[0];
        for (int i = 1; i < no.length; i++) result -= no[i];
        return result;
    }

    @Override
    public double substract(double... no) {
        double result = no[0];
        for (int i = 1; i < no.length; i++) result -= no[i];
        return result;
    }

    @Override
    //facem cast unei variabile la long
    public long multiply(int... no) {
        long result = 1;
        for (int n : no) {
            result *= n;
        }
        return result;
    }

    @Override
    public long multiply(long... no) {
        long result = 1;
        for (long n : no) {
            result *= n;
        }
        return result;
    }

    @Override
    public double multiply(double... no) {
        double result = 1;
        for (double n : no) {
            result *= n;
        }
        return formatNumber(result);
    }

    @Override
    public double divide(int... no) {
        double result = no[0];
        for (int i = 1; i < no.length; i++) {
            result /= no[i];
        }
        return formatNumber(result);
    }

    @Override
    public double divide(long... no) {
        double result = no[0];
        for (long n : no) {
            result /= n;
        }
        return formatNumber(result);
    }

    @Override
    public double divide(double... no) {
        double result = no[0];
        for (int i = 1; i < no.length; i++) {
            result = result / no[i];
        }
        return formatNumber(result);
    }

    //protected sa fie vizibila si in copil
    protected double formatNumber(double n) {
        String s = String.format("%." + decimals + "f", n);
        return Double.parseDouble(s);
    }
}