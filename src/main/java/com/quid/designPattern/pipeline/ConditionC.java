package com.quid.designPattern.pipeline;

import com.quid.designPattern.pipeline.PipelineStarter.ValidateCondition;

public class ConditionC implements Pipe<ValidateCondition> {

    @Override
    public ValidateCondition execute(ValidateCondition input) {
        System.out.println("check condition C");
        if (!input.C()) {
            throw new RuntimeException("Condition C is not satisfied");
        }
        return input;
    }

}
