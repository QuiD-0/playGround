package com.quid.designPattern.behavioral.interpreter.expression;

import java.util.Map;

public class VariableExpression implements PostfixExpression {

    private char name;

    public VariableExpression(char name) {
        this.name = name;
    }

    @Override
    public int interpret(Map<Character, Integer> context) {
        return context.get(name);
    }


}
