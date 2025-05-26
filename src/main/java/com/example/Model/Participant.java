package com.example.Model;

import com.example.observer.ParticipantObserver;

public class Participant implements ParticipantObserver {
    String id;
    String nom;
    String email;

    public Participant(String id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void RecevoirMessage(String message) {
        System.out.println("Notiication pour" + nom + ":" + message);
    }

}
