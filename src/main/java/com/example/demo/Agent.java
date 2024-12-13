package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Agent {
    private String nom;
    private List<Transaction> transactions;
    private List<Agent> observers;
    private NotificationStrategy strategy;

    public Agent(String nom) {
        this.nom = nom;
        this.transactions = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.strategy = new DefaultStrategy(); // Default strategy
    }

    public void ajouterTransaction(Transaction transaction) {
        transactions.add(transaction);
        notifierObservers(transaction);
    }

    public void notifierObservers(Transaction transaction) {
        NotificationEvent event = new NotificationEvent(nom, transaction);
        for (Agent observer : observers) {
            observer.recevoirNotification(event);
        }
    }

    public void recevoirNotification(NotificationEvent event) {
        strategy.executeNotification(event);
    }

    public void definirStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public Transaction transactionPlusGrande() {
        return transactions.stream()
                .max((t1, t2) -> Double.compare(t1.getMontant(), t2.getMontant()))
                .orElse(null);
    }

    public void ajouterObserver(Agent observer) {
        observers.add(observer);
    }

    public String getNom() {
        return nom;
    }
}
