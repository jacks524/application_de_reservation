package com.example.Model;

import java.util.List;
import java.util.ArrayList;

public class Organisateur extends Participant {
    List<Evenement> evenementsOrganises = new ArrayList<>();

    public Organisateur(String id, String nom, String email) {
        super(id, nom, email);
    }

    public void ajouterEvenemnts(Evenement E) {
        evenementsOrganises.add(E);
    }
}
