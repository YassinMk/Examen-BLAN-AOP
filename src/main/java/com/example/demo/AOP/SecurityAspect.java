package com.example.demo.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class SecurityAspect {

    private final String currentUserRole = "admin"; // Simulated current user role

    @Before("@annotation(securedBy)")
    public void checkAccess(SecuredBy securedBy) {
        List<String> allowedRoles = Arrays.asList(securedBy.roles());
        if (!allowedRoles.contains(currentUserRole)) {
            throw new SecurityException("Access denied for role: " + currentUserRole);
        }
        System.out.println("Access granted for role: " + currentUserRole);
    }
}

