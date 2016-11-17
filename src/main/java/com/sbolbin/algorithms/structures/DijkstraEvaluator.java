package com.sbolbin.algorithms.structures;

import java.util.Arrays;
import java.util.List;

public class DijkstraEvaluator {
    public static void main(String[] args) {
        String expr = "((2 + 3) * 2) - (3 * 3)";
        System.out.println(evaluate(expr));
    }

    private static final List<Character> OPERANDS = Arrays.asList('+', '-', '*');

    public static double evaluate(String expression) {
        Stack<Character> operands = new LinkedStack<>();
        Stack<Double> values = new LinkedStack<>();
        for (char ch: normalizeExpr(expression).toCharArray()) {
            if(OPERANDS.contains(ch)) {
                operands.push(ch);
            } else if(ch == ')') {
                values.push(calculate(operands.pop(), values.pop(), values.pop()));
            } else if(ch != '('){
                values.push(Double.parseDouble(Character.valueOf(ch).toString()));
            }
        }

        return  values.pop();
    }

    private static String normalizeExpr(String expr) {
        return ("(" + expr + ")").replaceAll(" ", "");
    }

    private static double calculate(char operator, double val1, double val2) {
        if(operator == '+') return val2 + val1;
        if(operator == '-') return val2 - val1;
        if(operator == '*') return val2 * val1;

        throw new IllegalArgumentException("Undefined operator: " + operator);
    }


}

