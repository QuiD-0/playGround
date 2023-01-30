package com.quid.designPattern.pipeline;

import org.junit.jupiter.api.Test;

public class PipelineStarter {

    @Test
    public void Pipeline() {
        ValidateCondition validateCondition = ValidateCondition.of();
        Pipe.of(new ConditionA())
            .addPipe(new ConditionB())
            .addPipe(new ConditionC())
            .execute(validateCondition);
    }

    record ValidateCondition(Boolean A, Boolean B, Boolean C) {

        public static ValidateCondition of() {
            return new ValidateCondition(true, true, true);
        }
    }

}
