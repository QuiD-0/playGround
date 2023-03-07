package com.quid.designPattern.behavioral.interpreter;

import com.quid.designPattern.behavioral.interpreter.expression.PostfixExpression;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void interpreterTest() {
        PostfixExpression expression = PostfixParser.parse("xyz+-a+");
        Map<Character, Integer> x = Map.of('x', 1, 'y', 2, 'z', 3, 'a', 4);
        int result = expression.interpret(x);
        System.out.println(result);
    }

}
