package com.example.Model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import com.example.Model.exception.CapaciteMaxAtteintException;
import com.example.observer.EvenementObservable;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Conference.class, name = "conference"),
        @JsonSubTypes.Type(value = Concert.class, name = "concert")
})
public abstract class Evenement implements EvenementObservable {
    protected String id;
    protected String nom;
    protected LocalDateTime date;
    protected String lieu;
    protected int capaciteMax;
    List<Participant> participants = new ArrayList<>();

    public List<Participant> getParticaipantparEmail(String e) {
        return participants.stream().filter(p -> p.getEmail().endsWith("@" + e)).collect(Collectors.toList());
    }

    public long getNombreParticipants() {
        return participants.stream().count();
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public boolean ajouterParticiapant(Participant p) throws CapaciteMaxAtteintException {
        if (participants.size() >= capaciteMax) {
            throw new CapaciteMaxAtteintException("La capacite maximale pour " + nom + "a été atteinte");

        }
        if (participants.contains(p)) {
            System.out.println("le participant du nom de " + p.getNom() + "est deja inscrit");
        }
        return participants.add(p);

    }

    @Override
    public void ajouterEvenementObservable(Participant p) {
        if (!participants.contains(p)) {
            participants.add(p);
        }

    }

    @Override
    public void SupprimerEvenementObservable(Participant p) {
        participants.remove(p);
    }

    @Override
    public void notifierEvenementObservable(String message) {
        for (Participant p : participants) {
            p.RecevoirMessage(message);
        }
    }

    public abstract void annuler();

    public abstract void afficherDetails();

}
