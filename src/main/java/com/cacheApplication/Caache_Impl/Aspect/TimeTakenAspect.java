package com.cacheApplication.Caache_Impl.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TimeTakenAspect {

    @Around("execution(* com.cacheApplication.Caache_Impl.Controller.EmployeeController.*(..))")
    public Object calTimeTaken(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        log.info("Method called [ {} ]",proceedingJoinPoint.getSignature().getName());

        Long inTime = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        Long outTime = System.currentTimeMillis();

        log.info("Time Taken by  [ {} ] is [ {} ]ms",proceedingJoinPoint.getSignature().getName(),outTime-inTime);

        return  result;
    }




}
