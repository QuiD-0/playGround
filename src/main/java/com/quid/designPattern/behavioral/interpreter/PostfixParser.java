package com.quid.designPattern.behavioral.interpreter;

import com.quid.designPattern.behavioral.interpreter.expression.PostfixExpression;
import java.util.Stack;

public class PostfixParser {

    public static PostfixExpression parse(String expression) {
        Stack<PostfixExpression> stack = new Stack<>();
        for (char s : expression.toCharArray()) {
            stack.push(getExpression(stack, s));
        }
        return stack.pop();
    }

    private static PostfixExpression getExpression(Stack<PostfixExpression> stack, char s) {
        switch (s) {
            case '+' -> {
                PostfixExpression right = stack.pop();
                PostfixExpression left = stack.pop();
                return PostfixExpression.plus(left, right);
            }
            case '-' -> {
                PostfixExpression right = stack.pop();
                PostfixExpression left = stack.pop();
                return PostfixExpression.minus(left, right);
            }
            default -> {
                return PostfixExpression.variable(s);
            }
        }
    }
}
