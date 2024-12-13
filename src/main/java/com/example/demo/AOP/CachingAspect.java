package com.example.demo.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class CachingAspect {

    private final Map<String, Object> cache = new HashMap<>();

    @Around("@annotation(Cachable)")
    public Object cacheMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();

        if (cache.containsKey(key)) {
            System.out.println("Returning cached result for: " + key);
            return cache.get(key);
        }

        Object result = joinPoint.proceed();
        cache.put(key, result);
        System.out.println("Caching result for: " + key);
        return result;
    }
}

