package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        // Création des agents
        Agent agent1 = new Agent("Agent1");
        Agent agent2 = new Agent("Agent2");
        Agent agent3 = new Agent("Agent3");

        // Ajouter des observateurs
        agent1.ajouterObserver(agent2);
        agent1.ajouterObserver(agent3);

        // Création des transactions
        Transaction transaction1 = new Transaction.Builder()
                .setId("TXN001")
                .setDate(new Date())
                .setMontant(1000.0)
                .setType(Transaction.TransactionType.VENTE)
                .build();

        Transaction transaction2 = new Transaction.Builder()
                .setId("TXN002")
                .setDate(new Date())
                .setMontant(2000.0)
                .setType(Transaction.TransactionType.ACHAT)
                .build();

        // Ajouter des transactions
        agent1.ajouterTransaction(transaction1);
        agent1.ajouterTransaction(transaction2);

        // Vérifier la transaction avec le plus grand montant
        System.out.println("Transaction avec le plus grand montant : " + agent1.transactionPlusGrande());

        // Gestion du conteneur d'agents
        AgentContainer container = AgentContainer.getInstance();
        container.ajouterAgent(agent1.getNom(), agent1);
        container.ajouterAgent(agent2.getNom(), agent2);
        container.ajouterAgent(agent3.getNom(), agent3);

        // Afficher l'état du conteneur
        container.afficherEtat();
    }

}
