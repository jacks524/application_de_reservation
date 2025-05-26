package com.example.Model;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

/*
 * il sagit de la classe Conference qui herite de Evenement cette derniere aura pour but de creer un evenement conference
 */
public class Conference extends Evenement {
    String theme;
    List<String> intervenants = new ArrayList<>(); // cette liste est celle dans laquelle on retrouvera les intervenants
                                                   // de notre conference

    public Conference() {

    }

    public Conference(String id, String nom, LocalDateTime date, String lieu, int capaciteMax,
            String theme) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.capaciteMax = capaciteMax;
        this.theme = theme;
    }

    public void ajouterintervenants(String nom) {
        intervenants.add(nom);
    }

    public void supprimerintervenants(String nom) {
        intervenants.remove(nom);
    }

    @Override
    public void annuler() {

        System.out.println("annuler" + nom);
    }

    @Override
    public void afficherDetails() {

        System.out.println("Conference" + nom + "sur" + theme);
    }

}