package com.quid.aop.timer;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class ExecutionTimer {

    @Pointcut("@annotation(com.quid.aop.timer.Timer)")
    private void timer(){};

    @Around("timer()")
    public void AssumeExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        joinPoint.proceed();
        stopWatch.stop();


        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();

        log.info("실행 메서드 :{}, 걸린시간 \n{}",methodName, stopWatch.prettyPrint());
    }
}