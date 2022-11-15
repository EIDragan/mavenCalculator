package com.endava.calculator.expert;

import com.endava.calculator.basic.Basic;

public class Expert extends Basic implements ExpertOperations {
    private final String[] operators = {"+", "-", "%", "^","$","*", "/"};


    public Expert() {
        decimals = 10;
    }

    public Expert(int decimals) {
        this.decimals = decimals;
    }

    @Override
    public double pow(double base, double exponent) {
        //ridicarea la putere este o inmultire repetata, a^b = a*a*a...*a de b ori
        double result = 1;
        for (int i = 1; i <= Math.abs(exponent); i++) {
            result *= base;
        }
        if (exponent > 0) {
            return formatNumber(result);
        } else {
            return formatNumber(1 / result);
        }
    }

    @Override
    public double root(int a) {
        return formatNumber(Math.sqrt(a));
    }
    //radical de ordin n din a
    @Override
    public double root(double a, double n) {
        return formatNumber(Math.pow(a, 1 / n));
    }

    @Override
    public long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= Math.abs(n); i++) {
            result *= i;
        }
        if(n<0){
            return 0;
        }
        return result;
    }

    @Override
    public long factorialRecursive(int n) {
        //  n! = n*(n-1)! -> 5! = 5*4!
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return n * factorialRecursive(n - 1);
        } else {
            throw new IllegalArgumentException("You can not calculate factorial for negative numbers");
        }
    }

    public double calculate(String stringToCalculate) {
        //System.out.println(stringToCalculate);
        //s=2+2, s=operand + operand + operand etc, \\+ -> pt a escapa un caracter
        try {
            return Double.parseDouble(stringToCalculate);
        } catch (NumberFormatException e) {

            if (stringToCalculate.contains("(")) {
//                int startIndex = stringToCalculate.indexOf("(");
//                int endIndex = stringToCalculate.indexOf(")");

                //TEMA: operatii cu paranteze in paranteze
                int startLastIndex = stringToCalculate.lastIndexOf("("); //ultima paranteza deschisa
                int endIndex = startLastIndex + 1;
                while (stringToCalculate.charAt(endIndex) != ')') {
                    endIndex++;
                }

                String left = stringToCalculate.substring(0, startLastIndex);
                String right = stringToCalculate.substring(endIndex + 1);
                String center = stringToCalculate.substring((startLastIndex + 1), endIndex);

                Double result = calculate(center);
                return calculate(left + result + right);

            } else {
                for (String o : operators) {
                    int index = stringToCalculate.lastIndexOf(o);
                    if (index == -1) {
                        continue; //skip la iteratie daca nu exista operatorul in string
                    }
                    //2*-3
                    String leftSide = stringToCalculate.substring(0, index);
                    if (index != 0 && (leftSide.trim().charAt(leftSide.trim().length() - 1) == '+' || leftSide.trim().charAt(leftSide.trim().length() - 1) == '-' ||
                            leftSide.trim().charAt(leftSide.trim().length() - 1) == '*' || leftSide.trim().charAt(leftSide.trim().length() - 1) == '/')) {
                        continue;
                    }
                    Double leftOperand = index == 0 ? 0.0 : calculate(leftSide);
                    Double rightOperand = calculate(stringToCalculate.substring(index + 1));

                    switch (o) {
                        case "+":
                            return add(leftOperand, rightOperand);
                        case "-":
                            return substract(leftOperand, rightOperand);
                        case "^":
                            return pow(leftOperand, rightOperand);
                        case "$":
                            return root(leftOperand,rightOperand);
                        case "%":
                            return leftOperand % rightOperand;
                        case "*":
                            return multiply(leftOperand, rightOperand);
                        case "/":
                            return divide(leftOperand, rightOperand);
                        default:
                            throw new IllegalArgumentException("Invalid operator: " + o);
                    }
                }
                throw new RuntimeException("Operators field needs to have at least 1 value");
            }

        }
    }
}
