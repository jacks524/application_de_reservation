package com.example.Model;

import java.time.LocalDateTime;

public class Concert extends Evenement {
    String artiste;
    String genreMusical;

    private Concert(String id, String nom, LocalDateTime date, String lieu, int capaciteMax, String artiste,
            String genreMusical) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.capaciteMax = capaciteMax;
        this.artiste = artiste;
        this.genreMusical = genreMusical;
    }

    @Override
    public void annuler() {
        System.out.println("Concert annulé" + nom);
    }

    @Override
    public void afficherDetails() {
        System.out.println("Concert" + nom + "de" + artiste + "(" + genreMusical + ")");
    }

}
