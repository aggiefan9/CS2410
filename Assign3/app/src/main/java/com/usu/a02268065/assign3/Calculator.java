package com.usu.a02268065.assign3;

public class Calculator {
    public static double evaluate(String string) {
        String[] lexemes = string.split(" ");

        try {
            if (lexemes.length == 1) {
                return Double.parseDouble(lexemes[0]);
            } else if (lexemes.length % 2 == 0) {
                throw new ArithmeticException("Invalid Expression");
            } else {
                boolean mode = false;
                double result = Double.parseDouble(lexemes[0]);
                String operator = lexemes[1];
                for(int i=2; i<lexemes.length; i++) {
                    if (mode) {
                        operator = lexemes[i];
                        mode = false;
                    } else {
                        switch (operator) {
                            case "+":
                                result = result + Double.parseDouble(lexemes[i]);
                                break;
                            case "-":
                                result = result - Double.parseDouble(lexemes[i]);
                                break;
                            case "*":
                                result = result * Double.parseDouble(lexemes[i]);
                                break;
                            case "/":
                                result = result / Double.parseDouble(lexemes[i]);
                                break;
                            default:
                                throw new ArithmeticException("Invalid Operator");
                        }
                        mode = true;
                    }
                }
                return result;
            }
        } catch (RuntimeException e) {
            return Double.NaN;
        }
    }
}
