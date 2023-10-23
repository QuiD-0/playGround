package com.quid.designPattern.behavioral.interpreter.expression;

import java.util.Map;

public interface PostfixExpression {

    int interpret(Map<Character, Integer> context);

    static PostfixExpression plus(PostfixExpression left, PostfixExpression right) {
        return new PlusExpression(left, right);
    }

    static PostfixExpression minus(PostfixExpression left, PostfixExpression right) {
        return new MinusExpression(left, right);
    }

    static PostfixExpression variable(char name) {
        return new VariableExpression(name);
    }
}
