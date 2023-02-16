package com.quid.designPattern.behavioral.pipeline;

import com.quid.designPattern.behavioral.pipeline.PipelineStarter.ValidateCondition;

public class ConditionA implements Pipe<ValidateCondition> {

    @Override
    public ValidateCondition execute(ValidateCondition input) {
        System.out.println("check condition A");
        if (!input.A()) {
            throw new RuntimeException("Condition A is not satisfied");
        }
        return input;
    }
}
