package com.example.ecommerce.shared.aspects.infrastructure;

import com.example.ecommerce.shared.domain.errorhandler.exceptions.ECommerceException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLogAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(ControllerLogAspect.class);

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void logControllerEntry() {
    }

    @Before("logControllerEntry()")
    public void logBefore(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        Object[] pathVariables = joinPoint.getArgs();
        LOGGER.info("Executing call to {}.{} with args {}", className, method, pathVariables);
    }

    @Around("logControllerEntry()")
    public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info("Method {} executed in {} ms", joinPoint.getSignature().getName(), end - start);
        return result;
    }

    @AfterThrowing(value = "execution(* com.example.ecommerce..*.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        LOGGER.error("Method {}.{} throwed exception {}", className, method, exception.getMessage());
    }

}
