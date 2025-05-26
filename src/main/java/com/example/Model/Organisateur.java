/*
 * il sagit d une classe heritiere de Participant qui a la particularite de pouvoir ajouter des evenements
 */
package com.example.Model;

import java.util.List;
import java.util.ArrayList;

public class Organisateur extends Participant {
    List<Evenement> evenementsOrganises = new ArrayList<>(); // cette liste est la liste des evenements qui seront
                                                             // ajouter par l organisateur

    public Organisateur(String id, String nom, String email) {
        super(id, nom, email);
    }

    public void ajouterEvenemnts(Evenement E) {
        evenementsOrganises.add(E);
    }
}
