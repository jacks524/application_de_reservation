package com.example.Model;

import java.time.LocalDateTime;

/*
 * il sagit de la classe Concert qui herite de Evenement cette derniere aura pour but de creer un concert
 */
public class Concert extends Evenement {
    String artiste;
    String genreMusical;
    private final String type="concert";
    public Concert() {

    }
    public String getType(){
        return type;
    }

    public Concert(String id, String nom, LocalDateTime date, String lieu, int capaciteMax, String artiste,
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
        System.out.println("Concert annulé" + nom); // cette methode sert a annuler un concert existant
    }

    @Override
    public void afficherDetails() {
        System.out.println("Concert" + nom + "de" + artiste + "(" + genreMusical + ")");// cette methode sert a afficher
                                                                                        // les details d un concert
                                                                                        // existant
    }

}
