package com.example.demo;

import java.util.HashMap;

class AgentContainer {
    private static AgentContainer instance;
    private HashMap<String, Agent> agents;

    private AgentContainer() {
        agents = new HashMap<>();
    }

    public static AgentContainer getInstance() {
        if (instance == null) {
            instance = new AgentContainer();
        }
        return instance;
    }

    public void ajouterAgent(String nom, Agent agent) {
        agents.put(nom, agent);
    }

    public void supprimerAgent(String nom) {
        agents.remove(nom);
    }

    public Agent rechercherAgent(String nom) {
        return agents.get(nom);
    }

    public void afficherEtat() {
        agents.values().forEach(agent -> {
            System.out.println("Agent: " + agent.getNom());
        });
    }
}
