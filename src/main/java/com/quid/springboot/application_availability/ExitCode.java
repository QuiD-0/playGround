package com.quid.springboot.application_availability;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

@Component
public class ExitCode implements ExitCodeGenerator {

    @Override
    public int getExitCode() {
        return 42;
    }
}
