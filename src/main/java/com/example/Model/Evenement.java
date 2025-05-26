/*
 * il sagit de la classe abstraite evenement qui sera la classe mere dans laquelle les evenements seront creer 
 */
package com.example.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.Model.exception.CapaciteMaxAtteintException;
import com.example.observer.EvenementObservable;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Conference.class, name = "conference"),
        @JsonSubTypes.Type(value = Concert.class, name = "concert")

}) // cette configuration fait en sorte que chaque evenement qui sera stocke dans
   // le fichier json pourra etre identifier s il est du type concert ou conference
public abstract class Evenement implements EvenementObservable {
    protected String id;
    protected String nom;
    protected LocalDateTime date;
    protected String lieu;
    protected int capaciteMax;
    List<Participant> participants = new ArrayList<>();

    public Evenement() {

    }

    public List<Participant> getParticaipantparEmail(String e) {
        return participants.stream().filter(p -> p.getEmail().endsWith("@" + e)).collect(Collectors.toList());
    }

    public long getNombreParticipants() {
        return participants.stream().count();
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

    public Evenement(String id, String nom, LocalDateTime date, String lieu, int capaciteMax) {
        this(); // Appelle le constructeur sans argument pour initialiser participants
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.capaciteMax = capaciteMax;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean supprimerParicipant(Participant p) {
        participants.remove(p);
        System.out.println("Particaipant supprimé");
        return true;
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
