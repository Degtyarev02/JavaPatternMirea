package com.example.EX18.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MainAOP {
    long timeStart;

    @Before("execService()")
    public void setTimeStart(JoinPoint joinPoint) {
        log.info("Method name: " + joinPoint.getSignature().getName());
        timeStart = System.currentTimeMillis();
    }

    @Pointcut("within(com.example.EX18.Service.*)")
    public void execService() {

    }

    @After("execService()")
    public void getExecTime(){
        log.info("Execution time:" + (System.currentTimeMillis()-timeStart));
    }
}
