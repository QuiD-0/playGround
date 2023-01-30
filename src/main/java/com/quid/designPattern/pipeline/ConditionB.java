package com.quid.designPattern.pipeline;

import com.quid.designPattern.pipeline.PipelineStarter.ValidateCondition;

public class ConditionB implements Pipe<ValidateCondition> {

    @Override
    public ValidateCondition execute(ValidateCondition input) {
        System.out.println("check condition B");
        if (!input.B()) {
            throw new RuntimeException("Condition B is not satisfied");
        }
        return input;
    }
}

