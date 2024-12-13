package com.example.demo;

public class AdaptateurVGAEnHDMI implements HDMI {
    private EcranVGA ecranVGA;

    public AdaptateurVGAEnHDMI(EcranVGA ecranVGA) {
        this.ecranVGA = ecranVGA;
    }

    @Override
    public void afficherEtat(String etat) {
        ecranVGA.afficher(etat);
    }
}
