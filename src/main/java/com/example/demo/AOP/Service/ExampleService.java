package com.example.demo.AOP.Service;

import com.example.demo.AOP.Cachable;
import com.example.demo.AOP.Log;
import com.example.demo.AOP.SecuredBy;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @Log
    public void executeTask() {
        System.out.println("Executing task...");
        // Simulation d'une tâche longue
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Cachable
    public String fetchData() {
        System.out.println("Fetching data from database...");
        return "Data";
    }

    @SecuredBy(roles = {"admin", "manager"})
    public void secureOperation() {
        System.out.println("Performing a secure operation...");
    }
}

