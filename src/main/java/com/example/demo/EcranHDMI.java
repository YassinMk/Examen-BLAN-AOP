package com.example.demo;

public class EcranHDMI implements HDMI {
    @Override
    public void afficherEtat(String etat) {
        System.out.println("Affichage via HDMI: " + etat);
    }
}
